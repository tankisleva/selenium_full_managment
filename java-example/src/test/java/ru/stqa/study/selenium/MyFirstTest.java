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
public class MyFirstTest {
  private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait =  new WebDriverWait(driver, 10);
    }


    @Test
    public void myFirstTest() {
        driver.navigate().to("https://www.mamba.ru/");
        driver.findElement(By.cssSelector(".icon-signup")).click();
       driver.findElement(By.cssSelector(".icon.reg"));


    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
