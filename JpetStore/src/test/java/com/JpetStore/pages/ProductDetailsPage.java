package com.JpetStore.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.JpetStore.utility.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductDetailsPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	public ProductDetailsPage(WebDriver driver, ExtentTest test)
	{
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;		
	}
	
	private By searchButton=By.name("searchProducts");
	
	//Pet selection
	private By selectFish=By.xpath("//body/div[2]/div[2]/div/div/a[1]");
	private By selectDogs=By.xpath("//body/div[2]/div[2]/div/div/a[2]");
	private By selectCats=By.xpath("//body/div[2]/div[2]/div/div/a[3]");
	private By selectReptiles=By.xpath("//body/div[2]/div[2]/div/div/a[4]");
	private By selectBirds=By.xpath("//body/div[2]/div[2]/div/div/a[5]");

	private By returnToMainMenuLink=By.linkText("Return to Main Menu");
	
	//product number
	private By firstProduct=By.xpath("//body/div[2]/div[2]/table/tbody/tr[2]/td[1]/a[1]");
	private By secondProduct=By.xpath("//body/div[2]/div[2]/table/tbody/tr[3]/td[1]/a[1]");
	private By thirdProduct=By.xpath("//body/div[2]/div[2]/table/tbody/tr[4]/td[1]/a[1]");
	
	//Item number
	private By firstItem=By.xpath("//body/div[2]/div[2]/table/tbody/tr[2]/td[1]/a[1]");
	private By secondItem=By.xpath("//body/div[2]/div[2]/table/tbody/tr[3]/td[1]/a[1]");
	
	//product details
	private By productImage=By.xpath("//body/div[2]/div[2]/table/tbody/tr[1]");
	private By productDescription=By.xpath("//body/div[2]/div[2]/table/tbody/tr[3]");
	private By productName=By.xpath("//body/div[2]/div[2]/table/tbody/tr[4]");
	private By productAvailability=By.xpath("//body/div[2]/div[2]/table/tbody/tr[5]");
	private By productPrice=By.xpath("//body/div[2]/div[2]/table/tbody/tr[6]");
	private By productAddToCart=By.xpath("//body/div[2]/div[2]/table/tbody/tr[7]/td[1]/a");
	
	public void verifyPetHomePage() //Verification of Homepage  (Should do the try catch)
    {
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
            Assert.assertTrue(driver.findElement(searchButton).isDisplayed(), "Home page is not visible");
            Reports.generateReport(driver, test, Status.PASS, "Pet home page loaded successfully.");
        } catch (Exception e) {
        	Reports.generateReport(driver, test, Status.FAIL, "Pet home page not loaded.");
            Assert.fail("Pet home page not loaded.");
        }
    }
    
    public void returnToMainMenu() //To return to main menu
    {
    	wait.until(ExpectedConditions.elementToBeClickable(returnToMainMenuLink)).click();
    }
	
	public void selectPetCategory(String petType) 
    {
        switch (petType.toLowerCase()) 
        {
            case "fish":
                driver.findElement(selectFish).click();
                break;
            case "dogs":
                driver.findElement(selectDogs).click();
                break;
            case "cats":
                driver.findElement(selectCats).click();
                break;
            case "reptiles":
                driver.findElement(selectReptiles).click();
                break;
            case "birds":
                driver.findElement(selectBirds).click();
                break;
            default:
                Reports.generateReport(driver, test, Status.FAIL, "Invalid pet category selected: " + petType);
                Assert.fail("Invalid pet category selected.");
        }
        Reports.generateReport(driver, test, Status.PASS, "Selected pet category: " + petType);
    }
	
	public void selectProduct(String productNumber) {
	    try {
	        switch (productNumber.toLowerCase()) {
	            case "first":
	                driver.findElement(firstProduct).click();
	                Reports.generateReport(driver, test, Status.PASS, "Selected first product.");
	                System.out.println("Selected first product.");
	                Assert.assertTrue(true, "First product selected successfully.");
	                break;
	            case "second":
	                driver.findElement(secondProduct).click();
	                Reports.generateReport(driver, test, Status.PASS, "Selected second product.");
	                System.out.println("Selected second product.");
	                Assert.assertTrue(true, "Second product selected successfully.");
	                break;
	            case "third":
	                driver.findElement(thirdProduct).click();
	                Reports.generateReport(driver, test, Status.PASS, "Selected third product.");
	                System.out.println("Selected third product.");
	                Assert.assertTrue(true, "Third product selected successfully.");
	                break;
	            default:
	                Reports.generateReport(driver, test, Status.FAIL, "Invalid product selection: " + productNumber);
	                System.out.println("Invalid product selection: " + productNumber);
	                Assert.fail("Invalid product selection: " + productNumber);
	        }
	    } catch (Exception e) {
	        Reports.generateReport(driver, test, Status.FAIL, "Failed to select product: " + productNumber);
	        System.out.println("Failed to select product: " + productNumber);
	        Assert.fail("Exception occurred while selecting product: " + e.getMessage());
	    }
	}

	public void selectItem(String itemNumber) {
	    try {
	        switch (itemNumber.toLowerCase()) {
	            case "first":
	                driver.findElement(firstItem).click();
	                Reports.generateReport(driver, test, Status.PASS, "Selected first item.");
	                System.out.println("Selected first item.");
	                Assert.assertTrue(true, "First item selected successfully.");
	                break;
	            case "second":
	                driver.findElement(secondItem).click();
	                Reports.generateReport(driver, test, Status.PASS, "Selected second item.");
	                System.out.println("Selected second item.");
	                Assert.assertTrue(true, "Second item selected successfully.");
	                break;
	            default:
	                Reports.generateReport(driver, test, Status.FAIL, "Invalid item selection: " + itemNumber);
	                System.out.println("Invalid item selection: " + itemNumber);
	                Assert.fail("Invalid item selection: " + itemNumber);
	        }
	    } catch (Exception e) {
	        Reports.generateReport(driver, test, Status.FAIL, "Failed to select item: " + itemNumber);
	        System.out.println("Failed to select item: " + itemNumber);
	        Assert.fail("Exception occurred while selecting item: " + e.getMessage());
	    }
	}


	
	public void getProductName() {
	    try {
	    	String name = driver.findElement(productName).getText();
            Reports.generateReport(driver, test, Status.PASS, "Product Name: " + name);
            Assert.assertFalse(name.isEmpty(), "Product Name not found");
	        System.out.println("Product Name: " + name);  
	        
	    } catch (Exception e) {
	    	Reports.generateReport(driver, test, Status.FAIL, "Product Name not found.");
            Assert.fail("Product Name verification failed.");  
	        
	    }
	}

	public void getProductDescription() {
	    try {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription));
            String description = driver.findElement(productDescription).getText();
            Reports.generateReport(driver, test, Status.PASS, "Product Description: " + description);
            Assert.assertFalse(description.isEmpty(), "Product Description is missing!");
	        System.out.println("Product Description: " + description);
	    } catch (Exception e) {
	    	 Reports.generateReport(driver, test, Status.FAIL, "Product Description not found.");
	         Assert.fail("Product Description verification failed.");
	    }
	}

	public void getProductAvailability() {
	    try {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(productAvailability));
            String availability = driver.findElement(productAvailability).getText();
            Reports.generateReport(driver, test, Status.PASS, "Product Availability: " + availability);
            Assert.assertFalse(availability.isEmpty(), "Product Availability is missing!");
            System.out.println("Product Availability: " + availability);
	 
	    } catch (Exception e) {
	    	Reports.generateReport(driver, test, Status.FAIL, "Product Availability not found.");
            Assert.fail("Product Availability verification failed.");
        }
	}

	public void getProductPrice() {
	    try 
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
	        String price = driver.findElement(productPrice).getText();
	        Reports.generateReport(driver, test, Status.PASS, "Product Price: " + price);
	        Assert.assertFalse(price.isEmpty(), "Product Price is missing!");
	        System.out.println("Product Price: " + price);
	        
	    } catch (Exception e) {
	    	Reports.generateReport(driver, test, Status.FAIL, "Product Price not found.");
            Assert.fail("Product Price verification failed.");
        }
	}
	
	public void isProductImageDisplayed() {
        try 
        {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(productImage));
            boolean isDisplayed = driver.findElement(productImage).isDisplayed();
            Reports.generateReport(driver, test, Status.PASS, "Product image is displayed.");
            Assert.assertTrue(isDisplayed, "Product Image is missing!");
            System.out.println("Product image is displayed");
            
        } catch (Exception e) 
        {
        	Reports.generateReport(driver, test, Status.FAIL, "Product Image not displayed.");
            Assert.fail("Product Image verification failed.");
        }
    }

    public boolean addToCart() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productAddToCart)).click();
            Reports.generateReport(driver, test, Status.PASS, "Product added to cart.");
            return true;
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to add product to cart.");
            return false;
        }
    }



}
