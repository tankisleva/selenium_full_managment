package ru.stqa.study.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by oleg on 01.12.16.
 */
public class TestCreateAccount extends TestBase {

    @Test
    public void testCreateAccount() throws Exception{
        openLiteCart();
        String email = generateText(8)+"@domen.ru";
        String password = "v1234567";
        click(By.cssSelector("form a[href*=create_account]"));
        sleep(500);
        type(By.cssSelector("input[name=tax_id]"),"13243535");
        type(By.cssSelector("input[name=company]"),"wamba");
        type(By.cssSelector("input[name=firstname]"),"Oleg");
        type(By.cssSelector("input[name=lastname]"),"Malyshev");
        type(By.cssSelector("input[name=address1]"),"parkway yraeve 11");
        type(By.cssSelector("input[name=address2]"),"parkway yraeve 12");
        type(By.cssSelector("input[name=postcode]"),"111000");
        type(By.cssSelector("input[name=city]"),"Moscow");
        type(By.cssSelector("input[name=email]"),email);
        type(By.cssSelector("input[name=phone]"),"+792949583958");
        type(By.cssSelector("input[name=password]"),password);
        type(By.cssSelector("input[name=confirmed_password]"),password);
        click(By.cssSelector("button[name=create_account]"));
        sleep(500);
        click(By.cssSelector("div#box-account a[href*=logout]"));
        sleep(500);
        type(By.cssSelector("input[name=email]"),email);
        type(By.cssSelector("input[name=password]"),password);
        click(By.cssSelector("button[name=login]"));
        sleep(500);
        click(By.cssSelector("div#box-account a[href*=logout]"));








    }
}
