package com.JpetStore.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.JpetStore.pages.Homepage;
import com.JpetStore.pages.ProductDetailsPage;
import com.JpetStore.utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetails 
{
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	ProductDetailsPage productpage =new ProductDetailsPage(driver, test);
	Homepage homepage=new Homepage(driver, test);
	
	@Given("I navigate to the homepage")
	public void i_navigate_to_the_homepage() 
	{
		try {
			homepage.clickEnterToTheStoreLink();
			productpage.verifyPetHomePage();
			System.out.println("On the homepage");
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@When("I select a pet category {string}")
	public void i_select_a_pet_category(String pet) 
	{
	    try {
	    	productpage.selectPetCategory(pet);
		    System.out.println("Selected "+pet);
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@And("I choose a product {string}")
	public void i_choose_a_product(String product) {
	    try {
	    	productpage.selectProduct(product);
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}

	@And("I choose an item {string}")
	public void i_choose_a_item(String item) {
	    try {
	    	productpage.selectItem(item);
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}


	@And("I should see the product title, description, price, images, and availability")
	public void i_should_see_the_product_title_description_price_images_and_availability() 
	{
		try {
			System.out.println("The product details are:");
			productpage.getProductName();
		    productpage.getProductDescription();
		    productpage.getProductAvailability();
		    productpage.getProductPrice();
		    productpage.isProductImageDisplayed();
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	    
	    
	}
	
	@Then("the product should be added to the cart")
	public void verifyProductAddedToCart() {
	    try {
	    	Assert.assertTrue( productpage.addToCart(),"Failed to add product to cart!");
		    System.out.println("Product is added to the cart");
		} catch (Exception e) {
			Assert.fail("Error Occured:"+e.getMessage());
		}
	}


}
