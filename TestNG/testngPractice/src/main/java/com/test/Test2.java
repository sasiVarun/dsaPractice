package com.test;

import org.testng.annotations.*;

public class Test2 {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before-class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After-Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before-every test method..");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After-every test method..");
    }
    @Test(enabled = false)
    public void test3(){
        System.out.println("This is test3...");
    }
    @Test
    public void test4(){
        System.out.println("This is test4...");
    }

}
