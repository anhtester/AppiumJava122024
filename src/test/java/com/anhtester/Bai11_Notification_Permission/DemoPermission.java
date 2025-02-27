package com.anhtester.Bai11_Notification_Permission;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class DemoPermission extends BaseTest {
    @Test
    public void testAcceptPermission() {
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        //DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"QR Code Scanner\"]")).click();

        //DriverManager.getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        //DriverManager.getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();
        //DriverManager.getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")).click();

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Geo Location\"]")).click();
        DriverManager.getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();

        MobileUI.sleep(10);
    }
}