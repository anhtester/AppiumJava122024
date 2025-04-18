package com.anhtester.Bai18_PageNavigation.testcases;

import com.anhtester.Bai18_PageNavigation.pages.ConfigPage;
import com.anhtester.Bai18_PageNavigation.pages.LoginPage;
import com.anhtester.Bai18_PageNavigation.pages.ProductPage;
import com.anhtester.common.BaseTestTaurusApp;
import org.testng.annotations.Test;

public class ProductTest extends BaseTestTaurusApp {

    private LoginPage loginPage;
    private ConfigPage configPage;
    private ProductPage productPage;

    @Test
    public void testAddNewProduct() {
        loginPage = new LoginPage();
        loginPage.login("admin", "admin");

        configPage = new ConfigPage();
        productPage = configPage.openProductManagement();

        //productPage = new ProductPage();
        productPage.addNewProduct();
    }
}
