package com.organization.OhIForgot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.organization.OhIForgot.model.Task;
import com.organization.OhIForgot.service.TaskService;


@Controller
public class TasksController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/tasks", method = RequestMethod.GET)
	public ModelAndView task() {
		return new ModelAndView("tasksPage", "command", new Task());
	}

	@RequestMapping(value="/tasks/tasklist", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> fetchTasks(){
		return new ResponseEntity<List<Task>>(taskService.listTasks(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tasks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveTask (@RequestBody Task task){
		taskService.saveTask(task);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}