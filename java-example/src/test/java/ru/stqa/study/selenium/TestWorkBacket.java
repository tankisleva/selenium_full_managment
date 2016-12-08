package ru.stqa.study.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by oleg on 08.12.16.
 */
public class TestWorkBacket extends TestBase {

    @Test
    public void testWorkBasket() throws Exception {
        openLiteCart();
        driver.findElements(By.cssSelector("div#box-campaigns li")).get(0).click();
        Select selectProduct = new Select(driver.findElement(By.name("options[Size]")));
        selectProduct.selectByValue("Small");
        click(By.cssSelector("button[name='add_cart_product']"));
        sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#cart span.quantity")).getText(),"1");
        openLiteCart();
        sleep(500);
        click(By.cssSelector("div#box-most-popular a[href*=red-duck-p-3]"));
        sleep(500);
        click(By.cssSelector("button[name='add_cart_product']"));
        sleep(1000);
        openLiteCart();
        sleep(500);
        click(By.cssSelector("div#box-latest-products a[href*=yellow-duck-p-1]"));
        Select selectProduct1 = new Select(driver.findElement(By.name("options[Size]")));
        selectProduct1.selectByValue("Small");
        click(By.cssSelector("button[name='add_cart_product']"));
        sleep(1000);
        sleep(500);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#cart span.quantity")).getText(),"3");
        click(By.cssSelector("div#cart a.link"));
        sleep(1000);
        WebElement tableElement =  driver.findElement(By.cssSelector("div#order_confirmation-wrapper"));
        wait.until(visibilityOf(tableElement));
        while ( driver.findElements(By.cssSelector("[name=remove_cart_item]")).size() !=0)
        {
            driver.findElement(By.cssSelector("[name=remove_cart_item]")).click();
        }
        sleep(500);
        wait.until(stalenessOf(tableElement));





    }
}
