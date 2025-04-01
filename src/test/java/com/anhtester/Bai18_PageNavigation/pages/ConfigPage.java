package com.anhtester.Bai18_PageNavigation.pages;

import com.anhtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConfigPage {
    public ConfigPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(accessibility = "")
    private WebElement productManagementItem;

    public ProductPage openProductManagement() {
        productManagementItem.click();

        return new ProductPage();
    }
}
