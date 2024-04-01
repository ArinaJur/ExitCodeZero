import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*Test Case 13: Verify Product in Cart (without verify quantity)
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'View Product' for any product on home page
    5. Verify product detail is opened
    - 6. (Increase quantity to 4)
    7. Click 'Add to cart' button
    8. Click 'View Cart' button
    9. Verify that product is displayed in cart page (with exact quantity)*/
public class Task13VerifyProductInCartTest extends BaseTest {

    private static final String BASE_URL = "https://automationexercise.com";

    @Test
    public void testVerifyProductQuantityInCart() throws InterruptedException {
        final String expectVerifyHomePage = "FEATURES ITEMS";
        final String expectVerifyProductDetail = "Availability:";

        getDriver().get(BASE_URL);
        getDriver().manage().window().maximize();

        final String actualVerifyHomePage = getDriver().findElement(By.xpath("//h2[text()='Features Items']")).getText();

        Assert.assertEquals(actualVerifyHomePage, expectVerifyHomePage);

        List<WebElement> viewProductCards = getDriver().findElements(By.xpath("//a[text()='View Product']"));
        final int randomElementIndex = ThreadLocalRandom.current().nextInt(viewProductCards.size());
        WebElement randomViewProductCardButton = viewProductCards.get(randomElementIndex);

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView();", randomViewProductCardButton);
        Thread.sleep(1000);

        randomViewProductCardButton.click();
        Thread.sleep(1000);

        if (!getDriver().findElements(By.xpath("//ins[@class='adsbygoogle adsbygoogle-noablate']")).isEmpty()) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            jse.executeScript(
                    "const ads = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (ads.length > 0) ads[0].remove();"
            );

            randomViewProductCardButton.click();
        }

        final String actualVerifyProductDetail = getDriver().findElement(By.xpath("//b[text()='Availability:']")).getText();

        Assert.assertEquals(actualVerifyProductDetail, expectVerifyProductDetail);
        Thread.sleep(1000);

        final String actualProductIsDisplayed = getDriver().findElement(By.xpath("//div[@class = \"product-information\"]//h2")).getText();

        getDriver().findElement(By.xpath("//button[@type = \"button\"]")).click();
        Thread.sleep(1000);

        if (!getDriver().findElements(By.xpath("//ins[@class='adsbygoogle adsbygoogle-noablate']")).isEmpty()) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            jse.executeScript(
                    "const ads = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (ads.length > 0) ads[0].remove();"
            );

            getDriver().findElement(By.xpath("//button[@type = \"button\"]")).click();
        }
        getDriver().findElement(By.xpath("//a[@href = \"/view_cart\"]/u")).click();
        Thread.sleep(1000);

        if (!getDriver().findElements(By.xpath("//ins[@class='adsbygoogle adsbygoogle-noablate']")).isEmpty()) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            jse.executeScript(
                    "const ads = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (ads.length > 0) ads[0].remove();"
            );

            getDriver().findElement(By.xpath("//a[@href = \"/view_cart\"]/u")).click();
        }
        final String expectedProductIsDisplayed = getDriver().findElement(By.xpath("//td//h4//a")).getText();

        Assert.assertEquals(expectedProductIsDisplayed, actualProductIsDisplayed);
    }
}
