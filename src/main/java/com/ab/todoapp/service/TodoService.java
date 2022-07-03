package com.ab.todoapp.service;

import com.ab.todoapp.entity.Todo;
import com.ab.todoapp.model.TodoRequest;
import com.ab.todoapp.model.TodoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface TodoService {
    List<TodoResponse> getAllTodos();
    TodoResponse getTodoById(Long todoId);
    TodoResponse addTodo(TodoRequest todoRequest);
    String deleteAllTodos();
    String deleteTodoById(Long todoId);
    TodoResponse updateTodoById(Long todoId,TodoRequest todoRequest);


}
