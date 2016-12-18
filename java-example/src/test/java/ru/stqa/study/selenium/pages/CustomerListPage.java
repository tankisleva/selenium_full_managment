package ru.stqa.study.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

/**
 * Created by oleg on 18.12.16.
 */
public class CustomerListPage extends Page {

    public CustomerListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CustomerListPage open() {
        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
        return this;
    }

    @FindBy(css = "table.dataTable tr.row")
    private List<WebElement> customerRows;

    public Set<String> getCustomerIds() {
        return customerRows.stream()
                .map(e -> e.findElements(By.tagName("td")).get(2).getText())
                .collect(toSet());
    }

}
