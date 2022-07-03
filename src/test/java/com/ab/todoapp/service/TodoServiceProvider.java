package com.ab.todoapp.service;

import com.ab.todoapp.entity.Todo;
import com.ab.todoapp.model.TodoRequest;
import com.ab.todoapp.model.TodoResponse;

import java.util.ArrayList;
import java.util.List;

class TodoServiceProvider {
    protected static TodoRequest getTodoRequest()
    {
        final TodoRequest todoRequest = new TodoRequest();

        todoRequest.setContent("DenemeContent");

        return todoRequest;
    }

    protected static TodoResponse getTodoResponse()
    {
        final TodoResponse todoResponse = new TodoResponse();

        todoResponse.setContent("DenemeContent");

        return todoResponse;
    }

    protected static Todo getTodo()
    {
        final Todo todo = new Todo();

        todo.setId(1L);
        todo.setContent("DenemeContent");

        return todo;
    }

    protected static List<Todo> getTodos()
    {
        final List<Todo> todos = new ArrayList<>();

        todos.add(getTodo());
        todos.add(getTodo());
        todos.add(getTodo());

        return todos;
    }

    protected static List<TodoResponse> getTodoResponses()
    {
        final List<TodoResponse> todoResponses = new ArrayList<>();

        todoResponses.add(getTodoResponse());
        todoResponses.add(getTodoResponse());
        todoResponses.add(getTodoResponse());

        return todoResponses;
    }

}
