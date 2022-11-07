package model;

import org.springframework.stereotype.Controller;

@Controller
public class Task {
	
	private int id; 
	private String startDate;
	private String description; 
	private String dueDate;
	private boolean isCompleted;
	
	public Task() {}
	
	public Task(int id, String startDate, String description, String dueDate, boolean isCompleted) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id; 
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
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

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	} 
	
	
	
	
	
}
