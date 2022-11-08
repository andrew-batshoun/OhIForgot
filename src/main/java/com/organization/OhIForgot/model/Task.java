package com.organization.OhIForgot.model;

public class Task {
   private Long id; 
   private String description; 
   private String startDate; 
   private String endDate; 
   private boolean isCompleted;
   
public Task() {}

public Task(Long id, String description, String startDate,boolean isCompleted) {
	this.id = id;
	this.description = description;
	this.startDate = startDate;
	this.isCompleted = isCompleted;
}

public Task(Long id, String description, String startDate, String endDate, boolean isCompleted) {
	this.id = id;
	this.description = description;
	this.startDate = startDate;
	this.endDate = endDate;
	this.isCompleted = isCompleted;
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

public String getStartDate() {
	return startDate;
}

public void setStartDate(String startDate) {
	this.startDate = startDate;
}

public String getEndDate() {
	return endDate;
}

public void setEndDate(String endDate) {
	this.endDate = endDate;
}

public boolean isCompleted() {
	return isCompleted;
}

public void setCompleted(boolean isCompleted) {
	this.isCompleted = isCompleted;
}


   
   
}
