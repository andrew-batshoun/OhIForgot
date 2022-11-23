package com.organization.OhIForgot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.organization.OhIForgot.model.Task;
import com.organization.OhIForgot.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TasksController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public ResponseEntity<List<Task>> listTasks() {
		return new ResponseEntity<List<Task>>(taskService.listTasks(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Void> saveTask(@RequestBody Task task) {
		if (taskService.findTaskById(task.getId()) != null) {
			System.out.println("A task with the id " + task.getId() + " already exsit");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") long id, @RequestBody Task task) {
		System.out.println("Updating task " + id);

		Task currentTask = taskService.findTaskById(id);

		if (currentTask == null) {
			System.out.println("Task with id " + id + " not found");
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		}

		currentTask.setDescription(task.getDescription());
		currentTask.setDueDate(task.getDueDate());
		

		taskService.updateTask(currentTask);
		return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
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