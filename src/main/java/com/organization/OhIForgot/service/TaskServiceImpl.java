package com.organization.OhIForgot.service;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.OhIForgot.dao.TaskDAO;
import com.organization.OhIForgot.model.Task;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDAO taskDAO;

	@Override
	@Transactional
	public Task findTaskById(Long id) {
		return taskDAO.findTaskById(id);
	}

	@Override
	@Transactional
	public void saveTask(Task task) {
		taskDAO.saveTask(task);
		
	}

	@Override
	@Transactional
	public void updateTask(Task task) {
		taskDAO.updateTask(task);
		
	}

	@Override
	@Transactional
	public void deleteTask(Long id) {
		taskDAO.deleteTask(id);
		
	}

	@Override
	@Transactional
	public List<Task> listTasks() {
		return taskDAO.listTasks();
	}
	
}
