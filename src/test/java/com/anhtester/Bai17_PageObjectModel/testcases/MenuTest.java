package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.Bai17_PageObjectModel.pages.MenuPage;
import com.anhtester.common.BaseTestTaurusApp;
import org.testng.annotations.Test;

public class MenuTest extends BaseTestTaurusApp {

    private LoginPage loginPage;
    private MenuPage menuPage;

    @Test
    public void testSearchTable() {
        loginPage = new LoginPage();
        loginPage.login("admin", "admin");
        loginPage.verifyLoginSuccess();

        downloadDataFromServer(2);

        menuPage = new MenuPage();
        menuPage.searchTable("Table 1");
        menuPage.checkTableResultTotal(1);
    }
}
