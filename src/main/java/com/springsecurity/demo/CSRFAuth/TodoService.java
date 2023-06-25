package com.springsecurity.demo.CSRFAuth;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private static List<TODO> todoList = new ArrayList<>();

    static {
        todoList.add(new TODO("Murat", "Learn Spring"));
        todoList.add(new TODO("Karakurt", "Learn Java"));
        todoList.add(new TODO("Murat", "Learn JS"));
        todoList.add(new TODO("Karakurt", "Learn JS"));
    }

    public List<TODO> retrieveAllTodos() {
        return todoList;
    }

    public List<TODO> findByUsername(String username) {
        Predicate<TODO> userFilter = todo -> todo.getAuthor().equals(username);
        return todoList.stream().filter(userFilter).collect(Collectors.toList());
    }

    public void addTodo(TODO todo) {
        todoList.add(todo);
    }
}
