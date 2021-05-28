package com.devopsassignment.Momento;

import com.devopsassignment.Momento.controller.TaskController;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.devopsassignment.Momento.service.TaskService;
import com.devopsassignment.Momento.model.Task;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.*;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.times;

@SpringBootTest
public class MomentoApplicationTests {

	public TaskController cut;

	@Mock
	public TaskService mockTaskService;

	@BeforeEach
	public void setUp() {
		mockTaskService = mock(TaskService.class);
		cut = new TaskController(mockTaskService);
	}


	@Test
	void getTasksTest() {
		List<Task> mockTasks = new ArrayList<>();
		Task mockTask = new Task();
		mockTasks.add(mockTask);
		List<Task> mockTasks1 = new ArrayList<>();
		TaskController spy = Mockito.spy(cut);
		doReturn(mockTasks).when(mockTaskService)
          .getTasks();
		mockTasks1=spy.getTasks();
		verify(mockTaskService, times(1)).getTasks();
	}

	@Test
	void postTaskTest() {
		Task mockTask = new Task();
		Task mockTask1 = new Task();
		TaskController spy = Mockito.spy(cut);
		doReturn(mockTask).when(mockTaskService)
          .saveTask(mockTask);
		mockTask1=spy.postTask(mockTask);
		verify(mockTaskService, times(1)).saveTask(mockTask);
	}

	@Test
	void getTaskTest() {
		long mockId = 123;
		Task mockTask = new Task();
		Optional<Task> mockT = Optional.of(mockTask);
		Task mockTask1 = new Task();
		TaskController spy = Mockito.spy(cut);
		doReturn(mockT).when(mockTaskService)
          .findById(mockId);
		mockTask1=spy.getTask(mockId);
		verify(mockTaskService, times(1)).findById(mockId);
	}

	@Test
	void deleteTaskTest() {
		long mockId = 123;
		TaskController spy = Mockito.spy(cut);
		doNothing().when(mockTaskService).deleteById(mockId);
		spy.deleteTask(mockId);
		verify(mockTaskService, times(1)).deleteById(mockId);
	}

	@Test
	void updateTaskTest() {
		long mockId = 123;
		Task mockTask = new Task();
		Optional<Task> mockT = Optional.of(mockTask);
		Task mockTask1 = new Task();
		TaskController spy = Mockito.spy(cut);
		doReturn(mockT).when(mockTaskService)
          .findById(mockId);
		mockTask1=spy.updateTask(mockTask, mockId);
		verify(mockTaskService, times(1)).findById(mockId);
	}

}
