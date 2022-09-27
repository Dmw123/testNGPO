package com.testing.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo5 {

    @Test
    @Parameters({"firstName","lastName"})
    public void test1(String fn,String ln){

        System.out.println("Demo5...test1...");
        System.out.println(fn+"."+ln);
    }
}
