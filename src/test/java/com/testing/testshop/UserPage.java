package com.testing.testshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserPage {

    private WebDriver driver;
    public String userUrl = "http://www.testingedu.com.cn:8000/Home/user/index.html";
    //URL:http://www.testingedu.com.cn:8000  测试账号：13800138006密码:123456

    //测试环境准备工作
    @BeforeTest
    public void openBrowser(){
        driver=HomePage.driver;
        driver.get(userUrl);
    }

    @Test
    public void modifierInfo(){

        driver.findElement(By.xpath("//li/a[text()='个人信息']")).click();
        driver.findElement(By.xpath("//*[@id='nickname']")).clear();
        driver.findElement(By.xpath("//*[@id='nickname']")).sendKeys("胡汉三回来了");
        driver.findElement(By.xpath("//label[@for='woman']")).click();
        driver.findElement(By.xpath("//input[@value='确认保存']")).click();
        String username = driver.findElement(By.xpath("//a[@class=\"red userinfo\"]")).getText();
        System.out.println("用户名是"+username);
        Assert.assertEquals(username,"胡汉三回来了");



    }

}
