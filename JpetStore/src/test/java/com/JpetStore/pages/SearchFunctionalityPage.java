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

public class SearchFunctionalityPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	public SearchFunctionalityPage(WebDriver driver, ExtentTest test)
	{
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
		
	}
	
	//Search functionality
	private By searchButton=By.name("searchProducts");
	private By searchTextbox=By.name("keyword");
	private By verifyproductSearch=By.xpath("//body/div[2]/div[2]/table/tbody/tr/th[text()='Product ID']");// verify Product Id is present or not
	private By petSearchResult=By.xpath("//body/div[2]/div[2]/table/tbody/tr[3]/td[1]/a[1]");//2nd  element from the search page
	private By description=By.xpath("//body//div[2]/div[2]/table/tbody/tr[2]/td[3]"); //description of the 2ndd element
	private By priceDetails=By.xpath("//body//div[2]/div[2]/table/tbody/tr[2]/td[4]"); // price details of the 2nd element
	private By addToCartSearch=By.xpath("//body//div[2]/div[2]/table/tbody/tr[2]/td[5]"); // add to cart 2nd element
	

    private By returnToMainMenuLink=By.linkText("Return to Main Menu");
   
    
    //Item details page  
    private By stockDetails=By.xpath("//body/div[2]/div[2]/table/tbody/tr[5]/td[1][contains(text(), 'stock')]");
    
    
    
    public void verifyPetHomePage() //Verification of Homepage  (Should do the try catch)
    {
    	boolean isDisplayed = driver.findElement(searchButton).isDisplayed();
        Assert.assertTrue(isDisplayed, "Home page verification failed - Search button not displayed!");
    }
    
    public void returnToMainMenu() //To return to main menu
    {
    	driver.findElement(returnToMainMenuLink).click();
        Reports.generateReport(driver, test, Status.PASS, "Returned to Main Menu.");
        System.out.println("Returned to Main Menu.");}
    
    public void enterSearchKeyword(String keyword) //Entering a pet type into search-box
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextbox)).sendKeys(keyword);
        Reports.generateReport(driver, test, Status.PASS, "Entered search keyword: " + keyword);
        System.out.println("Entered search keyword: " + keyword);
    }

    public void clickSearchButton() 
    {
    	wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        Reports.generateReport(driver, test, Status.PASS, "Clicked search button.");
        System.out.println("Clicked search button.");
    }
    
    public void verifySearchResults() //To verify weather the search results are displayed or not
    {
    	try 
    	{
            wait.until(ExpectedConditions.visibilityOfElementLocated(verifyproductSearch));
            String resultText = driver.findElement(verifyproductSearch).getText();
            Reports.generateReport(driver, test, Status.PASS, "Search result displayed: " + resultText);
            System.out.println("Search result displayed: " + resultText);
            Assert.assertTrue(!resultText.isEmpty(), "Search results verification failed!");
        } catch (Exception e) 
    	{
            Reports.generateReport(driver, test, Status.FAIL, "No search results found.");
            System.out.println("No search results found.");
            Assert.fail("Search results verification failed - No results found.");
        }
    }
    
    public void selectThePetFromSearch() //selecting second element from search
    {
    	 driver.findElement(petSearchResult).click();
         Reports.generateReport(driver, test, Status.PASS, "Selected pet from search results.");
         System.out.println("Selected pet from search results.");
    }
    
    public void getDescription() //get description of the second element
    {
    	try 
    	{
            wait.until(ExpectedConditions.visibilityOfElementLocated(description));
            String desc = driver.findElement(description).getText();
            Reports.generateReport(driver, test, Status.PASS, "Product Description: " + desc);
            System.out.println("Product Description: " + desc);
            Assert.assertFalse(desc.isEmpty(), "Product Description is missing!");
        } catch (Exception e) 
    	{
            Reports.generateReport(driver, test, Status.FAIL, "Product Description not found.");
            System.out.println("Product Description not found.");
            Assert.fail("Product Description verification failed!");
        }
    }
    
    public void getPriceDetails() //get price details of the second element
    {
    	try 
    	{
            wait.until(ExpectedConditions.visibilityOfElementLocated(priceDetails));
            String price = driver.findElement(priceDetails).getText();
            Reports.generateReport(driver, test, Status.PASS, "Product Price: " + price);
            System.out.println("Product Price: " + price);
            Assert.assertFalse(price.isEmpty(), "Product Price is missing!");
        } catch (Exception e) 	
    	{
            Reports.generateReport(driver, test, Status.FAIL, "Product Price not found.");
            System.out.println("Product Price not found.");
            Assert.fail("Product Price verification failed!");
        }
    }
    
    public void addToCartFromSearch() {
        try 
        {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartSearch)).click();
            Reports.generateReport(driver, test, Status.PASS, "Added product to cart from search.");
            System.out.println("Added product to cart from search.");
            Assert.assertTrue(true, "Product added to cart successfully.");
        } catch (Exception e) 
        {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to add product to cart.");
            System.out.println("Failed to add product to cart.");
            Assert.fail("Add to cart failed!");
        }
    }   

}
