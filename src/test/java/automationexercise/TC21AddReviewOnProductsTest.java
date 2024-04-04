package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;
import java.util.Random;

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
        getDriver().manage().window().maximize();
        getDriver().get(BASE_URL);

        getDriver().findElement(By.xpath("//a[@href='/products']")).click();

        Helper.skipAd(getDriver());

        Assert.assertEquals(getDriver().getCurrentUrl(), BASE_URL + "/products");

        By products = By.xpath("//h2[contains(@class, 'title text-center') and text()='All Products']");
        Helper.verify(getDriver().findElement(products), "ALL PRODUCTS");

        List<WebElement> cards = getDriver().findElements(By.xpath("//a[text()='View Product']"));

        int randomIndex = new Random().nextInt(cards.size());
        System.out.println(randomIndex);
        WebElement randomCard = cards.get(randomIndex);
        Helper.scrollToIntoView(getDriver(), randomCard);
        randomCard.click();

        Helper.skipAd(getDriver());
        By reviews = By.xpath("//li[@class='active']//a[@href='#reviews']");
        Helper.verify(getDriver().findElement(reviews), "WRITE YOUR REVIEW");

        enterTextById("name", "Pashu Pati");
        enterTextById("email", "qwerty@gmail.com");
        enterTextById("review", "This is a test review.");

        Helper.scrollOnce(getDriver());
        getDriver().findElement(By.id("button-review")).click();

        By selector = By.cssSelector("#review-section .alert-success.alert span");
        Helper.verify(getDriver().findElement(selector), "Thank you for your review.");
    }

    private void enterTextById(String id, String text) {
        getDriver().findElement(By.id(id)).sendKeys(text);
    }
}
