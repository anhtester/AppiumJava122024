package com.anhtester.Bai16_Waits_Appium2x;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoApplyMobileUIExplicitWait extends BaseTest {

    @Test
    public void testExplicitWait() {

//        MobileUI.waitForElementToBeClickable(AppiumBy.accessibilityId("View menu"), 4);
//        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        MobileUI.clickElement(AppiumBy.accessibilityId("View menu"), 4);

        MobileUI.waitForElementVisibe(AppiumBy.accessibilityId("Login Menu Item"), 5);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        MobileUI.waitForElementVisibe(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"), 5);
        WebElement headerLoginPage = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"));
        Assert.assertTrue(headerLoginPage.isDisplayed());
        String headerLoginText = headerLoginPage.getText();
        System.out.println("headerLoginText: " + headerLoginText);

        Assert.assertEquals(headerLoginText, "Login");

        MobileUI.waitForElementVisibe(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]"), 10);

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("bod@example.com");
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).sendKeys("10203040");
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to login with given credentials")).click();
        MobileUI.sleep(2);

        WebElement headerCatalogPage = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("title"));
        Assert.assertTrue(headerCatalogPage.isDisplayed());
        String headerCatalogText = headerCatalogPage.getText();
        System.out.println("headerCatalogText: " + headerCatalogText);

        Assert.assertEquals(headerCatalogText, "Products");

        System.out.println("Login success.");
    }

}
