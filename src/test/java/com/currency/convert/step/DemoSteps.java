package com.currency.convert.step;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.currency.convert.CurrencyConverterApplication;
import com.currency.convert.enums.Country;
import com.currency.convert.model.Role;
import com.currency.convert.model.User;
import com.currency.convert.model.builder.UserBuilder;
import com.currency.convert.repository.UserRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import cucumber.api.java.en.Given;

@SpringBootTest(classes = CurrencyConverterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class DemoSteps {

	@Autowired
	private UserRepository userRepo;

	@Given("^I try to save the information in database$")
	@Transactional
	public void i_try_to_save_the_information_in_database() throws Throwable {
		Set<Role> s = new HashSet<>();
		s.add(new Role("USER"));
		User user = new UserBuilder().setUsername("demoUser").setPassword("dS8@ioshk").setConfirmPassword("dS8@ioshk")
				.setEmail("dask@mail.com").setPostalAddress("Lucknow").setCountry(Country.INDIA).setStreet("Lcuknow")
				.setCity("Lucknow").setZipCode(226028).setDateOfBirth(new Date()).setRoles(s).build();
		userRepo.save(user);
	}

	@Given("^I am able to save the information$")
	@Transactional
	public void i_am_able_to_save_the_information() throws Throwable {
		User user = userRepo.findByusername("demoUser");
		assertNotNull("Retrieved object is null ", user);
	}

}
