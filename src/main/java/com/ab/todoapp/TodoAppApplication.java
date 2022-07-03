package com.ab.todoapp;

import com.ab.todoapp.entity.Todo;
import com.ab.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Todo> todos = new ArrayList<>();

		todos.add(new Todo(1L,"Alışveriş Yap"));
		todos.add(new Todo(2L,"Arabayı Yıka"));
		todos.add(new Todo(3L,"Faturayı Öde"));
		todoRepository.saveAll(todos);
	}
}
