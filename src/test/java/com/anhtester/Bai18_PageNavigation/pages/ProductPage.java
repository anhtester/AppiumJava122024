package com.anhtester.Bai18_PageNavigation.pages;

import com.anhtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void addNewProduct() {
        System.out.println("Add new product");
    }
}
