package ru.stqa.study.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by oleg on 24.11.16.
 */
public class TestBaseOld {


    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait =  new WebDriverWait(driver, 10);
    }


    protected void openLiteCartAdmin(){
        driver.navigate().to("http://localhost/litecart/public_html/admin/");
    }

    protected void openLiteCart(){
        driver.navigate().to("http://localhost/litecart/public_html/");
    }

    protected void loginLiteCart(String username, String password){
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }


    protected   boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void sleep(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String generateText(int Length) {

        String[] lettersName = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
                "g", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z" };

        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(Length);

        for (int i = 0; i < Length; i++)
            sb.append(lettersName[rnd.nextInt(lettersName.length)]);

        return sb.toString();


    }


    protected void type(By locator, String text) {
        click(locator);
//        if (text != null) {
//            String existintext = driver.findElement(locator).getAttribute("value");
//            if (!text.equals(existintext)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
//            }
//
//        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }


//    protected void attach(By locator, File file) {
//
//        if (file != null) {
//            driver.findElement(locator).sendKeys(file.getAbsolutePath());
//        }
//
//    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
