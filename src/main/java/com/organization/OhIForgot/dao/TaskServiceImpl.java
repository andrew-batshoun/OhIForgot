package com.organization.OhIForgot.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.OhIForgot.model.Task;
import com.organization.OhIForgot.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	private static Long fakeId = new Long(0);
	private static List<Task> tasks = new ArrayList<Task>();
	static {
		tasks = populateTasks();	
		}
	
	private static List<Task> populateTasks(){
		
		Task task1 = new Task(); 
		task1.setId(++fakeId);
		task1.setDescription("Wash and dry clothes");
	
		
		Task task2 = new Task(); 
		task2.setId(++fakeId);
		task2.setDescription("Pick up dogfood");
		
		
		Task task3 = new Task(); 
		task3.setId(++fakeId);
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
	public Task findTaskById(long id) {
		for(Task task: tasks) {
			if(id == task.getId()) {
				return task; 
			}
		}
		return null; 
	}


	@Override
	public void saveTask(Task task) {
		task.setId(++fakeId);
		tasks.add(task);
;		
	}

	@Override
	public void updateTask(Task task) {
		tasks.set(tasks.indexOf(task), task);
		
	}

	@Override
	public void deleteTask(long id) {
		Iterator<Task> it = tasks.iterator();
		while(it.hasNext()) {
			Task task = it.next();
			if(id == task.getId()) {
				it.remove();
			}
		}
		
	}

	
//	public static void main(String[] args) {
//		
//		
//		System.out.println(tasks);
//	}
	
}
