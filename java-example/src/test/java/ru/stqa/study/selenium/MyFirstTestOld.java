package ru.stqa.study.selenium;


import org.junit.Test;
import org.openqa.selenium.By;


/**
 * Created by oleg on 16.11.16.
 */
public class MyFirstTestOld extends TestBaseOld {



    @Test
    public void myFirstTest() {
        driver.navigate().to("https://www.mamba.ru/");
        driver.findElement(By.cssSelector(".icon-signup")).click();
       driver.findElement(By.cssSelector(".icon.reg"));
        driver.findElement(By.name("hfhfh"));

    }




}
