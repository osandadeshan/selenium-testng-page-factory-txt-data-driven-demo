package com.selenium.demo.test.base;

import com.selenium.demo.util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Project Name    : selenium-testng-page-factory-txt-data-driven-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 11/3/2019
 * Time            : 6:14 PM
 * Description     :
 **/

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @AfterMethod
    public void closeAllDrivers() {
        if(driver != null) {
            driver.quit();
        }
    }

}
