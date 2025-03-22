package com.JpetStore.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.JpetStore.pages.Homepage;
import com.JpetStore.pages.ProductDetailsPage;
import com.JpetStore.pages.ShoppingCartPage;
import com.JpetStore.pages.UserRegistrationPage;
import com.JpetStore.utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCart 
{
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	ProductDetailsPage productpage =new ProductDetailsPage(driver, test);
	Homepage homepage=new Homepage(driver, test);
	UserRegistrationPage registerpage=new UserRegistrationPage(driver, test);
	ShoppingCartPage cartpage=new ShoppingCartPage(driver, test);
	
	@Given("I enter the store and sign in")
	public void i_enter_the_store_and_sign_in() 
	{
		try {
			homepage.clickEnterToTheStoreLink();
			System.out.println("On the homepage");
			registerpage.navigateToLoginPage();
			registerpage.enterLoginDetails("kamal2002", "kamses2002");
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@When("I choose a pet {string}")
	public void i_choose_a_pet(String pet) 
	{
	    try {
	    	productpage.selectPetCategory(pet);
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	    
	}

	@And("I select a product {string}, item {string} and add it to the cart")
	public void i_select_a_product_item_and_add_it_to_the_cart(String product, String item) 
	{
	    try {
	    	productpage.selectProduct(product);
		    productpage.selectItem(item);
		    productpage.addToCart();
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
   
	}

	@And("I return to the main menu and select another pet {string}")
	public void i_return_to_the_main_menu_and_select_another_pet(String pet) 
	{
	    try {
	    	productpage.returnToMainMenu();
		    productpage.selectPetCategory(pet);
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	    
	    
	}

	@And("I select another product {string}, item {string} and add it to the cart")
	public void i_select_another_product_item_and_add_it_to_the_cart(String product, String item) 
	{
		try {
			productpage.selectProduct(product);
		    productpage.selectItem(item);
		    productpage.addToCart();
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@And("I update the quantity of one product")
	public void i_update_the_quantity_of_one_product() 
	{
	    
	}
	
	@And("I remove one product from the cart")
	public void i_remove_one_product_from_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@And("I proceed to checkout")
	public void i_proceed_to_checkout() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@And("I continue after address confirmation")
	public void i_continue_after_address_confirmation() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I confirm and verify the order")
	public void i_confirm_and_verify_the_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}

