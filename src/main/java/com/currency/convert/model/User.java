package com.currency.convert.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.currency.convert.enums.Country;
import com.currency.convert.validator.BDate;
import com.currency.convert.validator.Email;

/**
 * @author yeshendra Entity class for User
 *
 */
@Entity
public class User {

	public User() {

	}

	public User(String username, String email, String password, String confirmPassword, Date dob, String postalAddress,
			String street, Integer zipcode, String city, Country country, Set<Role> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateOfBirth = dob;
		this.postalAddress = postalAddress;
		this.street = street;
		this.zipCode = zipcode;
		this.city = city;
		this.country = country;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@NotBlank(message = "Please input user name")
	@Size(min = 6, max = 16)
	private String username;

	@Email(message = "Email must be of form abc@mail.com")
	@NotBlank(message = "Please input valid email address")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Please input valid password")
	@Size(min = 6)
	private String password;

	@NotBlank(message = "Please input value")
	private String confirmPassword;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "Date of birth cannot be left blank")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@BDate(message = "Birthdate should be between 31-03-1960 to 31-03-2000")
	private Date dateOfBirth;

	@NotBlank(message = "Postal address cannot be blank")
	private String postalAddress;

	@NotBlank(message = "Please input valid street name")
	private String street;

	@NotNull(message = "Please input valid zipcode in numerics only")
	private Integer zipCode;

	@NotBlank(message = "Please input valid city name")
	private String city;

	@NotNull(message = "Please input valid country name")
	@Enumerated(EnumType.ORDINAL)
	private Country country;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", dateOfBirth=" + dateOfBirth + ", postalAddress="
				+ postalAddress + ", street=" + street + ", zipCode=" + zipCode + ", city=" + city + ", country="
				+ country + ", roles=" + roles + "]";
	}

}
