package com.currency.convert.step;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.currency.convert.CurrencyConverterApplication;
import com.currency.convert.model.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@SpringBootTest(classes = CurrencyConverterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class DemoSteps {

	@Autowired
	private TestRestTemplate restTemplate;
	private ResponseEntity<User> responseEntity;

	@Given("^I call GET on /login$")
	public void i_call_GET_on_login() throws Throwable {
		this.responseEntity = restTemplate.getForEntity("http://localhost:8080", User.class);

	}

	@Then("^the response status is (\\d+)$")
	public void the_response_status_is(int arg1) throws Throwable {
		Assert.assertEquals(arg1, responseEntity.getStatusCode().value());
	}

}
