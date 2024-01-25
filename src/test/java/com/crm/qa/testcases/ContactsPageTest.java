package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactsPageTest extends TestBase {
      LoginPage loginPage;
      HomePage homePage;
      TestUtil testUtil;
      ContactsPage contactsPage;
      String sheetName ="contacts";


    public  ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        contactsPage = new ContactsPage();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactsPage =homePage.clickOnContactsLink();
    }


    @Test(priority = 1)
    public void verifypageNumberTEst(){
        //homePage.clickOnContactsLink();
        contactsPage.pageNumber();
    }

    @Test(priority = 2)
    public void verifyContactsPageLabel(){
        //homePage.clickOnContactsLink();
        contactsPage.pageNumber();
        contactsPage.verifyContactsLabel();
    }

    @Test(priority=3)
    public void selectContactTest(){
        //homePage.clickOnContactsLink();
        contactsPage.pageNumber();
        contactsPage.selectContactsrdiobtn();
    }

    @Test(priority = 4 )
    public void selectContacts(){
        //homePage.clickOnContactsLink();
        contactsPage.pageNumber();
         contactsPage.selectContacts("Test2 Test2");
    }

    @DataProvider
    public Object[][] getCRMTestData() throws IOException {
       Object data[][]=  TestUtil.getTestData(sheetName);
       return data;
    }


    @Test(priority = 5, dataProvider = "getCRMTestData")
    public void createNewContact(String firstName, String lastName, String company, String channel) throws InterruptedException {
        homePage.ClickOnNewContactAdd();
       // contactsPage.createNewContact("dataProvider");
        contactsPage.createNewContact(firstName, lastName, company, channel);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
