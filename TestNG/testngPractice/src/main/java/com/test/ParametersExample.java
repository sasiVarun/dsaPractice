package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {

    @Test
    @Parameters({"browser","app"})
    public void run(String browser, String app){
        System.out.println(browser);
        System.out.println(app);
    }
}
