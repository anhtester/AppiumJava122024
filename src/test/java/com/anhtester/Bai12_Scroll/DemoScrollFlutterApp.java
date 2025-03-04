package com.anhtester.Bai12_Scroll;

import com.anhtester.common.BaseTestTaurusApp;
import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class DemoScrollFlutterApp extends BaseTestTaurusApp {

    @Test
    public void testScrollInFlutterApp() {
        loginTaurusApp();
        downloadDataFromServer(1);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Back")).click();
        MobileUI.sleep(2);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu")).click();
        MobileUI.sleep(4);

        // 1. Tìm phần tử có khả năng cuộn (ví dụ: View/ListView)
        WebElement scrollableElement = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View")); // Thay đổi locator phù hợp
        Point elementCenter = scrollableElement.getRect().getPoint().moveBy(scrollableElement.getSize().getWidth() / 2, scrollableElement.getSize().getHeight() / 2);

        // 2. Tạo PointerInput
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // 3. Tạo Sequence (chuỗi hành động) để cuộn xuống
        Sequence scrollDownSequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), elementCenter.getX(), elementCenter.getY())) // Di chuyển pointer đến tâm phần tử
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())) // Nhấn pointer xuống
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), elementCenter.getX(), elementCenter.getY() - 1000)) // Di chuyển pointer lên (cuộn xuống) 1000 pixels
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); // Nhấc pointer lên

        // 4. Thực hiện Sequence
        DriverManager.getDriver().perform(Collections.singletonList(scrollDownSequence));

        MobileUI.sleep(2);
    }

}
