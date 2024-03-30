package automationexercise;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Helper {
    public static final String BASE_URL = "https://automationexercise.com";

    public static void skipAd(Actions actions) {
        try {
            Thread.sleep(1000);
            actions.moveByOffset(50, 50).click().perform();
            Thread.sleep(2000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public static void verify(WebElement element, String expected) {
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), expected);
    }
}
