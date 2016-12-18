package ru.stqa.study.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Set;

/**
 * Created by oleg on 08.12.16.
 */
public class TestVerifyNewWindowOld extends TestBaseOld {


    @Test
    public void testVerifyNewWindow() throws Exception {
        openLiteCartAdmin();
        loginLiteCart("admin", "admin");
        click(By.cssSelector("a[href*='?app=countries&doc=countries'] span.name"));
        sleep(500);
        click(By.cssSelector("a.button"));
        sleep(500);
        List<WebElement> windowElements =  driver.findElements(By.cssSelector("i.fa.fa-external-link"));

        for (WebElement windowElement: windowElements){
            String originalWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            windowElement.click();
            Set <String>  newWindows =  driver.getWindowHandles();
            newWindows.removeAll(oldWindows);
            String newWindow  = newWindows.iterator().next();
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(originalWindow);


        }

    }


}
