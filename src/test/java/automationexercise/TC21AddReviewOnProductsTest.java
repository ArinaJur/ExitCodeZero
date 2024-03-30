package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static automationexercise.Helper.BASE_URL;

/**
 * Test Case 21: Add review on product
 * 1. Launch browser
 * 2. Navigate to url '<a href="http://automationexercise.com"></a>'
 * 3. Click on 'Products' button
 * 4. Verify user is navigated to ALL PRODUCTS page successfully
 * 5. Click on 'View Product' button
 * 6. Verify 'Write Your Review' is visible
 * 7. Enter name, email and review
 * 8. Click 'Submit' button
 * 9. Verify success message 'Thank you for your review.'
 * */
public class TC21AddReviewOnProductsTest extends BaseTest {

    @Test(invocationCount = 1)
    public void testAddReviewOnProduct() {
        getDriver().findElement(By.xpath("//a[@href='/products']")).click();

        Helper.skipAd(new Actions(getDriver()));

        Assert.assertEquals(getDriver().getCurrentUrl(), BASE_URL + "/products");

        By products = By.xpath("//h2[contains(@class, 'title text-center') and text()='All Products']");
        Helper.verify(getDriver().findElement(products), "ALL PRODUCTS");

        scrollOnce();

        getDriver().findElements(By.xpath("//a[contains(text(), 'View Product')]")).get(0).click();

        By reviews = By.xpath("//li[@class='active']//a[@href='#reviews']");
        Helper.verify(getDriver().findElement(reviews), "WRITE YOUR REVIEW");

        enterTextById("name", "Pashu Pati");
        enterTextById("email", "qwerty@gmail.com");
        enterTextById("review", "This is a test review.");

        scrollOnce();
        getDriver().findElement(By.id("button-review")).click();

        By selector = By.cssSelector("#review-section .alert-success.alert span");
        Helper.verify(getDriver().findElement(selector), "Thank you for your review.");
    }

    private void scrollOnce() {
        ((JavascriptExecutor) getDriver())
                .executeScript("window.scrollBy(0, 500);");
    }

    private void enterTextById(String id, String text) {
        getDriver().findElement(By.id(id)).sendKeys(text);
    }
}
