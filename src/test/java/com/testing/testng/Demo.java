package com.testing.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {

    @Test(dependsOnMethods = "test2",alwaysRun = true,description = "test1...")
    public void test1(){

        System.out.println("test1...");
        //Assert.assertEquals(false,true);

    }

    @Test
    public void test2(){

        System.out.println("test2...");
        //Assert.assertEquals(false,true);

    }

    @Test(enabled = false)
    public void test3(){
        System.out.println("test3...");
    }

}
