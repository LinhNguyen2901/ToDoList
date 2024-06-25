package com.training.ToDoList.service;

import com.training.ToDoList.model.ToDoItem;
import com.training.ToDoList.repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepo toDoRepo;

    @Autowired
    public ToDoService(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    public List<ToDoItem> getAll() {
        return toDoRepo.findAll();
    }

    public ToDoItem saveOrUpdateToDo(ToDoItem toDoItem) {
        return toDoRepo.save(toDoItem);
    }

    public void deleteToDoById(Long id) {
        toDoRepo.deleteById(id);
    }

    public void deleteDoneToDo() {
        List<ToDoItem> doneItem = toDoRepo.findByDone(true);
        toDoRepo.deleteAll(doneItem);
    }
}
