package ru.stqa.study.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by oleg on 24.11.16.
 */
public class TestVerifySticker extends TestBase {


    @Test
    public void testVefifySticker() throws Exception {
        openLiteCart();

        List<WebElement> mostPopulars = driver.findElements(By.cssSelector("div#box-most-popular li"));
        List<WebElement> boxCampaigns = driver.findElements(By.cssSelector("div#box-campaigns li"));
        List<WebElement> boxLatestProducts = driver.findElements(By.cssSelector("div#box-latest-products li"));

        for (WebElement mostPopular: mostPopulars){
            Assert.assertTrue(mostPopular.findElements(By.cssSelector("div.sticker")).size()==1);
        }

        for (WebElement boxCampaign: boxCampaigns){
            Assert.assertTrue(boxCampaign.findElements(By.cssSelector("div.sticker")).size()==1);
        }

        for (WebElement boxLatestProduct: boxLatestProducts){
            Assert.assertTrue(boxLatestProduct.findElements(By.cssSelector("div.sticker")).size()==1);
        }
}

}
