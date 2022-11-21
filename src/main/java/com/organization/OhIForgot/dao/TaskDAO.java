package com.organization.OhIForgot.dao;

import java.util.List;

import com.organization.OhIForgot.model.Task;

public interface TaskDAO {
	
	public Task findTaskById(Long id);
	public void saveTask(Task task);
	public void updateTask(Task task);
	public void deleteTask(Long id);
	public List<Task> listTasks();
}
