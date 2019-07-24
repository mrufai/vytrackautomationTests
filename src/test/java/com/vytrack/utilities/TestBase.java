package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;
    private Actions action;


    public void setup(){
        driver=Driver.getDriver();
        action=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }



    public void teardown(){
        Driver.closeDriver();
    }
}
