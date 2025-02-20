package com.anhtester.Bao10_Radio_Checkbox;

import com.anhtester.common.BaseTestTaurusApp;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class DemoZoom extends BaseTestTaurusApp {

    public void zoom(WebElement element, double scale) {
        int centerX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int centerY = element.getLocation().getY() + element.getSize().getHeight() / 2;
        int distance = 100; // Khoảng cách giữa hai ngón tay

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence zoom = new Sequence(finger1, 1);
        zoom.addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX - distance, centerY));
        zoom.addAction(finger1.createPointerDown(0));

        Sequence zoom2 = new Sequence(finger2, 1);
        zoom2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX + distance, centerY));
        zoom2.addAction(finger2.createPointerDown(0));

        if (scale > 1) { // Phóng to
            for (int i = 0; i < 10; i++) {
                zoom.addAction(finger1.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX - distance / 2, centerY));
                zoom2.addAction(finger2.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + distance / 2, centerY));
            }
        } else { // Thu nhỏ
            for (int i = 0; i < 10; i++) {
                zoom.addAction(finger1.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX - distance * 2, centerY));
                zoom2.addAction(finger2.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + distance * 2, centerY));
            }
        }

        zoom.addAction(finger1.createPointerUp(0));
        zoom2.addAction(finger2.createPointerUp(0));

        DriverManager.getDriver().perform(Arrays.asList(zoom, zoom2));
    }

    @Test(priority = 1)
    public void demoZoomIn() {
        loginTaurusApp();
        MobileUI.sleep(2);

        WebElement inputSearch = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText"));
        zoom(inputSearch, 2); // Phóng to gấp 2 lần

        MobileUI.sleep(3);
    }

    @Test(priority = 2)
    public void demoZoomOut() {
        loginTaurusApp();
        MobileUI.sleep(2);

        WebElement inputSearch = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText"));
        zoom(inputSearch, 0.5); // Thu nhỏ 2 lần

        MobileUI.sleep(3);
    }

}