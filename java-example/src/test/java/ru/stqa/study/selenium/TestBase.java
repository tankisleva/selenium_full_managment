package ru.stqa.study.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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


    protected void openLiteCartAdmin(){
        driver.navigate().to("http://localhost/litecart/public_html/admin/");
    }

    protected void openLiteCart(){
        driver.navigate().to("http://localhost/litecart/public_html/");
    }

    protected void loginLiteCart(String username, String password){
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }


    protected   boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void sleep(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
