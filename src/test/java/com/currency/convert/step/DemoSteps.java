package com.currency.convert.step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.currency.convert.CurrencyConverterApplication;
import com.currency.convert.enums.Country;
import com.currency.convert.model.User;
import com.currency.convert.repository.UserRepository;

import cucumber.api.java.en.Given;

@SpringBootTest(classes = CurrencyConverterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class DemoSteps {

	@Autowired
	private UserRepository userRepo;

	private User user = new User();
	// @Given("^I try to save the information in database$")
	// @Transactional
	// public void i_try_to_save_the_information_in_database() throws Throwable {
	// Set<Role> s = new HashSet<>();
	// s.add(new Role("USER"));
	// User user = new
	// UserBuilder().setUsername("demoUser").setPassword("dS8@ioshk").setConfirmPassword("dS8@ioshk")
	// .setEmail("dask@mail.com").setPostalAddress("Lucknow").setCountry(Country.INDIA).setStreet("Lcuknow")
	// .setCity("Lucknow").setZipCode(226028).setDateOfBirth(new
	// Date()).setRoles(s).build();
	// userRepo.save(user);
	// }
	//
	// @Given("^I am able to save the information$")
	// @Transactional
	// public void i_am_able_to_save_the_information() throws Throwable {
	// User user = userRepo.findByusername("demoUser");
	// assertNotNull("Retrieved object is null ", user);
	// }

	@Given("^I input the username as \"([^\"]*)\"$")
	public void i_input_the_username_as(String username) throws Throwable {
		user.setUsername(username);
	}

	@Given("^provide the password as \"([^\"]*)\"$")
	public void provide_the_password_as(String password) throws Throwable {
		user.setPassword(password);
	}

	@Given("^provide the confirm password as \"([^\"]*)\"$")
	public void provide_the_confirm_password_as(String confirmPassword) throws Throwable {
		user.setConfirmPassword(confirmPassword);
	}

	@Given("^provide the email as \"([^\"]*)\"$")
	public void provide_the_email_as(String email) throws Throwable {
		user.setEmail(email);
	}

	@Given("^provide the postal address as \"([^\"]*)\"$")
	public void provide_the_postal_address_as(String postalAddress) throws Throwable {
		user.setPostalAddress(postalAddress);
	}

	@Given("^provide the street as \"([^\"]*)\"$")
	public void provide_the_street_as(String street) throws Throwable {
		user.setStreet(street);
	}

	@Given("^provide the zipcode as \"([^\"]*)\"$")
	public void provide_the_zipcode_as(String zipcode) throws Throwable {
		user.setZipCode(Integer.valueOf(zipcode));
	}

	@Given("^provide the city as \"([^\"]*)\"$")
	public void provide_the_city_as(String city) throws Throwable {
		user.setCity(city);
	}

	@Given("^provide the country as \"([^\"]*)\"$")
	public void provide_the_country_as(Country country) throws Throwable {
		user.setCountry(country);
	}

	@Given("^provide the dob as \"([^\"]*)\"$")
	public void provide_the_dob_as(String date) throws Throwable {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = format.parse(date);
		user.setDateOfBirth(d);
	}

	@Given("^I am able to save the information$")
	public void i_am_able_to_save_the_information() throws Throwable {
		User u = userRepo.save(user);
		System.out.println(u);
	}

}
