package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import static automationexercise.Helper.BASE_URL;

/**
 * Test Case 22: Add to cart from Recommended items
 * 1. Launch browser
 * 2. Navigate to url '<a href="http://automationexercise.com"></a>'
 * 3. Scroll to bottom of page
 * 4. Verify 'RECOMMENDED ITEMS' are visible
 * 5. Click on 'Add To Cart' on Recommended product
 * 6. Click on 'View Cart' button
 * 7. Verify that product is displayed in cart page
 * */
public class TC22RecommendedItemsTest extends BaseTest {

    @Test
    public void testAddToCartFromRecommendedItems() {
        final String expected = "RECOMMENDED ITEMS";
        getDriver().manage().window().maximize();
        getDriver().get(BASE_URL);

        Helper.scrollToFooter(getDriver());

        WebElement recommendedItems = getDriver().findElement(By.xpath("//h2[contains(text(), 'recommended items')]"));
        Helper.verify(recommendedItems, expected);

        getDriver().findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")).click();
        Helper.delay(1000);
        getDriver().findElement(By.partialLinkText("View Cart")).click();

        Assert.assertEquals(getDriver().getCurrentUrl(), BASE_URL + "/view_cart");
        Assert.assertTrue(getDriver().findElement(By.xpath("//tr[@id='product-1']")).isDisplayed());
    }
}
