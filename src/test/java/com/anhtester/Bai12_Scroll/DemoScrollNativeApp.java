package com.anhtester.Bai12_Scroll;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.MobileUI;
import org.testng.annotations.Test;

public class DemoScrollNativeApp extends BaseTest {

//    public void swipe(int startX, int startY, int endX, int endY, int durationMillis) {
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence swipe = new Sequence(finger, 1);
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
//        swipe.addAction(finger.createPointerDown(0));
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
//        swipe.addAction(finger.createPointerUp(0));
//        DriverManager.getDriver().perform(Collections.singletonList(swipe));
//    }

//    public void scrollGestureCommand() {
//        // Scroll gesture cho Android
//        Map<String, Object> scrollParams = new HashMap<>();
//        scrollParams.put("left", 670); //vị trí mép trái vùng cuộn cách mép trái màn hình
//        scrollParams.put("top", 500); //xác định mép trên của vùng cuộn
//        scrollParams.put("width", 200); //chiều ngang của vùng kéo
//        scrollParams.put("height", 2000); //chiều dài của vùng kéo
//        scrollParams.put("direction", "down"); //Scroll theo chiều từ trên xuống dưới (up, down, left, right)
//        scrollParams.put("percent", 1); //Scroll 100% của vùng kéo được chỉ định (width, height)
//
//        // Thực hiện scroll gesture
//        DriverManager.getDriver().executeScript("mobile: scrollGesture", scrollParams);
//    }

    @Test
    public void testScrollUsingW3CActions() {
        MobileUI.scroll(670, 2442, 670, 1200, 1000);
        MobileUI.scroll(670, 2442, 670, 1200, 1000);
        MobileUI.scroll(670, 2442, 670, 1200, 1000);
        MobileUI.scroll(670, 2442, 670, 1200, 1000);
    }

    @Test
    public void testScrollUsingMobileCommand() {
        MobileUI.scrollGestureCommand();
        MobileUI.scrollGestureCommand();
        MobileUI.scrollGestureCommand();
    }

}
