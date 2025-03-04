package com.anhtester.keywords;

import com.anhtester.drivers.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MobileUI {
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void swipe(int startX, int startY, int endX, int endY, int durationMillis) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(0));
        DriverManager.getDriver().perform(Collections.singletonList(swipe));
    }

    public static void swipeLeft() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        //int startY = size.height / 2; // Ở chính giữa màn hình
        int startY = (int) (size.height * 0.3); // 1/3 bên trên màn hình
        int endX = (int) (size.width * 0.2);
        int endY = startY; // Giữ nguyên độ cao
        int duration = 200;

        swipe(startX, startY, endX, endY, duration);
    }

    public static void swipeRight() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        //int startY = size.height / 2; // Ở chính giữa màn hình
        int startY = (int) (size.height * 0.3); // 1/3 bên trên màn hình
        int endX = (int) (size.width * 0.8);
        int endY = startY; // Giữ nguyên độ cao
        int duration = 200;

        swipe(startX, startY, endX, endY, duration);
    }

    private static Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2,
                location.getY() + size.getHeight() / 2);
    }

    public static void tap(WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerOfElement = getCenterOfElement(location, size);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(500)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        DriverManager.getDriver().perform(Collections.singletonList(sequence));
    }

    public static void tap(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(200))); //Chạm nhẹ nhanh
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverManager.getDriver().perform(Arrays.asList(tap));
    }

    public static void tap(int x, int y, int second) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(second))); //Chạm vào với thời gian chỉ định
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverManager.getDriver().perform(Arrays.asList(tap));
    }

    public static void zoom(WebElement element, double scale) {
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

    public static void scroll(int startX, int startY, int endX, int endY, int durationMillis) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(0));
        DriverManager.getDriver().perform(Collections.singletonList(swipe));
    }

    public static void scrollGestureCommand() {
        // Scroll gesture cho Android
        Map<String, Object> scrollParams = new HashMap<>();
        scrollParams.put("left", 670); //vị trí mép trái vùng cuộn cách mép trái màn hình
        scrollParams.put("top", 500); //xác định mép trên của vùng cuộn
        scrollParams.put("width", 200); //chiều ngang của vùng kéo
        scrollParams.put("height", 2000); //chiều dài của vùng kéo
        scrollParams.put("direction", "down"); //Scroll theo chiều từ trên xuống dưới (up, down, left, right)
        scrollParams.put("percent", 1); //Scroll 100% của vùng kéo được chỉ định (width, height)

        // Thực hiện scroll gesture
        DriverManager.getDriver().executeScript("mobile: scrollGesture", scrollParams);
    }
}