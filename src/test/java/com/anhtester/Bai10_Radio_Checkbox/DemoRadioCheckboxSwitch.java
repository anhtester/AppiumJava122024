package com.anhtester.Bai10_Radio_Checkbox;

import com.anhtester.common.BaseTestTaurusApp;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class DemoRadioCheckboxSwitch extends BaseTestTaurusApp {

    @Test(priority = 1)
    public void testAddTable() {
        loginTaurusApp();

        //Navigate to config
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Config")).click();

        //Add table
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[contains(@content-desc,'Tables management')]")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Add Table")).click();

        //Check status
        String checkBeforeClick = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Switch")).getAttribute("checked");
        System.out.println(checkBeforeClick);
        MobileUI.sleep(1);
        //Click to turn on
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Switch")).click();
        MobileUI.sleep(1);
        //Check status
        String checkAfterClick = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Switch")).getAttribute("checked");
        System.out.println(checkAfterClick);
    }
}