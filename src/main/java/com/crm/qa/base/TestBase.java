package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //1. Declare global variables
    public static WebDriver driver;
    public static Properties prop;   // this is global variables we can use through out program
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;


    // 2. create constructor to initilize the proprtiers values
    public TestBase()  {
        //1.  I can read my properties and initilizing the properties values in this step
        try {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\kisho\\IdeaProjects\\workspaceAutomation\\FreeCRMTestAutomation\\src\\main\\java\\" +
                "com\\crm\\qa\\config\\config.properties");
        prop.load(ip);
         }
        catch (IOException e) {
            throw new RuntimeException(e);
         }
    }
        //3. Creating one intilization method for different browser
    public static void initialization(){
       String browserName =  prop.getProperty("browser");
       if(browserName.contains("chrome")){
           driver = new ChromeDriver();
       }
       else if (browserName.contains("ff")) {
           driver = new FirefoxDriver();
       } else if (browserName.contains("safari")) {
           driver = new InternetExplorerDriver();
       }
       else {
           System.out.println("Browser value is not available");
       }


       //4. EventWebDriverListner to use get proper logs while executing the scripts
        e_driver = new EventFiringWebDriver(driver);
       // now we have to create object of EventListnerHandler with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
            driver = e_driver;


       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIME_OUT, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

       driver.get(prop.getProperty("url"));

    }

}

