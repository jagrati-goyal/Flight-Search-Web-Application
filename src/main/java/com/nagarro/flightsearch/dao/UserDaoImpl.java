package com.nagarro.flightsearch.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.flightsearch.constants.HQLConstants;
import com.nagarro.flightsearch.dao.api.UserDao;
import com.nagarro.flightsearch.model.User;

/**
 * The class {@link UserDaoImpl} provides implementation for the {@link UserDao}
 * methods. <br>
 * This class performs the actual interaction with the database. <br>
 * <br>
 * The user cannot directly use this class,instead use {@link LoginServiceImpl}
 * class for performing data base operations.
 * 
 * @author jagratigoyal
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public User getUser(String name, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery(HQLConstants.QUERY_SELECT_USER);
		query.setParameter(HQLConstants.QUERY_NAME_PARAM, name);
		query.setParameter(HQLConstants.QUERY_PASSWORD_PARAM, password);
		return query.uniqueResult();
	}
}
