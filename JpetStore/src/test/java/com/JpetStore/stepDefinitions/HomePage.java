package com.JpetStore.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.JpetStore.pages.Homepage;
import com.JpetStore.utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class HomePage 
{
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	Homepage homepage=new Homepage(driver, test);
	
	@Given("I navigate to the JPetStore home page {string}")
    public void i_navigate_to_the_j_pet_store_home_page(String pageURL) 
	{
        try {
        	Assert.assertTrue(homepage.verifyURL(pageURL), "URL verification failed!");
            System.out.println("Homepage is verified");
		} catch (Exception e) {
			Assert.fail("Error Occured: "+e.getMessage());
		}
    }

    @Then("I verify the page title is {string}")
    public void i_verify_the_page_title_is(String expectedTitle) 
    {
        try {
        	Assert.assertTrue(homepage.verifyTitle(expectedTitle), "Title verification failed!");
            System.out.println("Title is verified");
		} catch (Exception e) {
			Assert.fail("Error Occured: "+e.getMessage());
		}
    }

    @And("I Enter to the store")
    public void i_enter_to_the_store() 
    {
        try {
    	homepage.clickEnterToTheStoreLink();
        System.out.println("Entering to the store");
        }catch(Exception e) {
        	Assert.fail("Error Occured: "+e.getMessage());
        }
    }

}
