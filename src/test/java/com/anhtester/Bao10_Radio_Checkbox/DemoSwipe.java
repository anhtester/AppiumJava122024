package com.anhtester.Bao10_Radio_Checkbox;

import com.anhtester.common.BaseTestTaurusApp;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class DemoSwipe extends BaseTestTaurusApp {

    public void swipe(int startX, int startY, int endX, int endY, int durationMillis) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(0));
        DriverManager.getDriver().perform(Collections.singletonList(swipe));
    }

    public void swipeLeft() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        //int startY = size.height / 2; // Ở chính giữa màn hình
        int startY = (int) (size.height * 0.3); // 1/3 bên trên màn hình
        int endX = (int) (size.width * 0.2);
        int endY = startY; // Giữ nguyên độ cao
        int duration = 200;

        swipe(startX, startY, endX, endY, duration);
    }

    public void swipeRight() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        //int startY = size.height / 2; // Ở chính giữa màn hình
        int startY = (int) (size.height * 0.3); // 1/3 bên trên màn hình
        int endX = (int) (size.width * 0.8);
        int endY = startY; // Giữ nguyên độ cao
        int duration = 200;

        swipe(startX, startY, endX, endY, duration);
    }

    @Test(priority = 1)
    public void demoSwipe1() {
        loginTaurusApp();
        downloadDataFromServer(1);

        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Back")).click();
        MobileUI.sleep(2);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu")).click();
        MobileUI.sleep(4);

        //Từ dưới lên trên
        swipe(671, 1956, 671, 1229, 500);

        MobileUI.sleep(3);
    }


    @Test(priority = 2)
    public void demoSwipe2() {
        loginTaurusApp();

        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Date")).click();
        MobileUI.sleep(4);

        swipeLeft();
        MobileUI.sleep(2);
        swipeRight();
        MobileUI.sleep(2);

        //Nếu vị trí cố định ấy không dùng được thì chúng ta sẽ bắt toạ độ cụ thể

        //Từ trái qua phải
        swipe(95, 1032, 1255, 1032, 200);
        MobileUI.sleep(2);
        //Từ phải qua trái
        swipe(1255, 1032, 95, 1032, 200);

        MobileUI.sleep(3);
    }


}