package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.dom4j.Node;
import org.dom4j.rule.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    //1. create the pagefactory for required pages
    @FindBy(css = "span.user-display")
    WebElement userNameLabel;
    //span[contains(@class,"user")]   -- by using contains in xpath

    @FindBy(xpath = "//a[contains(@href,\"contacts\")]")
    WebElement contactsLink;
    //for contact xpath -- //div/a[@href="/contacts"]

    @FindBy(xpath = "//div[@class =\"ui fluid container\"][1]/div/div/following-sibling::div[2]/button[1]")
    WebElement addNewContact;

    @FindBy(xpath = "//a[contains(@href,\"deals\")]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(@href,\"tasks\")]")
    WebElement tasksList;

    //2. create constructor for homepage to initilize the page objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //3. create methods in homepage

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public String userNameLabelmethod() {
        //return userNameLabel.isDisplayed();
        return userNameLabel.getText();

    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();   //retun Contacts page object

    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksList() {
        tasksList.click();
        return new TasksPage();   //should return TasksPage object
    }

    //To create the New Contacts -- need to mousehover on contacts tab and click on Add '+'
    public void ClickOnNewContactAdd() throws InterruptedException {
        Actions action = new Actions(driver);   //mouse moment, drag and drop, dropdowns etc
       action.moveToElement(contactsLink).build().perform();
       // action.moveToElement(addNewContact).build().perform();
        addNewContact.click();



    }

}