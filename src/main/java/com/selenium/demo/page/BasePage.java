package com.selenium.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name    : selenium-testng-page-factory-txt-data-driven-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 11/3/2019
 * Time            : 8:11 PM
 * Description     :
 **/

public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getBrowserTabTitle() {
        return driver.getTitle();
    }

}
