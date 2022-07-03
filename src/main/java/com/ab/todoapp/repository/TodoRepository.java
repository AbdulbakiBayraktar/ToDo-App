package com.ab.todoapp.repository;

import com.ab.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    @Override
    Optional<Todo> findById(Long aLong);
}
