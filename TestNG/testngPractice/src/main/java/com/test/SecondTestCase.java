package com.test;

import org.testng.annotations.Test;

public class SecondTestCase {
    @Test(priority = 1)
    public void setUp() {
        System.out.println("setup 2");
    }

    @Test(priority = 4)
    public void test() {
        System.out.println("login 2");
    }
}
