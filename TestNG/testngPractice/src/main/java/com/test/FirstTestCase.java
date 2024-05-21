package com.test;

import org.testng.annotations.Test;

public class FirstTestCase {
    @Test(priority=3)
    public void setUp() {
        System.out.println("setup");
    }

    @Test(priority=2)
    public void test() {
        System.out.println("login");
    }
}
