package org.pac1uk.todolistspringboot.controller;

import org.pac1uk.todolistspringboot.model.TodoItem;
import org.pac1uk.todolistspringboot.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.pac1uk.todolistspringboot.model.User;
import org.pac1uk.todolistspringboot.repo.UserRepo;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private ToDoRepo todoRepo;

    @GetMapping
    public List<TodoItem> findAll(@RequestParam(required = false) Boolean done) {
        if (done != null) {
            return todoRepo.findByDone(done);
        }
        return todoRepo.findAll();
    }
    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public TodoItem save(@RequestBody TodoItem todoItem) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userRepo.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("not found"));

        todoItem.setUser(currentUser);

        return todoRepo.save(todoItem);
    }
    @PutMapping
    public TodoItem update(@RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoRepo.deleteById(id);
    }
}