package ru.stqa.study.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.study.selenium.model.Customer;
import ru.stqa.study.selenium.pages.*;
import java.util.Set;


/**
 * Created by oleg on 18.12.16.
 */
public class Application {

    private WebDriver driver;

    public RegistrationPage registrationPage;
    public AdminPanelLoginPage adminPanelLoginPage;
    public CustomerListPage customerListPage;
    public ProductPage productPage;


    public Application() {
        driver = new FirefoxDriver();
        registrationPage = new RegistrationPage(driver);
        adminPanelLoginPage = new AdminPanelLoginPage(driver);
        customerListPage = new CustomerListPage(driver);
        productPage = new ProductPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void registerNewCustomer(Customer customer) {
        registrationPage.open();
        registrationPage.firstnameInput.sendKeys(customer.getFirstname());
        registrationPage.lastnameInput.sendKeys(customer.getLastname());
        registrationPage.address1Input.sendKeys(customer.getAddress());
        registrationPage.postcodeInput.sendKeys(customer.getPostcode());
        registrationPage.cityInput.sendKeys(customer.getCity());
        registrationPage.selectCountry(customer.getCountry());
        registrationPage.selectZone(customer.getZone());
        registrationPage.emailInput.sendKeys(customer.getEmail());
        registrationPage.phoneInput.sendKeys(customer.getPhone());
        registrationPage.passwordInput.sendKeys(customer.getPassword());
        registrationPage.confirmedPasswordInput.sendKeys(customer.getPassword());
        registrationPage.createAccountButton.click();
    }


    public void addProductToShoppingBasket(String product) {
        productPage.open();
        sleep(500);
        productPage.productcCampaigns.get(0).click();
        sleep(500);
        productPage.selectProduct(product);
        sleep(500);
        productPage.addProductToBacket.click();

    }

    public Set<String> getCustomerIds() {
        if (adminPanelLoginPage.open().isOnThisPage()) {
            adminPanelLoginPage.enterUsername("admin").enterPassword("admin").submitLogin();
        }

        return customerListPage.open().getCustomerIds();
    }

    public void sleep(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
