package ru.stqa.study.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by oleg on 18.12.16.
 */
public class ProductPage extends Page{


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "div#box-campaigns li")
    public List <WebElement> productcCampaigns;

    @FindBy(css = "button[name='add_cart_product']")
    public WebElement addProductToBacket;

    @FindBy(css = "div#cart span.quantity")
    public WebElement countProductsInBasket;

    @FindBy(css = "div#box-most-popular a[href*=red-duck-p-3]")
    public WebElement redDuckP3;


    @FindBy(css = "div#box-latest-products a[href*=yellow-duck-p-1]")
    public WebElement yellowDuck3;

    @FindBy(css = "div#order_confirmation-wrapper")
    public WebElement tableElement;

    @FindBy(css= "div#cart a.link")
    public WebElement backet;

    @FindBy(css = "[name=remove_cart_item]")
    public WebElement removeBacket;

    @FindBy(css = "[name=remove_cart_item]")
    public List<WebElement> removeBackets;

    public ProductPage open() {
        driver.navigate().to("http://localhost/litecart/public_html/");
        return this;
    }


    public void selectProduct(String product) {
        Select selectProduct = new Select(driver.findElement(By.name("options[Size]")));
        selectProduct.selectByValue(product);
    }

    public void sleep(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
