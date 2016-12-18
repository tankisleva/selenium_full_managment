package ru.stqa.study.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by oleg on 18.12.16.
 */
public class AdminPanelLoginPage extends Page {

    public AdminPanelLoginPage(WebDriver driver) {
        super(driver);
    }

    public AdminPanelLoginPage open() {
        driver.get("http://localhost/litecart/public_html/admin/");
        return this;
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.id("box-login")).size() > 0;
    }

    public AdminPanelLoginPage enterUsername(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
        return this;
    }

    public AdminPanelLoginPage enterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public void submitLogin() {
        driver.findElement(By.name("login")).click();
        wait.until((WebDriver d) -> d.findElement(By.id("box-apps-menu")));
    }

}
