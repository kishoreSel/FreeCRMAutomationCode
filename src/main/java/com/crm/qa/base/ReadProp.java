package com.crm.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {

    public static void main(String[] args) throws IOException, InterruptedException {

         WebDriver driver = null;

        Properties prop = new Properties();
        FileInputStream is = new FileInputStream("C:\\Users\\kisho\\IdeaProjects\\workspaceAutomation\\FreeCRMTestAutomation\\src\\main\\java\\" +
                "com\\crm\\qa\\config\\config.properties");
             prop.load(is);

             System.out.println("Browser is : "+ prop.getProperty("browser"));
             String browserName = prop.getProperty("browser");

               if(browserName.equals("chrome")) {
                   driver = new ChromeDriver();
               }
                 else if (browserName.equals("FF")) {
                   driver = new FirefoxDriver();
               }
                 else if (browserName.equals("safari")) {
                   driver = new SafariDriver();
               }
                 else if (browserName.equals("IE")) {
                   driver = new InternetExplorerDriver();

               } 
                 else {
                     System.out.println("No Browser value is not present ");

               }
                 driver.get(prop.getProperty("url"));
                 driver.findElement(By.xpath("//a/span[@class=\"icon icon-xs mdi-chart-bar\"]")).click();
                 Thread.sleep(2000);
                 driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("kishorecheme@gmail.com");
                 driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Test@1234");
                 driver.findElement(By.cssSelector("div[class=\"ui fluid large blue submit button\"]")).click();

             }



    }
