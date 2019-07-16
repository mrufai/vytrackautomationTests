package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PageAccessTest {
    WebDriver driver;

    String truckDriver = "user23";
    String storeManager = "storemanager66";
    String salesManager = "salesmanager124";
    String password = "UserUser123";

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

    @Test (priority = 1)
    public void ContractP1() {
        driver.findElement(By.id("prependedInput")).sendKeys(storeManager);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.wait(5);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        SeleniumUtils.wait(2);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[6]/a/span")).click();
        SeleniumUtils.wait(2);
        String pageName=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(pageName,"All Vehicle Contract");
        LogOut();



    }
    @Test (priority = 2)
    public void ContractP2() {
        driver.findElement(By.id("prependedInput")).sendKeys(salesManager);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.wait(5);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        SeleniumUtils.wait(2);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[6]/a/span")).click();
        SeleniumUtils.wait(2);
        String pageName=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(pageName,"All Vehicle Contract");
        LogOut();

    }

    @Test (priority = 3)
    public void ContractP3() {
        driver.findElement(By.id("prependedInput")).sendKeys(truckDriver);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.wait(4);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        SeleniumUtils.wait(2);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[6]/a/span")).click();
        SeleniumUtils.wait(2);
        String ErrMessage=driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div")).getText();
        Assert.assertEquals(ErrMessage,"You do not have permission to perform this action.");
        LogOut();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
