package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//span[@class=\"selectable \"]")
    WebElement ContactsLabel;

    @FindBy(xpath = "//th/div/a/following-sibling::a[@class=\"item active\"]")
    WebElement contactPagenumbers;

    @FindBy(xpath = "//div/table/thead/following-sibling::tbody/tr/td/div")
    WebElement contactsRadiobtn;

    @FindBy(css = "input[name=\"first_name\"]")
    WebElement firstName;

    @FindBy(css = "input[name=\"last_name\"]")
    WebElement lastName;

    @FindBy(xpath = "//div[@name =\"country\"]/div/following-sibling::i")
    WebElement countryDropdown;

    @FindBy(xpath = "//div[@role=\"option\"]/span[contains(text(),\"google\")]")
    WebElement companyName;

    @FindBy(xpath = "//button[@class =\"ui linkedin button\"]")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class=\"ui field\"]/div[@name=\"channel_type\"]")
    WebElement channelType;



  //Initializing the Page Objects
    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyContactsLabel(){
      return ContactsLabel.isDisplayed();
    }

    public void selectContacts(String name){
       driver.findElement(By.xpath("//div/table/thead/following-sibling::tbody/tr/td/" +
                "following-sibling::td/a[contains(text(),'"+name+"')]")).click();

    }

    public void pageNumber(){
        contactPagenumbers.click();

    }

    public void selectContactsrdiobtn(){
        contactsRadiobtn.isSelected();

    }

    //create New contact details in the form by using excel

    public void createNewContact( String ftName, String  ltName, String compName, String channel) throws InterruptedException {


        //select.selectByVisibleText(country);   // for drop down we have to use select class
        firstName.click();
        firstName.sendKeys(ftName);
        Thread.sleep(2000);
        lastName.sendKeys(ltName);

        driver.findElement(By.xpath("//div[@name=\"company\"]/input[@aria-autocomplete=\"list\"][1]")).isEnabled();
        Thread.sleep(2000);
       driver.findElement(By.xpath("//div[@name=\"company\"]/input[@aria-autocomplete=\"list\"][1]")).sendKeys(compName);

       //driver.findElement(By.xpath("//div[@role=\"option\"]/span[contains(text(),"+compName+")]/parent::div")).sendKeys(Keys.RETURN);

        /*Select select = new Select(driver.findElement(By.xpath("//div/span[contains(text(), \"United States\")]")));
        select.selectByVisibleText("United States");*/
        //driver.findElement(By.xpath("/div[@name =\"country\"]/div/following-sibling::i"));

        channelType.click();
        driver.findElement(By.xpath("//div[@class = \"visible menu transition\"]/div/following-sibling::div/span[contains(text(),"+channel+")]")).click();

        saveButton.click();


    }




}
