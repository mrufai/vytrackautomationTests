package com.vytrack.tests.components.activities;

import com.vytrack.utilities.*;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DateAndTimeTests extends TestBase {
    WebDriver driver= Driver.getDriver();
    private String Activitieslocator="//*[@id=\"main-menu\"]/ul/li[5]/a/span";
    private String CalenderEventslocatr="//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]/a/span";
    private String createlocator="#container > div.container-fluid.page-title > div > div > div.pull-right.title-buttons-container > div > a";
    private String startDatelocator="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]";
    private String endlocator="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[2]/div[2]/div[1]/input[1]";
    private String Todaybutton="#ui-datepicker-div > div.ui-datepicker-buttonpane.ui-widget-content > button.ui-datepicker-current.ui-state-default.ui-priority-secondary.ui-corner-all";
    private String TimeStrtLocator="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[2]";
    private String TimeendLocator="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[2]/div[2]/div[1]/input[2]";


    private String username= ConfigurationReader.getProperty("Storusername");
    private String password=ConfigurationReader.getProperty("password");

    Actions action =new Actions(driver);


    @Test(priority = 1,description = "date equality test")
    public void endDateAutoAdjustTest1(){

        LoginPage.login(driver,username,password);
        //driver.manage().window().maximize();
        driver.findElement(By.xpath(Activitieslocator)).click();
        SeleniumUtils.wait(2);
        driver.findElement(By.xpath(CalenderEventslocatr)).click();
        SeleniumUtils.wait(2);
        driver.findElement(By.cssSelector(createlocator)).click();
        SeleniumUtils.wait(2);
        driver.findElement(By.xpath(startDatelocator)).click();
        SeleniumUtils.wait(1);
        driver.findElement(By.xpath(startDatelocator)).clear();
        SeleniumUtils.wait(2);
        driver.findElement(By.xpath(startDatelocator)).sendKeys("Aug 31, 2019");
        SeleniumUtils.wait(5);
        driver.findElement(By.xpath(startDatelocator)).sendKeys(Keys.ENTER);
        SeleniumUtils.wait(3);
        String expectedDate= driver.findElement(By.xpath(startDatelocator)).getText();
        String actualDate=driver.findElement(By.xpath(endlocator)).getText();
        Assert.assertEquals(actualDate,expectedDate);
        System.out.println("buradan gecti");

        action.moveToElement(driver.findElement(By.xpath(startDatelocator))).perform();

        driver.findElement(By.cssSelector(Todaybutton)).click();
        SeleniumUtils.wait(6);
        String actualtoday=driver.findElement(By.xpath(startDatelocator)).getText();
        String expectedtoday=driver.findElement(By.xpath(endlocator)).getText();
        SeleniumUtils.wait(1);
        Assert.assertEquals(actualtoday,expectedtoday);

    }
@Test(priority = 2,description = "time equalty test")
    public void endTimeAutoAdjustTest2(){

    LoginPage.login(driver,username,password);
    driver.findElement(By.xpath(Activitieslocator)).click();
    SeleniumUtils.wait(2);
    driver.findElement(By.xpath(CalenderEventslocatr)).click();
    SeleniumUtils.wait(2);
    driver.findElement(By.cssSelector(createlocator)).click();
    SeleniumUtils.wait(2);
    driver.findElement(By.xpath(TimeStrtLocator)).click();
    SeleniumUtils.wait(2);
    driver.findElement(By.xpath(TimeStrtLocator)).clear();
    SeleniumUtils.wait(2);
    driver.findElement(By.xpath(TimeStrtLocator)).sendKeys("12:30 PM");
    SeleniumUtils.wait(2);
    driver.findElement(By.xpath(TimeStrtLocator)).sendKeys(Keys.ENTER);
    SeleniumUtils.wait(2);
    String actualtime =driver.findElement(By.xpath(TimeendLocator)).getText();



}

}


