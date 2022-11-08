package com.organization.OhIForgot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
	public void deleteTask(int id) {
		Iterator<Task> it = tasks.iterator();
		while(it.hasNext()) {
			Task task = it.next();
			if(id == task.getId()) {
				it.remove();
			}
		}
		
	}

	@Override
	public List<Task> listTasks() {
		return tasks;
		
	}
	
	@Override
	public void isComplete(Task task, boolean bool) {
		findTaskById(task.getId()).setCompleted(bool);
	}
	
	private static List<Task> populateTasks(){
		List<Task> tasks =new ArrayList<>();
		tasks.add(new Task(++fakeId, "Wash and dry clothes", "11/1/2022", true));
		tasks.add(new Task(++fakeId, "Pick up dogfood", "11/8/2022", false));
		tasks.add(new Task(++fakeId, "Study for exam", "11/3/2022", "11/20/2022", false));
		
		return tasks; 
		
	}
}
