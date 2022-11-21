package com.organization.OhIForgot.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.organization.OhIForgot.model.User;


@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public User findById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from User where id = :id");
		query.setParameter("id", id);
		return (User) query.getResultList();
	}

	@Override
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(user);
		
	}

	@Override
	public void updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(user);
		
	}

	@Override
	public void deleteUser(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from User where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
		
	}

	@Override
	public List<User> findAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery <User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

}
