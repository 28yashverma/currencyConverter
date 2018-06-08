package com.currency.convert.model.builder;

/**
 * Builder pattern for User class
 */
import java.util.Date;
import java.util.Set;

import com.currency.convert.enums.Country;
import com.currency.convert.model.Role;
import com.currency.convert.model.User;

public class UserBuilder {

	public UserBuilder() {

	}

	private String username;
	private String email;
	private String password;
	private String confirmPassword;
	private Date dateOfBirth;
	private String postalAddress;
	private String street;
	private Integer zipCode;
	private String city;
	private Country country;
	private Set<Role> roles;

	public UserBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}

	public UserBuilder setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public UserBuilder setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
		return this;
	}

	public UserBuilder setStreet(String street) {
		this.street = street;
		return this;
	}

	public UserBuilder setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public UserBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public UserBuilder setCountry(Country country) {
		this.country = country;
		return this;
	}

	public UserBuilder setRoles(Set<Role> roles) {
		this.roles = roles;
		return this;
	}

	public User build() {
		return new User(username, email, password, confirmPassword, dateOfBirth, postalAddress, street, zipCode, city,
				country, roles);
	}

}
