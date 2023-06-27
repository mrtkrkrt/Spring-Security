package com.springsecurity.demo.CSRFAuth;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'murat")
    @RolesAllowed({"ADMIN", "USER"})
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<TODO> findByAuthor(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpesificUser(@PathVariable String username, @RequestBody TODO todo) {
        todoService.addTodo(todo);
    }
}
