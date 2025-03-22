package com.JpetStore.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class ShoppingCartPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	public ShoppingCartPage(WebDriver driver, ExtentTest test)
	{
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;	
	}
	
	By updateQuantity=By.xpath("//div[2]/div[2]/div[1]//table/tbody/tr[3]/td[5]/input");
	By removeButton=By.xpath("//div[2]/div[2]/div[1]//table/tbody/tr[3]/td[8]/a");
	By proceedToCheckoutButton=By.linkText("Proceed to Checkout");
	By continueButton=By.name("newOrder");
	By confirmButton=By.linkText("Confirm");
	By verifyOrder=By.xpath("//li[contains(text(), 'Thank you, your order has been submitted.')]");
	
	public void updateOrderQuantity()
	{
		driver.findElement(updateQuantity).clear();
		driver.findElement(updateQuantity).sendKeys("4");
	}
	
	public void removeProductFromCart()
	{
		driver.findElement(removeButton).click();
	}
	
	public void clickProceedToCheckout()
	{
		driver.findElement(proceedToCheckoutButton).click();
	}
	
	public void clickContinueButton()
	{
		driver.findElement(continueButton).click();
	}
	
	public void clickConfirmButton()
	{
		driver.findElement(confirmButton).click();
	}
	
	public void verifyTheOrderPlaced()
	{
		driver.findElement(verifyOrder).isDisplayed();
	}

}
