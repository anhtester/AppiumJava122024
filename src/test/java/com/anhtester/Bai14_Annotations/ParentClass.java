package com.anhtester.Bai14_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ParentClass {
    @BeforeClass
    public void beforeBaseClass() {
        System.out.println("Parent Before Class method");
    }

    @AfterClass
    public void afterBaseClass() {
        System.out.println("Parent After Class method");
    }

    @BeforeMethod
    public void beforeBaseMethod() {
        System.out.println("Parent Before method");
    }

    @AfterMethod
    public void afterBaseMethod() {
        System.out.println("Parent After method");
    }
}
