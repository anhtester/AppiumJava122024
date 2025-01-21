package com.anhtester.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TaurusAppTest extends BaseTest {
    @Test
    public void testLoginTaurusApp() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        // Tìm và tương tác với các phần tử giao diện
        // Nhập email
        WebElement inputEmail = DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText)[1]"));
        inputEmail.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        inputEmail.sendKeys("admin");

        // Nhập password
        WebElement inputPassword = DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText)[2]"));
        inputPassword.click();
        inputPassword.sendKeys("admin");

        // Nhấn nút "Sign in"
        WebElement signInButton = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Sign in"));
        signInButton.click();

        // Đợi sau khi nhấn nút Sign in
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Kiểm tra kết quả đăng nhập
        // Ví dụ: Tìm kiếm một phần tử chỉ xuất hiện khi đăng nhập thành công
        WebElement menuElement = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu"));
        if (menuElement.isDisplayed()) {
            System.out.println("Login thành công!");
        } else {
            System.out.println("Login thất bại!");
        }
    }
}
