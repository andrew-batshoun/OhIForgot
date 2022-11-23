package com.organization.OhIForgot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	private String email;
	
	@Column(name = "user_name")
	private String username;

	@Column(name="password")
	private String password;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//	private List<Task> tasks;

	public User() {
	}

	public User(Long id, String email, String username, String password) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
//		this.tasks = tasks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
//	public List<Task> getTasks() {
//        return tasks;
//    }
//
//    public void setPosts(List<Task> tasks) {
//        this.tasks = tasks;
//    }

}
