package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21ProductsNavigationTest extends BaseTest {

    private static final String BASE_URL = "https://automationexercise.com";

    @Test(invocationCount = 1)
    public void testAddReviewOnProduct() {
        WebDriver driver = getDriver();
        open(driver);
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        skipAd(new Actions(driver));

        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL + "/products");

        String expectedProducts = "ALL PRODUCTS";
        By products = By.xpath("//h2[contains(@class, 'title text-center') and text()='All Products']");
        verify(driver.findElement(products), expectedProducts);

        scrollOnce(driver);
        driver.findElements(By.xpath("//a[contains(text(), 'View Product')]")).get(0).click();

        String expected = "WRITE YOUR REVIEW";
        By reviews = By.xpath("//li[@class='active']//a[@href='#reviews']");
        verify(driver.findElement(reviews), expected);

        enterText(driver.findElement(By.id("name")), "Pashu Pati");
        enterText(driver.findElement(By.id("email")), "qwerty@gmail.com");
        enterText(driver.findElement(By.id("review")), "This is a test review.");

        scrollOnce(driver);
        driver.findElement(By.id("button-review")).click();

        String expectedH = "Thank you for your review.";
        By selector = By.cssSelector("#review-section .alert-success.alert span");
        verify(driver.findElement(selector), expectedH);
    }

    private void verify(WebElement element, String expected) {
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), expected);
    }

    private void scrollOnce(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
    }

    private void open(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    private void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    private void skipAd(Actions actions) {
        try {
            Thread.sleep(1000);
            actions.moveByOffset(50, 50).click().perform();
            Thread.sleep(2000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
