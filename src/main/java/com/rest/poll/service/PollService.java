package com.rest.poll.service;

import com.rest.poll.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollService extends JpaRepository<Poll, Integer> {

}
