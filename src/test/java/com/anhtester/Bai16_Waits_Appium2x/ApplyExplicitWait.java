package com.anhtester.Bai16_Waits_Appium2x;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ApplyExplicitWait {
    @Test
    public void applyExplicitWaitAndroid() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("/path/to/app.apk");

        AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);

        // Khởi tạo WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Chờ nút Login xuất hiện và có thể click
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.example:id/button_login")));
        loginButton.click();

        driver.quit();
    }

    @Test
    public void applyExplicitWaitIOS() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setPlatformName("iOS");
        options.setAutomationName("XCUITest");
        options.setApp("/path/to/app.app");

        IOSDriver driver = new IOSDriver(new URL("http://localhost:4723"), options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Chờ label "Welcome" hiển thị
        WebElement welcomeLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome_label")));
        System.out.println(welcomeLabel.getText());

        driver.quit();
    }
}
