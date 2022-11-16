package com.organization.OhIForgot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.OhIForgot.model.Task;
import com.organization.OhIForgot.service.TaskService;

@Controller
public class TasksController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public ModelAndView task() {
		return new ModelAndView("tasksPage", "command", new Task());
	}

	@RequestMapping(value = "/tasks/tasklist", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> listTasks() {
		return new ResponseEntity<List<Task>>(taskService.listTasks(), HttpStatus.OK);
	}

	@RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> getTask(@PathVariable("id") long id) {
		System.out.println("Fetching Task with id " + id);
		Task task = taskService.findTaskById(id);
		if (task == null) {
			System.out.println("Task with id " + id + " not found");
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveTask(@RequestBody Task task) {
		if (taskService.findTaskById(task.getId()) != null) {
            System.out.println("A Task with id " + task.getId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

		taskService.saveTask(task);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Task> updateTask(@PathVariable("id") long id, @RequestBody Task task) {
	        System.out.println("Updating task " + id);
	          
	        Task currentTask = taskService.findTaskById(id);
	          
	        if (currentTask==null) {
	            System.out.println("Task with id " + id + " not found");
	            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
	        }
	  
	        currentTask.setDescription(task.getDescription());
	        currentTask.setDueDate(task.getDueDate());
;	        
	          
	        taskService.updateTask(currentTask);
	        return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Task> deleteTask(@PathVariable("id") long id) {
	        System.out.println("Retrieving & Deleting Task with id " + id);
	  
	        Task task = taskService.findTaskById(id);
	        if (task == null) {
	            System.out.println("Unable to delete. Task with id " + id + " not found");
	            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
	        }
	  
	        taskService.deleteTask(id);
	        return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
	    }
	 
	 
}