package com.anhtester.Bai8_Mobile_Locators;

import com.anhtester.common.BaseTest;
import com.anhtester.common.BaseTestSauceLabs;
import com.anhtester.drivers.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorsSauceLabsApp extends BaseTest {
    @Test
    public void testDemoLocators() {
        WebElement headerPage1 = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV"));
        System.out.println("Header 1: " + headerPage1.getText());

        WebElement headerPage2 = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("title"));
        System.out.println("Header 2: " + headerPage2.getText());

        WebElement productName1 = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"Sauce Labs Backpack\"]"));
        System.out.println("Product 1: " + productName1.getText());

        WebElement productName2 = DriverManager.getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        System.out.println("Product 2: " + productName2.getText());

        //WebElement image1 = DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[1]"));
        //image1.click();

        DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[1]")).click();
        sleep(1);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to add product to cart")).click();
        sleep(1);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to add product to cart")).click();
        sleep(1);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to add product to cart")).click();

//        WebElement productImage = DriverManager.getDriver().findElement(AppiumBy.iOSNsPredicateString("android.widget.ImageView"));
//        productImage.click();
    }

    @Test
    public void testXpathAxes(){
        sleep(2);
        WebElement productName2 = DriverManager.getDriver().findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[2]/android.widget.TextView[1]"));
        System.out.println(productName2.getText());

        WebElement productPrice2 = DriverManager.getDriver().findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[2]/android.widget.TextView[2]"));
        System.out.println(productPrice2.getText());

        WebElement productName3 = DriverManager.getDriver().findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[3]/android.widget.TextView[1]"));
        System.out.println(productName3.getText());

        WebElement parentElement = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Displays all products of catalog"));
        //WebElement childElement = parentElement.findElement(AppiumBy.xpath("child::android.view.ViewGroup[4]"));
        List<WebElement> childElements = parentElement.findElements(AppiumBy.xpath("child::*"));
        System.out.println(childElements.size());
        //System.out.println(childElement.getText());
        for (WebElement element : childElements) {
            System.out.println(element);
        }
    }
}
