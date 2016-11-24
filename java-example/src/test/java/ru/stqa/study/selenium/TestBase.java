package ru.stqa.study.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by oleg on 24.11.16.
 */
public class TestBase {


    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void start(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait =  new WebDriverWait(driver, 10);
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
