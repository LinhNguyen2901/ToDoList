package com.training.ToDoList.controller;

import com.training.ToDoList.model.ToDoItem;
import com.training.ToDoList.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDoItem> getAll() {
        return toDoService.getAll();
    }

    @PostMapping
    public ResponseEntity<ToDoItem> addToDo(@RequestBody ToDoItem toDoItem) {
        ToDoItem addedToDo = toDoService.saveOrUpdateToDo(toDoItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedToDo);
    }

    @PutMapping
    public ResponseEntity<ToDoItem> updateToDo(@RequestBody ToDoItem toDoItem) {
        ToDoItem updatedToDo = toDoService.saveOrUpdateToDo(toDoItem);
        return ResponseEntity.ok(updatedToDo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        toDoService.deleteToDoById(id);
        return ResponseEntity.noContent().build();
    }
}