package com.rest.poll.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "polls")
public class Poll implements Serializable {

    private int id;
    private String name;
    private Date dateStart;
    private Date dateFinish;
    private boolean activity;

    public Poll(int id, String name, Date dateStart, Date dateFinish, boolean activity) {
        this.id = id;
        this.name = name;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.activity = activity;
    }

    public Poll() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "date_start")
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Column(name = "date_finish")
    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    @Column(name = "activity")
    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Poll[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", activity=" + activity +
                ']';
    }
}

