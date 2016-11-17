package ru.stqa.study.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by oleg on 17.11.16.
 */
public class TestLoginLitecartAdmin {

        private WebDriver driver;
        private WebDriverWait wait;

        @Before
        public void start(){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait =  new WebDriverWait(driver, 10);
        }


        @Test
        public void testLoginAdminLiteCart() {
            driver.navigate().to("http://localhost/litecart/public_html/admin/");
            driver.findElement(By.name("username")).click();
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("login")).click();


        }


        @After
        public void stop(){
            driver.quit();
            driver = null;
        }
}
