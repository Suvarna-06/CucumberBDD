package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    // Write locators

    private WebDriver driver;

    //By Locators
    private By emailInputLocator =By.name("email");
    private By passwordInputLocator = By.xpath("//input[@type='password']");
    private By loginButtonLocator = By.xpath("//button[@type='submit']");
    private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
    private By logoutLinkLocator = By.linkText("Logout");

    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // APge Actions or Methods
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }
    public void clickForgottenPasswordLink(){
        WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
        forgottenPasswordLink.click();
    }

    public boolean checkForgotPwdLink(){
        return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
    }
    public boolean checkLogutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageURl(){
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;
    }

}
