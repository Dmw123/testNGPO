package com.testing.testshop;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePage {
    //成员变量 driver 让所有的测试方法都使用同一个浏览器
    public static WebDriver driver;
    public String homeUrl = "http://www.testingedu.com.cn:8000/Home";

    //URL:http://www.testingedu.com.cn:8000  测试账号：13800138006密码:123456

    //测试环境准备工作
    @BeforeTest
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        //添加隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(homeUrl);
    }

    //登录的测试用例
    @Test
    public void shopLogin(){

        driver.findElement(By.xpath("//a[text()='登录']")).click();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("13800138006");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id='verify_code']")).sendKeys("1");
        driver.findElement(By.xpath("//a[@name=\"sbtbutton\"]")).click();
        String username = driver.findElement(By.xpath("//a[@class=\"red userinfo\"]")).getText();
        System.out.println("用户名是"+username);
        Assert.assertEquals(username,"胡汉三回来了");
    }


    //在登录完成之后，进行商品搜索
    @Test
    public void shopSearch(){
        //测试buz
        driver.findElement(By.xpath("//a[text()='返回商城首页']")).click();
        driver.findElement(By.xpath("//*[@id ='q']")).sendKeys("华为");
        driver.findElement(By.xpath("//button[text()='搜索']")).click();
        //预期结果
        String shopName = driver.findElement(By.xpath("//div[@class =\"shop-list-splb p\"]/ul/li[1]//div[@class='shop_name2']/a")).getText();
        Assert.assertTrue(shopName.contains("华为"));
    }

}
