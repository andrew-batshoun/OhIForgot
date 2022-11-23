package com.organization.OhIForgot.model;


import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name ="tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="description")
	private String description;
	
//	@DateTimeFormat(pattern ="dd/MM/yyyy")
	@Column(name="due_date")
	private String dueDate;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;

	public Task() {
	}

	public Task(Long id, String description) {
		this.id = id;
		this.description = description;
//		this.user = user; 
		

	}

	public Task(Long id, String description, String dueDate) {
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
//		this.user = user; 
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

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	

}
