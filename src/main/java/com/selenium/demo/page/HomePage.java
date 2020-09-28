package com.selenium.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Project Name    : selenium-testng-page-factory-txt-data-driven-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 11:56 AM
 * Description     :
 **/

public class HomePage extends BasePage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='account']/span")
    private WebElement profileNameLabel;
    @FindBy(how = How.XPATH, using = "//a[@class='logout']")
    private WebElement logoutLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLoggedInUsername() {
        return profileNameLabel.getText();
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }

}
