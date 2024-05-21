package com.test;

import org.testng.annotations.*;

public class Test1 {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before every test method..");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After every test method..");
    }
    @Test
    public void test1(){
        System.out.println("This is test1...");
    }
    @Test
    public void test2(){
        System.out.println("This is test2...");
    }

}
