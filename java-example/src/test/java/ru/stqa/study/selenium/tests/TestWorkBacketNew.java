package ru.stqa.study.selenium.tests;


import org.junit.Assert;
import org.junit.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * Created by oleg on 18.12.16.
 */
public class TestWorkBacketNew extends TestBase {

    @Test
    public void testWorkBacketNew() throws Exception {
        app.addProductToShoppingBasket("Small");
        sleep(1000);
        Assert.assertEquals(app.productPage.countProductsInBasket.getText(), "1");
        app.productPage.open();
        sleep(500);
        app.productPage.redDuckP3.click();
        sleep(500);
        app.productPage.addProductToBacket.click();
        sleep(1000);
        app.productPage.open();
        sleep(500);
        app.productPage.yellowDuck3.click();
        sleep(500);
        app.productPage.selectProduct("Small");
        app.productPage.addProductToBacket.click();
        sleep(1000);
        Assert.assertEquals(app.productPage.countProductsInBasket.getText(), "3");
        app.productPage.backet.click();
        visibilityOf(app.productPage.tableElement);

        while (app.productPage.removeBackets.size() != 0) {
            app.productPage.removeBacket.click();
        }
        sleep(1000);
        stalenessOf(app.productPage.tableElement);


    }


}

