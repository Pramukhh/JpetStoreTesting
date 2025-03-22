package com.JpetStore.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.JpetStore.utility.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class UserRegistrationPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	public UserRegistrationPage(WebDriver driver, ExtentTest test)
	{
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
		
	}
	
	private By signInLink=By.linkText("Sign In");
	private By registerNow=By.linkText("Register Now!");
	private By verifyRegistration=By.xpath("//h3[normalize-space()='User Information']");
	
	private By newUserID=By.name("username");
	private By newPassword=By.name("password");
	private By conformNewPassword=By.name("repeatedPassword");
	
	private By firstName=By.name("account.firstName");
	private By lastName =By.name("account.lastName");
	private By email=By.name("account.email");
	private By phoneNumber=By.name("account.phone");
	private By address1=By.name("account.address1");
	private By address2=By.name("account.address2");
	private By city=By.name("account.city");
	private By state=By.name("account.state");
	private By zipCode=By.name("account.zip");
	private By country=By.name("account.country");
	
	private By preferredLanguage=By.name("account.languagePreference");
	private By favouriteCategory=By.name("account.favouriteCategoryId");
	private By saveInformation=By.name("newAccount");
	
	private By userName= By.name("username");
	private By password= By.name("password");
	private By loginBtn=By.name("signon");
	private By myAccountLink=By.linkText("My Account");
	private By enterCredentialsMessage=By.xpath("//p[normalize-space()='Please enter your username and password.']");
	private By invalidCredentialsMessage=By.xpath("//li[contains(text(),'Invalid username or password.')]");
	
	private By signOutLink=By.linkText("Sign Out");

	public void navigateToLoginPage()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
		Assert.assertTrue(driver.findElement(userName).isDisplayed(), "Login page is not visible");	
	}
	
	public void clickRegisterNow()
	{
		wait.until(ExpectedConditions.elementToBeClickable(registerNow)).click();
		Assert.assertTrue(driver.findElement(verifyRegistration).isDisplayed(), "Registration page is not displayed");
	}
	
	public void enterRegistrationDetails()
	{
		driver.findElement(newUserID).sendKeys("rahul");
		driver.findElement(newPassword).sendKeys("rahul2002");
		driver.findElement(conformNewPassword).sendKeys("rahul2002");	
		
		driver.findElement(firstName).sendKeys("Rahul");
		driver.findElement(lastName).sendKeys("Chinta");
		driver.findElement(email).sendKeys("rahul@gmail.com");
		driver.findElement(phoneNumber).sendKeys("8556933214");
		driver.findElement(address1).sendKeys("2-32/23/A");
		driver.findElement(address2).sendKeys("Arya nagar");
		driver.findElement(city).sendKeys("Karimnagar");
		driver.findElement(state).sendKeys("Telangana");
		driver.findElement(zipCode).sendKeys("589998");
		driver.findElement(country).sendKeys("India");
		
		Select s1,s2;		
		s1=new Select(driver.findElement(preferredLanguage));
		s1.selectByVisibleText("english");		
		s2=new Select(driver.findElement(favouriteCategory));
		s2.selectByVisibleText("CATS");
		
		driver.findElement(saveInformation).click();		
	}
	
	public boolean verifyRegistration()
	{
		boolean result = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(signInLink)));
            Reports.generateReport(driver, test, Status.PASS, "Registration is passed ");
        } catch (TimeoutException e) 
        {
            result = false;
            Reports.generateReport(driver, test, Status.FAIL, "Registration is failed");
        }
        return result;
	}
	
	public void enterLoginDetails(String username,String pass)
	{
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		//wait.until(ExpectedConditions.elementToBeClickable(password));
		
		driver.findElement(loginBtn).click();
		
	}
	
	public boolean verifyMyAccountLink()
	{
		boolean result = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(myAccountLink)));
            Reports.generateReport(driver, test, Status.PASS, "Login is passed ");
        } catch (TimeoutException e) 
        {
            result = false;
            Reports.generateReport(driver, test, Status.FAIL, "Login is failed");
        }
        return result;
	}
	
	public boolean verifyInvalidLogin(String expectedMessage)
	{
		boolean result = true;
        //String actualMessage = driver.findElement(invalidCredentialsMessage).getText();
        try 
        {
            Assert.assertTrue(driver.findElement(invalidCredentialsMessage).isDisplayed());
            Reports.generateReport(driver, test, Status.PASS, "Invalid Login Verification Passed");
        } catch (AssertionError e) 
        {
            result = false;
            Reports.generateReport(driver, test, Status.FAIL, "Invalid Login Failed: Expected " + expectedMessage);
        }
        return result;
	}
	
	public boolean verifyEmptyLogin(String expectedMessage)
	{
		boolean result = true;
        //String actualMessage = driver.findElement(enterCredentialsMessage).getText();
        try 
        {
            Assert.assertTrue(driver.findElement(enterCredentialsMessage).isDisplayed());
            Reports.generateReport(driver, test, Status.PASS, "Empty fields Login Verification Passed");
        } catch (AssertionError e) 
        {
            result = false;
            Reports.generateReport(driver, test, Status.FAIL, "Empty fields Login Failed: Expected"+ expectedMessage);
        }
        return result;
		
	}
	
	public void clickLogout()
	{
		//driver.findElement(signOutLink);
		wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();
	}
	
	
}
