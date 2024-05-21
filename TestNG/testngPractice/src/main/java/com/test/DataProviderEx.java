package com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
    @Test(dataProvider = "LoginData")
    public void useData(String name, String email){
        System.out.println(name + " - " + email);
    }

    @DataProvider(name = "LoginData")
    public Object[][] shareData(){
        Object[][] data = {
                {"Ajay","Ajay@gmail.com"},
                {"Sanjay","Sanjay@gmail.com"},
                {"Vijay","Vijay@gmail.com"}
        };
        return data;
    }
}
