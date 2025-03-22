package com.JpetStore.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.JpetStore.pages.Homepage;
import com.JpetStore.pages.UserRegistrationPage;
import com.JpetStore.utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistration {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	UserRegistrationPage registerpage = new UserRegistrationPage(driver, test);
	Homepage homepage = new Homepage(driver, test);

	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
		try {
			homepage.clickEnterToTheStoreLink();
			registerpage.navigateToLoginPage();
			System.out.println("Navigated to login page");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

	@Given("I navigate to the user registration page")
	public void i_navigate_to_the_user_registration_page() {

		try {
			registerpage.clickRegisterNow();
			System.err.println("Registration page is opened");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

	@When("I enter valid registration details and submit")
	public void i_enter_valid_registration_details_and_submit() {

		try {
			registerpage.enterRegistrationDetails();
			System.out.println("Registration details are entered");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

	@Then("my account should be created successfully")
	public void my_account_should_be_created_successfully() {

		try {
			Assert.assertTrue(registerpage.verifyRegistration());
			System.out.println("Registration is done");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

	@When("I enter valid credentials {string} and {string}")
	public void i_enter_valid_credentials_and(String username, String password) {

		try {
			registerpage.enterLoginDetails(username, password);
			System.out.println("Entered Username and password");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}

	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {

		try {
			Assert.assertTrue(registerpage.verifyMyAccountLink(), "Login unsuccessful");
			System.out.println("Login successful");
			// registerpage.clickLogout();
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

	@When("I enter invalid credentials {string} and {string}")
	public void i_enter_invalid_credentials_and(String username, String password) {

		try {
			registerpage.enterLoginDetails(username, password);
			System.out.println("Entered Username and password");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

	@Then("I should see an error message {string}")
	public void i_should_see_an_error_message(String expectedMessage) {
		
		try {
			Assert.assertTrue(registerpage.verifyInvalidLogin(expectedMessage));
			System.out.println("error message is displayed");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

	@When("I try to log in with empty username and password fields {string} and {string}")
	public void i_try_to_log_in_with_empty_username_and_password_fields_and(String username, String pass) {
		
		try {
			registerpage.enterLoginDetails(username, pass);
			System.out.println("Entered Username and password");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

	@Then("I should see error message {string}")
	public void i_should_see_error_message(String expectedMessage) {
		
		try {
			Assert.assertTrue(registerpage.verifyEmptyLogin(expectedMessage));
			System.out.println("error message is displayed");
		} catch (Exception e) {
			Assert.fail("Error Occured: " + e.getMessage());
		}
	}

//	@Given("I navigate to the password recovery page")
//	public void i_navigate_to_the_password_recovery_page() 
//	{
//		
//	}
//
//	@When("I enter my registered email and submit the request")
//	public void i_enter_my_registered_email_and_submit_the_request() 
//	{
//	    
//	}
//
//	@Then("I should receive a password reset link in my email")
//	public void i_should_receive_a_password_reset_link_in_my_email() 
//	{
//	    
//	}

}
