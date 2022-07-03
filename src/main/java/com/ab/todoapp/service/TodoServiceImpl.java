package com.ab.todoapp.service;

import com.ab.todoapp.entity.Todo;
import com.ab.todoapp.exception.TodoNotFound;
import com.ab.todoapp.mapper.TodoMapper;
import com.ab.todoapp.model.TodoRequest;
import com.ab.todoapp.model.TodoResponse;
import com.ab.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public List<TodoResponse> getAllTodos() {

        return TodoMapper.INSTANCE.convertToTodoResponses(todoRepository.findAll());
    }

    @Override
    public TodoResponse getTodoById(Long todoId) {

        final Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new TodoNotFound("Todo with id :" + todoId + " could not be found."));

        return TodoMapper.INSTANCE.convertToTodoResponse(todo);
    }

    @Override
    public TodoResponse addTodo(TodoRequest todoRequest) {

        todoRepository.save(TodoMapper.INSTANCE.convertToTodo(todoRequest));
        return TodoMapper.INSTANCE.convertFromTodoRequestToTodoResponse(todoRequest);
    }

    @Override
    public String deleteAllTodos() {

        todoRepository.deleteAll();
        return "Deleted all todos";
    }

    @Override
    public String deleteTodoById(Long todoId) {

        final Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new TodoNotFound("Todo with id :" + todoId + " could not be found."));
        todoRepository.delete(todo);

        return "Deleted todo with "+ todoId + " id";
    }

    @Override
    public TodoResponse updateTodoById(Long todoId, TodoRequest todoRequest) {

        final Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new TodoNotFound("Todo with id :" + todoId + " could not be found."));

        final Todo updatedTodo = TodoMapper.INSTANCE.convertToTodo(todoRequest);
        updatedTodo.setId(todo.getId());

        todoRepository.save(updatedTodo);
        return TodoMapper.INSTANCE.convertToTodoResponse(updatedTodo);
    }
}
