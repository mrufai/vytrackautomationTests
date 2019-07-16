package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.BrowserFactory;
import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {

    WebDriver driver;


    String UsernameId = "prependedInput";
    String PasswordId = "prependedInput2";
    String LoginButtonX = "//button[@id='_submit']";
    String FleetX="//span[@class='title title-level-1'][contains(text(),'Fleet')]";
    String vehicleX="//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]";
    String CustomerX="//*[@id=\"main-menu\"]/ul/li[2]/a/span";
    String customerAccX="//li[@class='dropdown dropdown-level-1 active']//li[@class='dropdown-menu-single-item first']//a";
    String customerContX="//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span";
    String ActivitiesX="//span[@class='title title-level-1'][contains(text(),'Activities')]";
    String ActivitesCalX="//h1[@class='oro-subtitle']";
    String StoreDashboards="//span[@class='title title-level-1'][contains(text(),'Dashboards')]";
    String SMDashboard="//li[@class='dropdown-menu-single-item first active']//span[@class='title title-level-2'][contains(text(),'Dashboard')]";
    String SMSales="//span[@class='title title-level-1'][contains(text(),'Sales')]";
    String SmOpportunity="//li[4]//div[1]//div[1]//ul[1]//li[3]//a[1]";
    String SmActivitiCalls="//li[5]//div[1]//div[1]//ul[1]//li[3]//a[1]";


    @BeforeClass
    public void Kurulum() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void SetUp() {
        driver.get("http://qa2.vytrack.com/user/login");
    }


    @Test(priority = 0)
    public void TestDriver() {
        driver.findElement(By.id(UsernameId)).sendKeys("User23");
        driver.findElement(By.id(PasswordId)).sendKeys("UserUser123");
        driver.findElement(By.xpath(LoginButtonX)).click();
        SeleniumUtils.wait(2);
    }
    @Test(priority = 1)
            public void DriverFleet() {
        driver.findElement(By.xpath(FleetX)).click();
        driver.findElement(By.xpath(vehicleX)).click();
        String expectedTitle1 = "Car - Entities - System - Car - Entities - System";
        SeleniumUtils.verifyEquals(expectedTitle1, driver.getTitle());

    }
     @Test(priority = 2)
             public void DriverCustomer(){
        driver.findElement(By.xpath(CustomerX)).click();
        SeleniumUtils.wait(3);
        driver.findElement(By.xpath(customerAccX)).click();
        //SeleniumUtils.wait(2);
        String expectedTitle2="Accounts - Customers";
        //Assert.assertEquals(actualTitle2,expectedTitle2);
         SeleniumUtils.verifyEquals(expectedTitle2,driver.getTitle());
    }
    @Test(priority = 3)
            public void DriverContact() {
        driver.findElement(By.xpath(CustomerX)).click();
        driver.findElement(By.xpath(customerContX)).click();
        //SeleniumUtils.wait(2);
        String expectedTitle3 = "Contacts - Customers";
        SeleniumUtils.verifyEquals(expectedTitle3,driver.getTitle());
        //Assert.assertEquals(actualTitle3, expectedTitle3);
    }
    @Test(priority = 4)
            public void DriverCalender(){

        driver.findElement(By.xpath(ActivitiesX)).click();
        driver.findElement(By.xpath(ActivitesCalX)).click();
        //SeleniumUtils.wait(2);
        String expectedTitle4=" Calendar Events - Activities";
        //Assert.assertEquals(actualTitle4,expectedTitle4);
        SeleniumUtils.verifyEquals(expectedTitle4, driver.getTitle());

    }@Test(priority =5)
    public void LogOut() {
        SeleniumUtils.wait(2);
        driver.findElement(By.id("user-menu")).click();
        String storeUser = driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
        driver.findElement(By.xpath("//a[@class='no-hash']")).click();
    }

    @Test(priority = 6)
    public void TestStoreManager(){
        driver.findElement(By.id(UsernameId)).sendKeys("storemanager85");
        driver.findElement(By.id(PasswordId)).sendKeys("UserUser123");
        driver.findElement(By.xpath(LoginButtonX)).click();
        SeleniumUtils.wait(2);
    }
    @Test(priority = 7)
    public void StoreDashboard(){
        driver.findElement(By.xpath(StoreDashboards)).click();
        driver.findElement(By.xpath(SMDashboard)).click();
        String expectedTitle5 = "Dashboard - Dashboards";
        SeleniumUtils.verifyEquals(expectedTitle5,driver.getTitle());
        //Assert.assertEquals(actualTitle5, expectedTitle5);
    }
    @Test(priority = 8)
    public void StoreFleet(){
        driver.findElement(By.xpath(FleetX)).click();
        driver.findElement(By.xpath(vehicleX)).click();
        String expectedTitle6 = "All - Car - Entities - System - Car - Entities - System";
        SeleniumUtils.verifyEquals(expectedTitle6,driver.getTitle());
        //Assert.assertEquals(actualTitle6, expectedTitle6);
    }
    @Test(priority = 9)
    public void StoreCustomerAccount(){
        driver.findElement(By.xpath(CustomerX)).click();
        driver.findElement(By.xpath(customerAccX)).click();
        String expectedTitle7 = " All - Accounts – Customers";
        SeleniumUtils.verifyEquals(expectedTitle7,driver.getTitle());
        //Assert.assertEquals(actualTitle7, expectedTitle7);
    }
    @Test(priority = 10)
    public void StoreContact(){
        driver.findElement(By.xpath(CustomerX)).click();
        driver.findElement(By.xpath(customerContX)).click();
        String expectedTitle8 = " All - Contacts - Customers";
        SeleniumUtils.verifyEquals(expectedTitle8,driver.getTitle());
        //Assert.assertEquals(actualTitle8, expectedTitle8);
    }
    @Test(priority = 11)
    public void StoreSales(){
        driver.findElement(By.xpath(SMSales)).click();
        driver.findElement(By.xpath(SmOpportunity)).click();
        String expectedTitle9 = "Open Opportunities - Opportunities - Sales";
        SeleniumUtils.verifyEquals(expectedTitle9,driver.getTitle());
        //Assert.assertEquals(actualTitle9, expectedTitle9);
    }
    @Test(priority = 12)
    public void StoreActiviCalls(){
        driver.findElement(By.xpath(ActivitiesX)).click();
        driver.findElement(By.xpath(SmActivitiCalls)).click();
        String expectedTitle10 = "All - Calls - Activities";
        SeleniumUtils.verifyEquals(expectedTitle10,driver.getTitle());
        //Assert.assertEquals(actualTitle10, expectedTitle10);
    }
    @Test(priority = 13)
    public void StoreCalender(){
        driver.findElement(By.xpath(ActivitiesX)).click();
        driver.findElement(By.xpath(ActivitesCalX)).click();
        String expectedTitle11 = "Calendar Events - Activities";
        SeleniumUtils.verifyEquals(expectedTitle11,driver.getTitle());
        //Assert.assertEquals(actualTitle11, expectedTitle11);
    }






    @AfterClass
    public void tearDown(){
        driver.quit();
    }








}
