package com.selenium.demo.test.login;

import com.selenium.demo.page.BasePage;
import com.selenium.demo.page.HomePage;
import com.selenium.demo.page.LoginPage;
import com.selenium.demo.test.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Project Name    : selenium-testng-page-factory-txt-data-driven-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/15/2019
 * Time            : 12:02 PM
 * Description     :
 **/

public class LoginTest extends TestBase {

    @Test
    public void verifyValidUserLogin() {
        String loginPageTitle = "Login - My Store";
        String myAccountPageTitle = "My account - My Store";
        String txtFilePath = "./src/test/resources/users.txt";

        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        BufferedReader in;
        InputStreamReader inputStream;

        try {
            inputStream = new InputStreamReader(new FileInputStream(txtFilePath));
            in = new BufferedReader(inputStream);
            String line, email, password, fullName;

            while ((line = in.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 1) {
                    email = data[0];
                    password = data[1];
                    fullName = data[2];

                    Assert.assertEquals(basePage.getBrowserTabTitle(), loginPageTitle);
                    loginPage.login(email, password);
                    Assert.assertEquals(basePage.getBrowserTabTitle(), myAccountPageTitle);
                    Assert.assertEquals(homePage.getLoggedInUsername(), fullName);
                    homePage.clickOnLogoutLink();
                    Assert.assertEquals(basePage.getBrowserTabTitle(), loginPageTitle);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}