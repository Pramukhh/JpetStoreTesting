package com.JpetStore.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.JpetStore.pages.Homepage;
import com.JpetStore.pages.SearchFunctionalityPage;
import com.JpetStore.utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFunctionality 
{
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	SearchFunctionalityPage searchpage =new SearchFunctionalityPage(driver, test);
	Homepage homepage=new Homepage(driver, test);
	
	@Given("I am on the JPetStore home page")
	public void i_am_on_the_j_pet_store_home_page() 
	{
		try {
			homepage.clickEnterToTheStoreLink();
			searchpage.verifyPetHomePage();
			System.out.println("On the homepage");
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}	
	}

	@When("I search for {string}")
	public void i_search_for(String keyword) 
	{
	    try {
	    	searchpage.enterSearchKeyword(keyword);
		    searchpage.clickSearchButton();
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@Then("I should see search results related to pet")
	public void i_should_see_search_results_related_to_pet() 
	{
	    try {
	    	searchpage.verifySearchResults();
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@And("I select a pet from searched result")
	public void i_select_a_pet_from_searched_result() 
	{
	    try {
	    	searchpage.selectThePetFromSearch();
		    System.out.println("Pet is selected");
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@And("I get the price and description")
	public void i_get_the_price_and_description() 
	{
		 try {
			 System.out.println("Displaying product details:");
		        searchpage.getDescription();
		        searchpage.getPriceDetails();
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@Then("I add the product to cart")
	public void i_add_the_product_to_cart() 
	{
		try {
			 searchpage.addToCartFromSearch();
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

}
