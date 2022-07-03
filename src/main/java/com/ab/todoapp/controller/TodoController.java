package com.ab.todoapp.controller;

import com.ab.todoapp.model.TodoRequest;
import com.ab.todoapp.model.TodoResponse;
import com.ab.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos()
    {
        final List<TodoResponse> response = todoService.getAllTodos();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long todoId)
    {
        final TodoResponse response = todoService.getTodoById(todoId);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> addTodo(@RequestBody TodoRequest todoRequest)
    {
        final TodoResponse response = todoService.addTodo(todoRequest);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAllTodos()
    {
        final String response = todoService.deleteAllTodos();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodoById(@PathVariable Long todoId)
    {
        final String response = todoService.deleteTodoById(todoId);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{todoId}")
    public ResponseEntity<TodoResponse> updateTodoById(@PathVariable Long todoId, @RequestBody TodoRequest requestUpdateTodo)
    {
        final TodoResponse response = todoService.updateTodoById(todoId,requestUpdateTodo);

        return ResponseEntity.ok(response);
    }
}
