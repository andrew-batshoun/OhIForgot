package com.organization.OhIForgot.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.organization.OhIForgot.model.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Task findTaskById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Task.class, id);
	}

	@Override
	public void saveTask(Task task) {
		task.setId(0L);
		System.out.print(task.getId());
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(task);
		
	}

	@Override
	public void updateTask(Task task) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(task);
		
	}

	@Override
	public void deleteTask(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Task task = session.byId(Task.class).load(id);
		session.delete(task);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> listTasks() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery <Task> cq = cb.createQuery(Task.class);
		Root<Task> root = cq.from(Task.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	

}
