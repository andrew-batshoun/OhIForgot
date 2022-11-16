package com.organization.OhIForgot.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
	private Long id;
	private String description;
	
	private String dueDate;

	public Task() {
	}

	public Task(Long id, String description) {
		this.id = id;
		this.description = description;

	}

	public Task(Long id, String description, String dueDate) {
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
	

}
