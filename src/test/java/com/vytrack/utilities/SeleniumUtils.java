package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

    public class SeleniumUtils {

        // Verifies if two Strings are equal

        public static void verifyEquals(String expectedResult, String actualResult) {
            if (expectedResult.equals(actualResult)) {
                System.out.println("Passed");
            } else {
                System.out.println("Failed");
                System.out.println("Expected Result: " + expectedResult);
                System.out.println("Actual Result: " + actualResult);
            }
        }

        public static void wait(int seconds){
            try {
                Thread.sleep(seconds * 1000 );
            }catch (Exception e){
                e.printStackTrace();
                // System.out.println(e.getMessage());
            }
        }
        // This method will open example page based on link name
        public static void openPage(String page, WebDriver driver){
            //we will all examples on the home page
            List<WebElement> list = driver.findElements(By.tagName("a"));
            for(WebElement example: list){
                if(example.getText().contains(page)){
                    example.click();
                    break;
                }
            }
        }

        public static void verifyIsDisplayed(WebElement element){
            if(element.isDisplayed()){
                System.out.println("Passed");
                System.out.println(element.getText()+": is visible");
            }else{
                System.out.println("Failed");
                System.out.println(element.getText()+": is not visible");
            }

        }
    }
