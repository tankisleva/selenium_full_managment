package ru.stqa.study.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by oleg on 25.11.16.
 */
public class TestProductPageOld extends TestBaseOld {


    @Test
    public void testVefifyProductPage() throws Exception {
        openLiteCart();
        String regularPriceVitrina =  driver.findElements(By.cssSelector("div#box-campaigns li")).
                get(0).findElement(By.cssSelector("s.regular-price")).getText();
        System.out.println(regularPriceVitrina);
        String regularCampaignCriceVitrina =  driver.findElements(By.cssSelector("div#box-campaigns li")).
                get(0).findElement(By.cssSelector("strong.campaign-price")).getText();
        System.out.println(regularCampaignCriceVitrina);
        String colorRegularPriceVitrina = driver.findElements(By.cssSelector("div#box-campaigns li")).
                get(0).findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        System.out.println(colorRegularPriceVitrina);
        String colorRegularCampaignCriceVitrina =  driver.findElements(By.cssSelector("div#box-campaigns li")).
                get(0).findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        System.out.println(colorRegularCampaignCriceVitrina);

        driver.findElements(By.cssSelector("div#box-campaigns li")).get(0).click();
        sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/litecart/public_html/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");
        Assert.assertEquals(driver.findElement(By.cssSelector("s.regular-price")).getText(),"$20");
        Assert.assertEquals(driver.findElement(By.cssSelector("strong.campaign-price")).getText(),"$18");
        Assert.assertEquals(driver.findElement(By.cssSelector("s.regular-price")).getText(),regularPriceVitrina);
        Assert.assertEquals(driver.findElement(By.cssSelector("strong.campaign-price")).getText(),regularCampaignCriceVitrina);
        Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(),"Yellow Duck");
        Assert.assertEquals(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("Color"),"rgb(102, 102, 102)");
        Assert.assertEquals(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("Color"),"rgb(204, 0, 0)");



    }

}
