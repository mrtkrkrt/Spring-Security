package com.springsecurity.demo.CSRFAuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CSRFAuthController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private TodoService todoService;

    public CSRFAuthController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<TODO> retrieveAllTodos() {
        return todoService.retrieveAllTodos();
    }

    @GetMapping("/users/{username}/todos")
    public List<TODO> findByAuthor(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpesificUser(@PathVariable String username, @RequestBody TODO todo) {
        todoService.addTodo(todo);
    }
}
