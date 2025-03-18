package com.anhtester.Bai15_Assertions;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {
    @Test(priority = 1)
    public void testLoginSuccess() {
        SoftAssert softAssert = new SoftAssert();

        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        WebElement headerLoginPage = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"));
        softAssert.assertTrue(headerLoginPage.isDisplayed());
        String headerLoginText = headerLoginPage.getText();
        System.out.println("headerLoginText: " + headerLoginText);

        softAssert.assertEquals(headerLoginText, "Login123");

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("bod@example.com");
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).sendKeys("10203040");
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to login with given credentials")).click();
        MobileUI.sleep(2);

        WebElement headerCatalogPage = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("title"));
        softAssert.assertTrue(headerCatalogPage.isDisplayed());
        String headerCatalogText = headerCatalogPage.getText();
        System.out.println("headerCatalogText: " + headerCatalogText);

        softAssert.assertEquals(headerCatalogText, "Products123");

        System.out.println("Login success.");

        softAssert.assertAll();
    }
}
