package com.nagarro.flightsearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.nagarro.flightsearch.constants.Constants;

/**
 * The class {@link Login} is a model class.<br>
 * This class contains the parameters associated with user's login credentials.
 * 
 * @author jagratigoyal
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	@NotEmpty(message = Constants.FIELD_EMPTY_ERROR)
	private String name;

	@Column(nullable = false, unique = true)
	@NotEmpty(message = Constants.FIELD_EMPTY_ERROR)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
