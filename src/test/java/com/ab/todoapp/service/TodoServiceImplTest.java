package com.ab.todoapp.service;

import com.ab.todoapp.entity.Todo;
import com.ab.todoapp.model.TodoRequest;
import com.ab.todoapp.model.TodoResponse;
import com.ab.todoapp.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TodoServiceImplTest {

    @InjectMocks
    private TodoServiceImpl todoServiceImpl;

    @Mock
    private TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        todoServiceImpl = new TodoServiceImpl(todoRepository);
    }


    @Test
    void shouldGetAllTodos() {

        // Given

        final List<TodoResponse> todoResponses = TodoServiceProvider.getTodoResponses();

        final List<Todo> todos = TodoServiceProvider.getTodos();

        // When

        when(todoRepository.findAll()).thenReturn(todos);

        final List<TodoResponse> allTodos = todoServiceImpl.getAllTodos();

        //Then

        Assertions.assertEquals(allTodos, todoResponses);

    }

    @Test
    void shouldGetTodoById() {

        // Given

        final TodoResponse todoResponse = TodoServiceProvider.getTodoResponse();

        final Todo todo = TodoServiceProvider.getTodo();


        when(todoRepository.findById(1L)).thenReturn(Optional.ofNullable(todo));

        // When


        final TodoResponse todoResponseById = todoServiceImpl.getTodoById(1L);

        //Then

        Assertions.assertEquals(todoResponse, todoResponseById);
    }

    @Test
    void shouldAddTodo() {

        final TodoRequest todoRequest = TodoServiceProvider.getTodoRequest();
        todoServiceImpl.addTodo(todoRequest);
    }

    @Test
    void deleteAllTodos() {

        // Given

        final List<Todo> todos = TodoServiceProvider.getTodos();

        // When

        when(todoRepository.findAll()).thenReturn(todos);

        // Then

        todoServiceImpl.deleteAllTodos();

        Mockito.verify(todoRepository).deleteAll();

    }

    @Test
    void shouldDeleteUserById() {

        // Given

        final Todo todo = TodoServiceProvider.getTodo();

        // When

        when(todoRepository.findById(1L)).thenReturn(Optional.ofNullable(todo));

        todoServiceImpl.deleteTodoById(todo.getId());

        // Then

        Mockito.verify(todoRepository).delete(todo);
    }

    @Test
    void shouldUpdateTodoById() {

        // Given

        final TodoRequest todoRequest = TodoServiceProvider.getTodoRequest();

        final TodoResponse todoResponse = TodoServiceProvider.getTodoResponse();

        final Todo todo = TodoServiceProvider.getTodo();

        // When

        when(todoRepository.findById(1L)).thenReturn(Optional.ofNullable(todo));

        when(todoRepository.save(todo)).thenReturn(todo);

        final TodoResponse updateTodoById = todoServiceImpl.updateTodoById(1L,todoRequest);

        // Then

        Assertions.assertEquals(todoResponse, updateTodoById);
    }

}
