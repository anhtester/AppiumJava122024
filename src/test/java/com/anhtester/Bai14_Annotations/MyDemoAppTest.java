package com.anhtester.Bai14_Annotations;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MyDemoAppTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginSuccess() {
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("bod@example.com");
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).sendKeys("10203040");
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to login with given credentials")).click();
        MobileUI.sleep(2);

        WebElement title = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("title"));
        if (title.isDisplayed()) {
            System.out.println("Login success.");
        }
    }

    @Test(priority = 2)
    public void testAddProductToCart() {
        //Login trước
        //Add product to cart
        DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[1]")).click();
        MobileUI.sleep(1);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Blue color")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Increase item quantity")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to add product to cart")).click();
        MobileUI.sleep(1);
        DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV")).click();
        MobileUI.sleep(1);
        String itemTotalInCart = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/itemsTV")).getText();
        String priceTotalInCart = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/totalPriceTV")).getText();

        if (itemTotalInCart.equals("2") && priceTotalInCart.equals("$ 59.98")) {
            System.out.println("Add product to Cart success.");
        }

    }
}