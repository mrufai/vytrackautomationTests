package com.vytrack.tests.components.login_navigation;



import com.github.javafaker.Faker;
import com.vytrack.tests.smoke_tests.MenuOptionsTest;
import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {

        WebDriver driver;
        Faker fake =new Faker();
        //kullanicilar
    String Driver = "user23";
    String StoreManager = "storemanager66";
    String SalesManager = "salesmanager124";
    String Password = "UserUser123";
    String fakepass = fake.internet().password();
    String fakename = fake.name().username();
    //locators

    String UsernameId = "prependedInput";
    String PasswordId = "prependedInput2";
    String LoginButtonX = "//button[@id='_submit']";

    @BeforeClass
        public void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
   @BeforeMethod
    public void Setup(){
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");   }

    @AfterMethod
    public void Close(){
        driver.close();
    }
       @Test(priority = 0)
    public void TestPositiveSM(){

          driver.findElement(By.id(UsernameId)).sendKeys(StoreManager);
          driver.findElement(By.id(PasswordId)).sendKeys(Password);
          driver.findElement(By.xpath(LoginButtonX)).click();
           SeleniumUtils.wait(3);
           String actualisim = driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
           String expectisim="Emely Wehner";
           SeleniumUtils.verifyEquals(expectisim,actualisim);
           WebElement element1 =driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
           SeleniumUtils.verifyIsDisplayed(element1);
           driver.findElement(By.xpath("//a[@class='no-hash']")).click();
           SeleniumUtils.wait(3);

    }
    @Test(priority = 1)
    public void TestPositiveSalesM(){

        driver.findElement(By.id(UsernameId)).sendKeys(SalesManager);
        driver.findElement(By.id(PasswordId)).sendKeys(Password);
        driver.findElement(By.xpath(LoginButtonX)).click();
        SeleniumUtils.wait(3);
        String actualisim = driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
        String expectisim="Talon Herzog";
        SeleniumUtils.verifyEquals(expectisim,actualisim);
        WebElement element1 =driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        SeleniumUtils.verifyIsDisplayed(element1);
        driver.findElement(By.xpath("//a[@class='no-hash']")).click();

    }
    @Test(priority = 2)
    public void TestPositiveDriver(){

        driver.findElement(By.id(UsernameId)).sendKeys(Driver);
        driver.findElement(By.id(PasswordId)).sendKeys(Password);
        driver.findElement(By.xpath(LoginButtonX)).click();
        SeleniumUtils.wait(3);
        String actualisim = driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
        String expectisim="Marge Wehner";
        SeleniumUtils.verifyEquals(expectisim,actualisim);
        WebElement element1 =driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        SeleniumUtils.verifyIsDisplayed(element1);
        driver.findElement(By.xpath("//a[@class='no-hash']")).click();

    }
    @Test (priority = 3)
    public void NegativeTest(){
        // valid username | invalid password
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("prependedInput")).sendKeys(Driver);
        driver.findElement(By.id("prependedInput2")).sendKeys(fakepass);
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.wait(3);
        System.out.println("\nLogin test with valid user & invalid password: ");
        String actualtext = driver.findElement(By.xpath("//div[contains(text(),'Invalid user name or password.')]")).getText();
        String expectedtext = "Invalid user name or password.";
        SeleniumUtils.verifyEquals(expectedtext,actualtext);

    }






}

