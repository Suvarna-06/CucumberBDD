package org.example.stepdefination;

import org.example.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import io.cucumber.java.en.Given;


public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page(){
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        loginPage = new LoginPage(driver);
    }









}
