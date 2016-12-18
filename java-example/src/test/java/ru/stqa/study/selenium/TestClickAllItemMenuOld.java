package ru.stqa.study.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by oleg on 24.11.16.
 */
public class TestClickAllItemMenuOld extends TestBaseOld {

    @Test
    public void testAllItemMenuClick() throws Exception {
        openLiteCartAdmin();
        loginLiteCart("admin", "admin");

        int count = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).size();
        for (int i = 0; i <count; i++) {
            driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(i).click();
            sleep(500);
            isElementPresent(By.tagName("h1"));

            System.out.println(driver.findElement(By.tagName("h1")).getText());
            if ( driver.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li")).size()!=0){

                int newCount = driver.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li")).size();
                for (int l = 0; l < newCount; l++) {
                    driver.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li")).get(l).click();
                    sleep(500);
                    isElementPresent(By.tagName("h1"));
                    System.out.println(driver.findElement(By.tagName("h1")).getText());
                }
            }

            }
        }
    }











