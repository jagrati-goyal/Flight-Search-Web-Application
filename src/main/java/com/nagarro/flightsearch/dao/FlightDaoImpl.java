package com.nagarro.flightsearch.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.flightsearch.constants.HQLConstants;
import com.nagarro.flightsearch.dao.api.FlightDao;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;

/**
 * The class {@link FlightDaoImpl} provides the actual implementation of the
 * operations that interact with DB. <br>
 * The user can not directly use this class, instead use
 * {@link FlightServiceImpl} class for performing database operations.
 * 
 * @author jagratigoyal
 * @see FlightServiceImpl
 */
@Repository
public class FlightDaoImpl implements FlightDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Flight flight) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(flight);
	}

	@Override
	@Transactional
	public List<Flight> retrieveMatchedFlights(FlightSearchParameters searchParams) {
		Session session = sessionFactory.getCurrentSession();
		// equal to %e% for economic class,this means if the flight class
		// contains e then include it
		String flightClass = "%" + searchParams.getFlightClass() + "%";
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
		Root<Flight> root = criteriaQuery.from(Flight.class);
		criteriaQuery.select(root).where(
				criteriaBuilder.equal(root.get(HQLConstants.FIELD_DEPARTURE_LOCATION),
						searchParams.getDepartureLocation().toUpperCase()),
				criteriaBuilder.equal(root.get(HQLConstants.FIELD_ARRIVAL_LOCATION),
						searchParams.getArrivalLocation().toUpperCase()),
				criteriaBuilder.greaterThanOrEqualTo(root.get(HQLConstants.FIELD_VALID_TILL), searchParams.getDate()),
				criteriaBuilder.like(root.get(HQLConstants.FIELD_FLIGHT_CLASS), flightClass.toUpperCase()));

		if ("F".equalsIgnoreCase(searchParams.getOutputPreference())) {
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get(HQLConstants.FIELD_FARE)));
		} else if ("FD".equalsIgnoreCase(searchParams.getOutputPreference())) {
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get(HQLConstants.FIELD_FARE)),
					criteriaBuilder.asc(root.get(HQLConstants.FILED_DURATION)));
		}
		Query<Flight> query = session.createQuery(criteriaQuery);
		return  query.getResultList();
	}

	@Override
	@Transactional
	public void deleteAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Flight> query = session.createQuery(HQLConstants.QUERY_DELETE_FLIGHT);
		query.executeUpdate();
	}

}
