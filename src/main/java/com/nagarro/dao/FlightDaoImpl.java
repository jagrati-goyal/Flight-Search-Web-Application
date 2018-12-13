package com.nagarro.dao;

import java.util.ArrayList;
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

import com.nagarro.dao.api.FlightDao;
import com.nagarro.model.Flight;
import com.nagarro.model.FlightSearchParameters;

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
		List<Flight> matchedFlights = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		String flightClass = "%" + searchParams.getFlightClass() + "%";
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
		Root<Flight> root = criteriaQuery.from(Flight.class);
		/*
		 * Criterion depLocCriteria = Restrictions.eq("departureLocation",
		 * searchParams.getDepartureLocation()); Criterion arrLocCriteria =
		 * Restrictions.eq("arrivalLocation",
		 * searchParams.getArrivalLocation()); Criterion validTillCriteria =
		 * Restrictions.ge("validtill", searchParams.getDate()); Criterion
		 * flightClassCriteria = Restrictions.like("flightClass", flightClass);
		 * Conjunction allCriteria = Restrictions.and(depLocCriteria,
		 * arrLocCriteria, validTillCriteria, flightClassCriteria);
		 */
		criteriaQuery.select(root).where(
				criteriaBuilder.equal(root.get("departureLocation"), searchParams.getDepartureLocation().toUpperCase()),
				criteriaBuilder.equal(root.get("arrivalLocation"), searchParams.getArrivalLocation().toUpperCase()),
				criteriaBuilder.greaterThanOrEqualTo(root.get("validTill"), searchParams.getDate()),
				criteriaBuilder.like(root.get("flightClass"), flightClass.toUpperCase()));

		switch (searchParams.getOutputPreference()) {
		case "F":
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get("fare")));
			break;
		case "FD":
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get("fare")), criteriaBuilder.asc(root.get("duration")));
			break;
		}

		Query<Flight> query = session.createQuery(criteriaQuery);
		matchedFlights = query.getResultList();
		return matchedFlights;
	}

}
