package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static automationexercise.Helper.BASE_URL;

/**
 * Test Case 11: Verify Subscription in Cart page
 * 1. Launch browser
 * 2. Navigate to url '<a href="http://automationexercise.com"></a>'
 * 3. Verify that home page is visible successfully
 * 4. Click 'Cart' button
 * 5. Scroll down to footer
 * 6. Verify text 'SUBSCRIPTION'
 * 7. Enter email address in input and click arrow button
 * 8. Verify success message 'You have been successfully subscribed!' is visible
 */
public class TC11VerifySubscriptionInCartPageTest
        extends BaseTest {

    @Test(invocationCount = 1)
    public void testSubscriptionInCartPage() {
        final String expectedTitle = "Automation Exercise";

        getDriver().manage().window().maximize();
        getDriver().get(BASE_URL);
        Assert.assertEquals(getDriver().getTitle(), expectedTitle);

        getDriver().findElement(By.xpath("//a[contains(text(), 'Cart')]")).click();

        Assert.assertEquals(getDriver().getCurrentUrl(), BASE_URL + "/view_cart");
        Helper.scrollToFooter(getDriver());
        Helper.delay(1000);
        WebElement subscription = getDriver().findElement(By.xpath("//h2[contains(text(), 'Subscription')]"));
        Helper.verify(subscription, "SUBSCRIPTION");

        getDriver().findElement(By.id("susbscribe_email")).sendKeys("qwerty@gmail.com");
        getDriver().findElement(By.id("subscribe")).click();

        WebElement successMessage = getDriver().findElement(By.id("success-subscribe"));
        Helper.verify(successMessage, "You have been successfully subscribed!");
    }
}
