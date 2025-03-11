package com.anhtester.Bai13_HandleFlutterApp;

import com.anhtester.common.BaseTestFlutterPlatform;
import com.anhtester.keywords.MobileUI;
import org.testng.annotations.Test;

public class DemoHandleFlutterApp extends BaseTestFlutterPlatform {
    @Test
    public void testLoginTaurusApp() {
        //DriverManager.getDriver().findElement(AppiumBy.xpath(""));
        flutterFinder.byValueKey("txt-email").sendKeys("admin");
        MobileUI.sleep(1);
        flutterFinder.byValueKey("txt-password").sendKeys("admin");
        MobileUI.sleep(1);
        flutterFinder.byText("Sign in").click();
        MobileUI.sleep(3);
    }
}
