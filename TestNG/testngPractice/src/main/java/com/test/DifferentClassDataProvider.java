package com.test;

import org.testng.annotations.Test;

public class DifferentClassDataProvider {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviderEx.class)
    public void useAnotherClassData(String name, String mail){
        System.out.println(name + " - " + mail);
    }
}
