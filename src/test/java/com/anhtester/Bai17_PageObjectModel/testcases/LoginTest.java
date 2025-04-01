package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTestTaurusApp;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestTaurusApp {

    //Khai báo các đối tượng Page class liên quan
    private LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess() {
        //Khởi tạo đối tượng Page class
        loginPage = new LoginPage();

        //Gọi hàm từ Page class sử dụng
        loginPage.login("admin", "admin"); //Sau này truyền từ Excel
        loginPage.verifyLoginSuccess();
        //Thiếu hàm gì đó, đi sang class Page để bổ sung
    }

    @Test(priority = 2)
    public void testLoginFailWithUsernameInvalid() {
        //Khởi tạo đối tượng Page class
        loginPage = new LoginPage();

        //Gọi hàm từ Page class sử dụng
        loginPage.login("admin123", "admin");
        loginPage.verifyLoginFail();
    }

    @Test(priority = 3)
    public void testForgotPassword() {
        //Khởi tạo đối tượng Page class
        loginPage = new LoginPage();

        loginPage.forgotPassword("email@example.com");
    }
}
