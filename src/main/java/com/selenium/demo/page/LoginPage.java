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
 * Time            : 12:01 PM
 * Description     :
 **/

public class LoginPage extends BasePage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailTextBox;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement passwordTextBox;
    @FindBy(how = How.XPATH, using = "//p[@class='submit']//span[1]")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email){
        emailTextBox.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickOnSignInButton();
    }

}
