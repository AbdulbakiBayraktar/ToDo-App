package com.ab.todoapp.mapper;

import com.ab.todoapp.entity.Todo;
import com.ab.todoapp.model.TodoRequest;
import com.ab.todoapp.model.TodoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@MapperConfig
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    TodoResponse convertToTodoResponse(Todo todo);
    Todo convertToTodo(TodoRequest todoRequest);
    TodoResponse convertFromTodoRequestToTodoResponse(TodoRequest todoRequest);
    List<TodoResponse> convertToTodoResponses(List<Todo> todoList);
}
