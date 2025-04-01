package com.anhtester.Bai17_PageObjectModel;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_MyDemo extends BaseTest {
    @Test(priority = 1)
    public void testLoginSuccess() {
        MobileUI.waitForElementToBeClickable(AppiumBy.accessibilityId("View menu"), 5).click();
        MobileUI.waitForElementToBeClickable(AppiumBy.accessibilityId("Login Menu Item"), 5).click();

        WebElement headerLoginPage = MobileUI.waitForElementVisibe(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"), 5);
        Assert.assertTrue(headerLoginPage.isDisplayed());
        String headerLoginText = headerLoginPage.getText();
        System.out.println("headerLoginText: " + headerLoginText);

        Assert.assertEquals(headerLoginText, "Login");

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("bod@example.com");
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).sendKeys("10203040");
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to login with given credentials")).click();
        MobileUI.sleep(2);

        WebElement headerCatalogPage = MobileUI.waitForElementVisibe(AppiumBy.accessibilityId("title"), 5);
        Assert.assertTrue(headerCatalogPage.isDisplayed());
        String headerCatalogText = headerCatalogPage.getText();
        System.out.println("Header Catalog text: " + headerCatalogText);
        Assert.assertEquals(headerCatalogText, "Products");

        System.out.println("Login success.");
    }
}
