package com.organization.OhIForgot.dao;

import java.util.ArrayList;
import java.util.List;

import com.organization.OhIForgot.model.Task;
import com.organization.OhIForgot.service.TaskService;

public class TaskServiceImpl implements TaskService{
	private static Long fakeId = new Long(0);
	private static List<Task> tasks;
	static {
		tasks = populateTasks();	
		}
	
	
	@Override
	public Task findTaskById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task findTaskByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Task> listTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static List<Task> populateTasks(){
		List<Task> tasks =new ArrayList<>();
		return null; 
		
	}
}
