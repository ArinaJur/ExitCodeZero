package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseTest;

import static automationexercise.Helper.BASE_URL;

/**
 * Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
 * 1. Launch browser
 * 2. Navigate to url '<a href="http://automationexercise.com"></a>'
 * 3. Verify that home page is visible successfully
 * 4. Scroll down page to bottom
 * 5. Verify 'SUBSCRIPTION' is visible
 * 6. Click on arrow at bottom right side to move upward
 * 7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
 */
public class TC25ScrollDownAndUpTest extends BaseTest {

    @Test
    void testVerifyScrollUpUsingArrowButtonAndScrollDown(){
        getDriver().get(BASE_URL);
        Helper.scrollToFooter(getDriver());
        Helper.delay(1000);
        WebElement subscription = getDriver().findElement(By.xpath("//h2[contains(text(), 'Subscription')]"));
        Helper.verify(subscription, "SUBSCRIPTION");
        getDriver().findElement(By.id("scrollUp")).click();
        Helper.delay(1000);
        String expectedText = "Full-Fledged practice website for Automation Engineers";
        By xpath = By.xpath("//h2[contains(text(), '" + expectedText + "')]");
        WebElement textElement = getDriver().findElement(xpath);
        Helper.verify(textElement, expectedText);
    }
}
