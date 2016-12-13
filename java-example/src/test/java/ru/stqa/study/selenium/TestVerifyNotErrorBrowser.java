package ru.stqa.study.selenium;

import junit.framework.JUnit4TestAdapter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;


/**
 * Created by oleg on 13.12.16.
 */
public class TestVerifyNotErrorBrowser extends TestBase {

    @Test
    public void testVerifyNotErrorBrowser() throws Exception {
        openLiteCartAdmin();
        loginLiteCart("admin", "admin");
        sleep(500);
        click(By.cssSelector("a[href*='?app=catalog&doc=catalog']"));
        sleep(500);
        click(By.cssSelector("a[href*='?app=catalog&doc=catalog&category_id=1']"));
        List<WebElement> products = driver.findElements(By.cssSelector("tr.row img + a"));

        for (WebElement product: products){
            product.click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                if (!l.getMessage().equals(""))
                {
                    Assert.fail("После открытия товара появлятся ошибка браузера "+l.getMessage());}
            }
            driver.navigate().back();
        }


    }
}