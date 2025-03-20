package com.anhtester.Bai16_Waits_Appium2x;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ApplyImplicitWait {
    @Test
    public void applyImplicitWaitAndroid() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("/path/to/app.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);

        // Đặt thời gian chờ implicit là 10 giây
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Tìm kiếm phần tử (sẽ chờ tối đa 10 giây nếu không tìm thấy)
        // Nếu tìm thấy tại giây vào thì xử lý ngay tại giây đó
        WebElement button = driver.findElement(AppiumBy.id("com.example:id/button_login"));
        button.click();

        driver.quit();
    }

    @Test
    public void applyImplicitWaitIOS() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 16");
        options.setPlatformName("iOS");
        options.setAutomationName("XCUITest");
        options.setApp("/path/to/app.ipa");

        IOSDriver driver = new IOSDriver(new URL("http://localhost:4723"), options);

        // Đặt thời gian chờ implicit là 10 giây
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Tìm kiếm phần tử (sẽ chờ tối đa 10 giây nếu không tìm thấy)
        // Nếu tìm thấy tại giây vào thì xử lý ngay tại giây đó
        WebElement button = driver.findElement(AppiumBy.id("loginButton"));
        button.click();

        driver.quit();
    }
}
