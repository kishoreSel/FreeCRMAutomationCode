package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.crm.qa.pages.LoginPage.*;

public class LoginPageTest extends TestBase {
      LoginPage loginpage ;
      HomePage homePage;

     // 1.To initilaize all values in Parent class we need to call constructor
     public LoginPageTest(){
          super();
     }


     @BeforeMethod
     public void setUp(){
          initialization();
          // 1. we have to create object of login page class
          loginpage = new LoginPage();
     }

     @Test(priority = 1)
     public void loginPageTitleTest(){
        String title  =loginpage.validateTitleogthePage();
          Assert.assertEquals(title, "#1 Free CRM Power Up your Entire Business Free Forever");
     }
     @Test(priority = 2)
     public void crmLogoImagheTest(){
          boolean flag =loginpage.validateCRMImage();
          Assert.assertTrue(flag);
     }

     @Test (priority = 3)
     public void login(){
          homePage=  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

     }

     @AfterMethod
     public void tearDown(){
          driver.quit();

     }


}
