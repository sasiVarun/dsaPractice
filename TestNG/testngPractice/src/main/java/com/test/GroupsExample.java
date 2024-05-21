package com.test;

import org.testng.annotations.Test;

public class GroupsExample {
    @Test(groups = {"sanity"})
    public void test1(){
        System.out.println("Test 1");
    }
    @Test(groups = {"regression"})
    public void test2(){
        System.out.println("Test 2");
    }
    @Test(groups = {"sanity","regression"})
    public void test3(){
        System.out.println("Test 3");
    }
}
