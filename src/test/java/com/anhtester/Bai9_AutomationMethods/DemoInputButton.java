package com.anhtester.Bai9_AutomationMethods;

import com.anhtester.common.BaseTest;
import com.anhtester.common.BaseTestTaurusApp;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoInputButton extends BaseTestTaurusApp {
    @Test
    public void testLoginMyDemoApp() {
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("bod@example.com");
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).sendKeys("10203040");
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to login with given credentials")).click();
        MobileUI.sleep(3);
    }

    @Test
    public void testLoginTaurusApp() {
        MobileUI.sleep(2);
        WebElement inputUsername = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[1]"));
        inputUsername.click();
        inputUsername.sendKeys("admin");
        MobileUI.sleep(1);
        WebElement inputPassword = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[2]"));
        inputPassword.click();
        inputPassword.sendKeys("admin");
        System.out.println("Toạ độ X: " + inputUsername.getLocation().getX());
        System.out.println("Toạ độ X: " + inputUsername.getLocation().getY());

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign in\"]")).click();

        MobileUI.sleep(1);
        WebElement menuMenu = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu"));
        if (menuMenu.isDisplayed()) {
            System.out.println("Login success.");
        } else {
            System.out.println("Login failed.");
        }

        System.out.println("Height: " + menuMenu.getSize().getHeight());
        System.out.println("Width: " + menuMenu.getSize().getWidth());
    }
}