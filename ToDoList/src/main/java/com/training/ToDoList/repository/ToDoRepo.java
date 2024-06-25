package com.training.ToDoList.repository;

import com.training.ToDoList.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDoItem, Long> {
    List<ToDoItem> findByDone(boolean done);
}
