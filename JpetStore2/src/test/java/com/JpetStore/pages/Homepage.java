package com.JpetStore.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.JpetStore.utility.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Homepage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	public Homepage(WebDriver driver, ExtentTest test)
	{
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;	
	}
	
	private By enterStore= By.linkText("Enter the Store");
	private By signinLink=By.linkText("Sign In");
	
	 public boolean verifyURL(String expectedUrl) 
	 {
	        boolean result = true;
	        String actualUrl = driver.getCurrentUrl();
	        try 
	        {
	            Assert.assertEquals(actualUrl, expectedUrl);
	            Reports.generateReport(driver, test, Status.PASS, "URL Verification Passed: " + actualUrl);
	        } catch (AssertionError e) 
	        {
	            result = false;
	            Reports.generateReport(driver, test, Status.FAIL, "URL Verification Failed: Expected " + expectedUrl + " but found " + actualUrl);
	        }
	        return result;
	    }

	    public boolean verifyTitle(String expectedTitle) {
	        boolean result = true;
	        try 
	        {
	            wait.until(ExpectedConditions.titleIs(expectedTitle));
	            Reports.generateReport(driver, test, Status.PASS, "Title Verification Passed: " + driver.getTitle());
	        } catch (TimeoutException e) 
	        {
	            result = false;
	            Reports.generateReport(driver, test, Status.FAIL, "Title Verification Failed: Expected " + expectedTitle + " but found " + driver.getTitle());
	        }
	        return result;
	    }

	    public void clickEnterToTheStoreLink() 
	    {
	    	 try 
	    	    {	    		 
	    	        wait.until(ExpectedConditions.elementToBeClickable(enterStore)).click();
	    	        Reports.generateReport(driver, test, Status.PASS, "Clicked on 'Enter the Store' link successfully.");
	    	        Assert.assertTrue(driver.findElement(signinLink).isDisplayed());
	    	    } 
	    	    catch (Exception e) 
	    	    {
	    	        Reports.generateReport(driver, test, Status.FAIL, "Failed to click on 'Enter the Store' link.");
	    	    }
	    }

}
