package com.JpetStore.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.JpetStore.utility.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks extends Base 
{
    static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeAll
    public static void beforeAll() 
    {
        try 
        {
            // Initialize Extent Reports
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Launch Browser only once before all tests
            //getBrowser();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void afterAll() 
    {
        // Close the browser after last feature (Shopping Cart)
        //Base.driver.quit();
        extent.flush(); // Flush the reports after all tests
    }

    @Before
    public void beforeScenario() 
    {
    	Base.getBrowser();
        test = extent.createTest("Test Scenario");
    }

    @After
    public void afterScenario() 
    {
    	Base.driver.quit();
        // No browser quit here, as it should only close after the last feature
    }
}
