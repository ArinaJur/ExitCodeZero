package saucedemoexercises.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SauceProductsPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement logoText;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> productNames;

    public SauceProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLogoText() {
        return logoText.getText();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<String> getProductNames() {
        return productNames.stream().map(WebElement::getText).toList();
    }

    public List<String> selectSortOption(String option) {
        sortDropdown.click();
        String xpathExpression = "//option[text()='" + option + "']";
        driver.findElement(By.xpath(xpathExpression)).click();
        return getProductNames();
    }

    public void assertSortingOrder(String option, List<String> actualNames) {
        List<String> sortedNames =
                actualNames.stream().sorted(
                        option.equals("az")
                        ? String::compareTo
                        : Comparator.reverseOrder())
                           .toList();

        Assert.assertEquals(actualNames, sortedNames);
    }

}
