package ru.stqa.study.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by oleg on 16.11.16.
 */
public class MyFirstTest extends TestBase{



    @Test
    public void myFirstTest() {
        driver.navigate().to("https://www.mamba.ru/");
        driver.findElement(By.cssSelector(".icon-signup")).click();
       driver.findElement(By.cssSelector(".icon.reg"));


    }




}
