package com.training.ToDoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ToDoItem {

    private Long id;
    private String title;
    private boolean done;

    public ToDoItem() {

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ToDoItem(String title, Long id, boolean done) {
        this.title = title;
        this.id = id;
        this.done = done;
    }
}
