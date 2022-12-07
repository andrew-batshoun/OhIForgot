package com.organization.OhIForgot.model;


import java.time.LocalDate;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;





public class Task {
	

	private Long id;
	
	
	private String description;
	
	
	private Date dueDate;
	


	public Task() {
	}

	public Task(Long id, String description) {
		this.id = id;
		this.description = description;


	}

	public Task(Long id, String description, Date dueDate) {
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	

}
