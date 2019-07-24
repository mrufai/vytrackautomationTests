package com.vytrack.utilities;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver= Driver.getDriver();
    String username= ConfigurationReader.getProperty("Storusername");
    String password= ConfigurationReader.getProperty("password");


    public static void login(WebDriver driver,String username,String password){

        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        SeleniumUtils.wait(4);
        //Driver.closeDriver();



    }




}
