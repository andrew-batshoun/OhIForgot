package com.organization.OhIForgot.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.organization.OhIForgot.model.Task;
import com.organization.OhIForgot.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	private static AtomicLong fakeId = new AtomicLong();
	private static List<Task> tasks = new ArrayList<Task>();
	static {
		tasks = populateTasks();	
		}
	
	private static List<Task> populateTasks(){
		
		Task task1 = new Task(); 
		task1.setId(fakeId.incrementAndGet());
		task1.setDescription("Wash and dry clothes");
	
		
		Task task2 = new Task(); 
		task2.setId(fakeId.incrementAndGet());
		task2.setDescription("Pick up dogfood");
		
		
		Task task3 = new Task(); 
		task3.setId(fakeId.incrementAndGet());
		task3.setDescription("Study for exam");
		
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
	
		
		return tasks; 
		
	}
	
	@Override
	public List<Task> listTasks() {
		return tasks;
	}
	
	@Override
	public Task findTaskById(Long id) {
		for(Task task: tasks) {
			if(id == task.getId()) {
				return task; 
			}
		}
		return null; 
	}


	@Override
	public void saveTask(Task task) {
		task.setId(fakeId.incrementAndGet());
		tasks.add(task);
			
	}

	@Override
	public Task updateTask(Task task) {
		tasks.set(tasks.indexOf(task), task);
		return task;
	}

	@Override
	public void deleteTask(Long id) {
		Iterator<Task> it = tasks.iterator();
		while(it.hasNext()) {
			Task task = it.next();
			if(id == task.getId()) {
				it.remove();
			}
		}
		
	}

	

	
}
