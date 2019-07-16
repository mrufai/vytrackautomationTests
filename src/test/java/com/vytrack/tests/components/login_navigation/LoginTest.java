package com.vytrack.tests.components.login_navigation;

import com.github.javafaker.Faker;
import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    Faker fake =new Faker();

    String truckDriver = "user23";
    String storeManager = "storemanager66";
    String salesManager = "salesmanager124";
    String password = "UserUser123";
    String fakepass = fake.internet().password();
    String fakename = fake.name().username();

    String name="";




    public void LogOut() {
        driver.findElement(By.id("user-menu")).click();
        driver.findElement(By.xpath("//a[@class='no-hash']")).click();
    }
    @BeforeClass
    public void GetReady() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void SetUp() {
        driver.get("http://qa2.vytrack.com/user/login");
    }

    @Test(priority = 1)
    public void SMPositive() {
        driver.findElement(By.id("prependedInput")).sendKeys(storeManager);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.wait(5);
        String pageName=driver.findElement(By.cssSelector("#container > div.layout-content.dashboard-container-wrapper > div.container-fluid.page-title > div > div > div.pull-left.pull-left-extra > div > h1")).getText();
        SeleniumUtils.wait(2);
        Assert.assertEquals(pageName,"Dashboard");
        Assert.assertTrue(driver.findElement(By.cssSelector("#user-menu > a")).isDisplayed());
        name= driver.findElement(By.cssSelector("#user-menu > a")).getText();
        LogOut();


    }@Test (priority = 2)
    public void SaMPositive() {
        driver.findElement(By.id("prependedInput")).sendKeys(salesManager);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.wait(5);
        String pageName=driver.findElement(By.cssSelector("#container > div.layout-content.dashboard-container-wrapper > div.container-fluid.page-title > div > div > div.pull-left.pull-left-extra > div > h1")).getText();
        SeleniumUtils.wait(2);
        Assert.assertEquals(pageName,"Dashboard");
        String salesName=driver.findElement(By.cssSelector("#user-menu > a")).getText();
        SeleniumUtils.wait(3);
        Assert.assertNotEquals(name,salesName);
        LogOut();

    }

    @Test (priority = 3)
    public void TDriverPositive() {
        driver.findElement(By.id("prependedInput")).sendKeys(truckDriver);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.wait(4);
        String pageName=driver.findElement(By.cssSelector("#container > div.layout-content.dashboard-container-wrapper > div.container-fluid.page-title > div > div > div.pull-left.pull-left-extra > div > h1")).getText();
        SeleniumUtils.wait(2);
        Assert.assertEquals(pageName,"Quick Launchpad");
        String TruckName=driver.findElement(By.cssSelector("#user-menu > a")).getText();
        SeleniumUtils.wait(3);
        Assert.assertNotEquals(name,TruckName);
        SeleniumUtils.wait(2);
        LogOut();

    }
    @Test (priority = 4)
    public void NegativeTest(){

        driver.findElement(By.id("prependedInput")).sendKeys(truckDriver);
        driver.findElement(By.id("prependedInput2")).sendKeys(fakepass);
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.wait(3);
        String message=driver.findElement(By.cssSelector("#login-form > fieldset > div.alert.alert-error > div")).getText();
        Assert.assertEquals(message,"Invalid user name or password.");






    }




    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
