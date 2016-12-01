package ru.stqa.study.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by oleg on 01.12.16.
 */
public class TestAddNewProduct extends TestBase {

    @Test
    public void testAddNewProduct() throws Exception {
        openLiteCartAdmin();
        loginLiteCart("admin", "admin");
        click(By.cssSelector("[href*='?app=catalog&doc=catalog']"));
        sleep(500);
        click(By.cssSelector(".button[href*='doc=edit_product'] i"));
        type(By.cssSelector("input[name='name[en]']"),"Super Duck");
        click(By.cssSelector("td label:nth-of-type(1) input"));
        type(By.cssSelector("input[name=code]"),"rn004");
        click(By.cssSelector("[data-name='Rubber Ducks']"));
        click(By.cssSelector("a[href='#tab-information']"));
        Select manufacturer_id = new Select(driver.findElement(By.cssSelector("[name='manufacturer_id']")));
        manufacturer_id.selectByValue("1");
        click(By.cssSelector("[href='#tab-prices']"));
        type(By.cssSelector("input[name='purchase_price']"),"10");
        Select price = new Select(driver.findElement(By.cssSelector("[name='purchase_price_currency_code']")));
        price.selectByValue("USD");
        click(By.cssSelector("[name='save']"));
        sleep(500);
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Super Duck"));





    }

}
