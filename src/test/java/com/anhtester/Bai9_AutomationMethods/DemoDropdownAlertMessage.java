package com.anhtester.Bai9_AutomationMethods;

import com.anhtester.common.BaseTestTaurusApp;
import com.anhtester.drivers.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoDropdownAlertMessage extends BaseTestTaurusApp {

    @Test(priority = 1)
    public void testLoginTaurusApp() throws InterruptedException {
        Thread.sleep(2000);
        WebElement inputUsername = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[1]"));
        inputUsername.click();
        inputUsername.sendKeys("admin");
        Thread.sleep(1000);
        WebElement inputPassword = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[2]"));
        inputPassword.click();
        inputPassword.sendKeys("admin");

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign in\"]")).click();

        Thread.sleep(2000);
        WebElement menuMenu = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu"));
        if (menuMenu.isDisplayed()) {
            System.out.println("Login success.");
        } else {
            System.out.println("Login failed.");
        }
    }

    @Test(priority = 2)
    public void testSortTables() throws InterruptedException {
        testLoginTaurusApp();
        //Navigate to config to download database demo
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Config")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Server database")).click();
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Data 1')]/android.widget.Button")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Replace")).click();
        Thread.sleep(1000);

        //Handle Alert Message, check displayed hoặc getText/getAttribute để kiểm tra nội dung message
        if(DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Downloaded")).isDisplayed()){
            System.out.println("Database demo downloaded.");
        }else {
            System.out.println("Warning!! Can not download Database demo.");
        }
        Thread.sleep(2000);
        //Click Back and click Table Management menu to sort data from A-Z to Z-A
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Back")).click();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[contains(@content-desc,\"Tables management\")]")).click();
        Thread.sleep(1000);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("By name A-Z")).click();
        Thread.sleep(1000);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("By name Z-A")).click();
        Thread.sleep(1000);
        WebElement firstItem = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]"));
        System.out.println("First Item: " + firstItem.getAttribute("content-desc"));
    }
}