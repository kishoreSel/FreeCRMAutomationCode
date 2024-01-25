package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

      LoginPage loginPage;
      HomePage homePage;
      ContactsPage contactsPage;
    public HomePageTest(){
      super();   //it will call TestBase class and properties method will initialize
    }

    //test cases should be separated -- independent each other
    //before each test case --launch the browser and login
    //@test - execute the test case
    //after each test case -- close the browser



    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();   //LoginPage will give chance to login into application
        contactsPage = new ContactsPage();  //contacts page will initialize here.
        homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

   @Test(priority = 1)
   public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
       Assert.assertEquals(homePageTitle,"Cogmento CRM","HomePage Title Not Matched :(");
       System.out.println(homePageTitle);
   }

   @Test(priority = 2)
   public void verifyUserNameTitle(){
       String textVal = homePage.userNameLabelmethod();
       System.out.println(textVal);
       Assert.assertEquals(textVal,"bala kishore");
   }

   @Test(priority = 3)
   public void verifyContactLinkText(){
        contactsPage  = homePage.clickOnContactsLink();   //contactspage object will trigger
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
   }

}
