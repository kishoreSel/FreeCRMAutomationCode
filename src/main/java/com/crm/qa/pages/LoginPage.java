package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    // 1. create the Object repositiory -OR  by using Page factory no need to write By.Xpath, cssselector etc
    @FindBy(xpath = "//a/span[@class=\"icon icon-xs mdi-chart-bar\"]")
    WebElement login;

    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement userName;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement password;

    @FindBy(css = "div[class=\"ui fluid large blue submit button\"]")
    @CacheLookup   // it is more efficient annotation to improve performance every time instead hitting the page webelements it will store in cache memory
    WebElement loginActualBtn;

    @FindBy(xpath = "//span[@class =\"mdi-chart-bar icon icon-md\"]")
    WebElement signupBtn;

    @FindBy(xpath = "//div[@class = \"rd-navbar-wrap\"]/div[1]")
    WebElement crmLogo;

    // 2. Now we have to initialize the webelements by using constructor(memory allocation)
    //Initialize the POM - Page Pbject
    public LoginPage(){
        PageFactory.initElements(driver,this);  //this means current class objects
    }

    // 3. Actions/ Create the methods for LogPage

    public String validateTitleogthePage(){
        System.out.println("Title is : "+driver.getTitle());
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd ){

        login.click();
        userName.sendKeys(un);
        password.sendKeys(pwd);
        loginActualBtn.click();

        return new HomePage();   // This is page chaining to next Homepage class. So we have return as HomePage
    }

}
