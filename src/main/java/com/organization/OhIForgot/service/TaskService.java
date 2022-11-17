package com.organization.OhIForgot.service;

import java.util.List;

import com.organization.OhIForgot.model.Task;

public interface TaskService {
	
	Task findTaskById(Long id);
	void saveTask(Task task);
	void updateTask(Task task);
	void deleteTask(Long id);
	List<Task> listTasks();
	
	
}
