package com.anhtester.Bai8_Mobile_Locators;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
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
    public void testXpathAxes_Buoi2(){
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

    @Test
    public void testXpathAxes_Buoi3(){

        //Cách 1 dựa vào text tương ứng thuộc tính text
        WebElement productName = DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']"));
        String textValue = productName.getAttribute("text");
        System.out.println("Product name: " + textValue);

        //Cách 2 dựa vào thuộc tính khác
        System.out.println("================================");
        List<WebElement> productTitles = DriverManager.getDriver().findElements(By.xpath("//android.widget.TextView[@content-desc='Product Title']"));
        for (WebElement item : productTitles) {
            System.out.println(item.getAttribute("text"));
        }

        //Cách 3 dùng hàm contains
        System.out.println("================================");
        List<WebElement> productNameContains = DriverManager.getDriver().findElements(By.xpath("//android.widget.TextView[contains(@text,'Sauce Labs Backpack')]"));
        for (WebElement item : productNameContains) {
            System.out.println(item.getAttribute("text"));
        }

        //Cách 4 dùng hàm translate không phân biệt hoa thường
        System.out.println("================================");
        WebElement productName2 = DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='sauce labs backpack']"));
        String textValue2 = productName2.getAttribute("text");
        System.out.println("Product name: " + textValue2);

        //Cách 5 dùng hàm and or để kết hợp điều kiện
        System.out.println("================================");
        WebElement productName3 = DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='Product Title' and @text='Sauce Labs Backpack']"));
        String textValue3 = productName3.getAttribute("text");
        System.out.println("Product name: " + textValue3);


    }

    @Test
    public void testXpathAxes_Buoi4(){
        //Cách 7 lấy phần tử tổ tiên (ancestor)
        List<WebElement> ancestorProductName = DriverManager.getDriver().findElements(By.xpath("(//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"Sauce Labs Backpack\"]/ancestor::android.view.ViewGroup[1])/android.widget.TextView[2]"));
        int size7 = ancestorProductName.size();
        System.out.println("Total ancestor of Product Name: " + size7);
        System.out.println(ancestorProductName.get(0).getText());

        //Cách 8 lấy phần tử con và cháu (descendant)
        List<WebElement> descendantProductName = DriverManager.getDriver().findElements(By.xpath("(//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"Sauce Labs Backpack\"]/ancestor::android.view.ViewGroup[1])/android.widget.TextView[2]"));
        int size8 = descendantProductName.size();
        System.out.println("Total descendant of Product Name: " + size8);

        //Cách 9 lấy phần tử anh chị em bên dưới (following-sibling)
        WebElement followingSiblingProductName = DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"Sauce Labs Backpack\"]/following-sibling::android.widget.TextView"));
        System.out.println(followingSiblingProductName.getText());
    }
}
