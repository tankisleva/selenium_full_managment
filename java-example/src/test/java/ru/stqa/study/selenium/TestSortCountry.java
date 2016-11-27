package ru.stqa.study.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.*;
import java.util.Collections.*;

/**
 * Created by oleg on 25.11.16.
 */
public class TestSortCountry extends TestBase {


    @Test
    public void testSortCountry() throws Exception {
        openLiteCartAdmin();
        loginLiteCart("admin", "admin");
        driver.findElement(By.cssSelector("a[href*=countries]")).click();

        /*Блока кода, проверяющий сортировку стран по алфавиту */
        String contriestext = "";
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row td:nth-of-type(5) a"));

        for (WebElement country : countries) {
            contriestext = contriestext + "\n" + country.getText();

        }
        String[] unSotrArray = contriestext.split("\n");
        String[] sotrArray = contriestext.split("\n");

        for (int i = 0; i < unSotrArray.length; i++) {
            System.out.print(unSotrArray[i] + "\n");
        }

        Arrays.sort(sotrArray);

                for (int i = 0; i < sotrArray.length; i++) {
            System.out.print(sotrArray[i] + "/n");
        }

        Assert.assertArrayEquals(sotrArray, unSotrArray);


        /*Блок кода проходящий по всем таймзонам больше нуля, кликающий на эту таймзону и проверяющий сортировку там*/

        List<WebElement> zones = driver.findElements(By.cssSelector("tr.row"));

        for (WebElement zone : zones) {
            if (
                    !zone.findElements(By.cssSelector("td")).get(6).getText().equals("0"))
            {
                zone.findElements(By.cssSelector("td")).get(5).click();
                sleep(500);
                List<WebElement> zoneContries = driver.findElements(By.cssSelector("table#table-zones tr + tr td:nth-of-type(3) input"));
                String zonesText = "";
                for (WebElement zoneCountryInput : zoneContries)
                {
                    zonesText = zonesText + "\n" + zoneCountryInput.getAttribute("value");

                }

                String[] unSotrArrayZonesText = contriestext.split("\n");
                String[] sotrArrayZonesText = contriestext.split("\n");

                for (int i = 0; i < unSotrArrayZonesText.length; i++) {
                    System.out.print(unSotrArrayZonesText[i] + "\n");
                }

                Arrays.sort(sotrArray);

                for (int i = 0; i < sotrArrayZonesText.length; i++) {
                    System.out.print(sotrArrayZonesText[i] + "/n");
                }

                Assert.assertArrayEquals(sotrArrayZonesText, unSotrArrayZonesText);
                driver.navigate().back();
                sleep(500);

            }


        }


    }
}



