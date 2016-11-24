package ru.stqa.study.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by oleg on 24.11.16.
 */
public class TestClickAllItemMenu extends TestBase {

    @Test
    public void testAllItemMenuClick() throws Exception {
        openLiteCart();
        loginLiteCart("admin", "admin");

        int count = driver.findElements(By.cssSelector("ul#box-apps-menu li")).size();
        for (int i = 0; i <count; i++) {
            List<WebElement> elements = driver.findElements(By.cssSelector("ul#box-apps-menu li"));
            elements.get(i).click();
            sleep(500);
            isElementPresent(By.tagName("h1"));

            System.out.println(driver.findElement(By.tagName("h1")).getText());
            if ( driver.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li")).size()!=0){

                int newCount = driver.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li")).size();
                System.out.println(newCount);
                for (int l = 0; i < newCount; l++) {
                    List<WebElement> newElements = driver.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li"));
                    newElements.get(l).click();
                    sleep(500);
                    isElementPresent(By.tagName("h1"));
                    System.out.println(driver.findElement(By.tagName("h1")).getText());
                }
            }

            }
        }
    }











