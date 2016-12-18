package ru.stqa.study.selenium;


import org.junit.Test;
import org.openqa.selenium.By;


/**
 * Created by oleg on 17.11.16.
 */
public class TestLoginLitecartAdminOld extends TestBaseOld {




        @Test
        public void testLoginAdminLiteCart() {
            driver.navigate().to("http://localhost/litecart/public_html/admin/");
            driver.findElement(By.name("username")).click();
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("login")).click();


        }

}
