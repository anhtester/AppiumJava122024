package com.anhtester.Bai16_Waits_Appium2x;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait extends BaseTest {

    @Test
    public void testExplicitWait() {
        //Set implicit wait về giá trị 0 để vô hiệu hoá
        //DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        //Khai báo đối tượng wait thuộc WebDriverWait (Explicit)
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("View menu")));
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();

        //Khai báo đối tượng wait thuộc WebDriverWait (Explicit)
        //WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(4));

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Login Menu Item")));

        //Ví dụ chỗ này sai locator, cần wait locator visible sau đó mới thao tác sau
        //Nếu nó không visible thì báo lỗi, không thao tác bước sau được
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        //Wait header present trước khi kểm tra displayed
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV")));

        WebElement headerLoginPage = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"));
        Assert.assertTrue(headerLoginPage.isDisplayed());
        String headerLoginText = headerLoginPage.getText();
        System.out.println("headerLoginText: " + headerLoginText);

        Assert.assertEquals(headerLoginText, "Login");

        //Khai báo wait thứ 2 để setup lại thời gian khác wait trước
        WebDriverWait wait2 = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        //Wait email locator visible trước khi thao tác điền email
        wait2.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET12345\"]")));

        WebDriverWait wait3 = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
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
