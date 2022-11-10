package com.organization.OhIForgot.service;

import java.util.List;

import com.organization.OhIForgot.model.Task;

public interface TaskService {
	
	Task findTaskById(long id);
	void saveTask(Task task);
	void updateTask(Task task);
	void deleteTask(long id);
	List<Task> listTasks();
	
	
}
