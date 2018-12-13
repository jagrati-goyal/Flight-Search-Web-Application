package com.nagarro.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.api.UserDao;
import com.nagarro.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public User getUser(String name, String password) {
		Session session = sessionFactory.getCurrentSession();	
		Query<User> query = session.createQuery("from User u where u.name = :name and u.password = :password");
		query.setParameter("name", name);
		query.setParameter("password", password);
		return query.uniqueResult();
	}
}
