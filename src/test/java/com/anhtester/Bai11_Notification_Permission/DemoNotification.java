package com.anhtester.Bai11_Notification_Permission;

import com.anhtester.common.BaseTestAndroidPlatform;
import com.anhtester.drivers.AndroidDriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class DemoNotification extends BaseTestAndroidPlatform {

    @Test
    public void testHandleNotification() {
        //Mở phần thông báo bên trên cuộn xuống
        AndroidDriverManager.getDriver().openNotifications();

        //Get các tiêu đề của thông báo
        List<WebElement> notifications = AndroidDriverManager.getDriver().findElements(AppiumBy.id("android:id/title"));
        System.out.println("Danh sách tiêu đề trong thông báo: ");
        for (WebElement notification : notifications) {
            System.out.println(notification.getText());
        }

        MobileUI.sleep(2);

        //Get các mô tả của thông báo
        List<WebElement> descriptions = AndroidDriverManager.getDriver().findElements(AppiumBy.id("android:id/text"));
        System.out.println("Danh sách mô tả trong thông báo: ");

        for (WebElement description : descriptions) {
            try {
                String descriptionText = description.getText();
                System.out.println(descriptionText);
            } catch (NoSuchElementException e) {
                System.out.println("*** Không tìm thấy phần mô tả cho thông báo này (hoặc không có mô tả).");
            }
        }

        //Đóng phần Notification
        AndroidDriverManager.getDriver().navigate().back();

        //swipe(600, 2700, 600, 300, 200);

        MobileUI.sleep(3);
    }

    public void swipe(int startX, int startY, int endX, int endY, int durationMillis) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(0));
        AndroidDriverManager.getDriver().perform(Collections.singletonList(swipe));
    }

}