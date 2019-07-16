package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MenuOptionsTest {

    WebDriver driver;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }


    @Test(priority = 1, enabled = false)
    public void loginWithDriver(){
        driver.get("http://qa2.vytrack.com/user/login");
        waitMethod(1);
        driver.findElement(By.xpath("//*[@id=\"prependedInput\"]"))
                .sendKeys("user19");
        waitMethod(1);
        driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]"))
                .sendKeys("UserUser123");
        waitMethod(1);
        driver.findElement(By.xpath("//*[@id=\"_submit\"]")).click();
        waitMethod(2);
    }


    @Test(priority = 2, enabled = false)
    public void verifyVehiclePage(){
        driver.findElement(By.xpath("//span[@class='title title-level-1']")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Vehicles')]")).click();
        waitMethod(5);
        String CarsPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Cars')]")).getText();
        Assert.assertEquals(CarsPageName,"Cars");
        Assert.assertEquals(driver.getTitle(),"Car - Entities - System - Car - Entities - System");
    }


    @Test(priority = 3, enabled = false)
    public void verifyAccountPage(){
        driver.findElement(By.xpath("//span[contains(text(), 'Customers')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();
        waitMethod(5);
        String AccountPageName=driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Accounts')]")).getText();
        Assert.assertEquals(AccountPageName,"Accounts");
        Assert.assertEquals(driver.getTitle(),"Accounts - Customers");

    }



    @Test(priority = 4, enabled = false)
    public void verifyContactPage(){
        driver.findElement(By.xpath("//span[contains(text(), 'Customers')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
        waitMethod(5);
        String ContactPageName=driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Contacts')]")).getText();
        Assert.assertEquals(ContactPageName,"Contacts");
        Assert.assertEquals(driver.getTitle(),"Contacts - Customers");
    }


    @Test(priority = 5, enabled = false)
    public void verifyCalenderPage(){
        driver.findElement(By.xpath("//span[contains(text(), 'Activities')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
        waitMethod(5);
        String ContactPageName=driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Calendar Events')]")).getText();
        Assert.assertEquals(ContactPageName,"Calendar Events");
        Assert.assertEquals(driver.getTitle(),"Calendar Events - Activities");
    }

    @Test(priority = 1)
    public void loginWithManager(){
        driver.get("http://qa2.vytrack.com/user/login");
        waitMethod(1);
        driver.findElement(By.xpath("//*[@id=\"prependedInput\"]"))
                .sendKeys("storemanager63");
        waitMethod(1);
        driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]"))
                .sendKeys("UserUser123");
        waitMethod(1);
        driver.findElement(By.xpath("//*[@id=\"_submit\"]")).click();
        waitMethod(2);
    }

    @Test(priority = 2)
    public void verifyDashboardPageWithManager(){
        driver.findElement(By.xpath("//span[contains(text(),'Dashboards')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")).click();
        waitMethod(5);
        String DashboardPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Dashboard')]")).getText();
        Assert.assertEquals(DashboardPageName,"Dashboard");
        Assert.assertEquals(driver.getTitle(),"Dashboard - Dashboards");
    }



    @Test(priority = 3)
    public void verifyVehiclePageWithManager(){
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        waitMethod(5);
        String CarsPageName= driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(CarsPageName,"All Cars");
        Assert.assertEquals(driver.getTitle(),"All - Car - Entities - System - Car - Entities - System");
    }

    @Test(priority = 4)
    public void verifyAccountPageWithManager(){
        driver.findElement(By.xpath("//span[contains(text(), 'Customers')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();
        waitMethod(5);
        String AccountPageName=driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Accounts')]")).getText();
        Assert.assertEquals(AccountPageName,"All Accounts");
        Assert.assertEquals(driver.getTitle(),"All - Accounts - Customers");

    }
    @Test(priority = 5)
    public void verifyContactPageWithManager(){
        driver.findElement(By.xpath("//span[contains(text(), 'Customers')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
        waitMethod(5);
        String ContactPageName=driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Contacts')]")).getText();
        Assert.assertEquals(ContactPageName,"All Contacts");
        Assert.assertEquals(driver.getTitle(),"All - Contacts - Customers");
    }
    @Test(priority = 6)
    public void verifySalesPageWithManager(){
        driver.findElement(By.xpath("//span[contains(text(), 'Sales')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Opportunities')]")).click();
        waitMethod(5);
        String ContactPageName=driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Open Opportunities')]")).getText();
        Assert.assertEquals(ContactPageName,"Open Opportunities");
        Assert.assertEquals(driver.getTitle(),"Open Opportunities - Opportunities - Sales");
    }


    @Test(priority = 7)
    public void verifyCallsPageWithManager(){
        driver.findElement(By.xpath("//span[contains(text(), 'Activities')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Calls')]")).click();
        waitMethod(5);
        String ContactPageName=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(ContactPageName,"All Calls");
        Assert.assertEquals(driver.getTitle(),"All - Calls - Activities");
    }


    @Test(priority = 8)
    public void verifyCalenderPageWithManager(){
        driver.findElement(By.xpath("//span[contains(text(), 'Activities')]")).click();
        waitMethod(1);
        driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
        waitMethod(5);
        String ContactPageName=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(ContactPageName,"All Calendar Events");
        Assert.assertEquals(driver.getTitle(),"All - Calendar Events - Activities");

    }


    public static void waitMethod(int a){
        try{
            Thread.sleep(a*1000);
        }catch (Exception e){

        }

    }



}