package com.rest.poll.controller;

import com.rest.poll.exception.ResourceNotFoundException;
import com.rest.poll.model.Poll;
import com.rest.poll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MainRestController {

    @Autowired
    private PollService pollService;

    @GetMapping("/polls")
    public List<Poll> getAllPolls(){
        return pollService.findAll();
    }

    @GetMapping("/polls/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        Poll poll = pollService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Poll not found for this id ::" + id));
        return ResponseEntity.ok().body(poll);
    }

    @PostMapping("/polls")
    public Poll newPoll(@Valid @RequestBody Poll poll){
        return pollService.save(poll);
    }

    @PutMapping("/polls/{id}")
    public ResponseEntity<Poll> updatePoll(@PathVariable(value = "id") int id, @Valid @RequestBody Poll component)
            throws ResourceNotFoundException {
        Poll poll = pollService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Poll not found for this id ::" + id));
        poll.setId(component.getId());
        poll.setName(component.getName());
        poll.setDateStart(component.getDateStart());
        poll.setDateFinish(component.getDateFinish());
        poll.setActivity(component.isActivity());
        final Poll updatePoll = pollService.save(poll);
        return ResponseEntity.ok(updatePoll);
    }

    @DeleteMapping("/polls/{id}")
    public Map<String, Boolean> deletePoll(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException{
        Poll poll = pollService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Poll not found for this id ::" + id));
        pollService.delete(poll);
        Map<String, Boolean> responce = new HashMap<>();
        responce.put("deleted", Boolean.TRUE);
        return responce;
    }
}
