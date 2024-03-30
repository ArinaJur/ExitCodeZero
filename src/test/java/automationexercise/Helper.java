package automationexercise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Helper {
    public static final String BASE_URL = "https://automationexercise.com";

    public static void skipAd(
            WebDriver driver) {
        delay(1000);
        new Actions(driver).moveByOffset(50, 50).click().perform();
        delay(2000);
    }

    public static void verify(
            WebElement element, String expected) {
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), expected);
    }

    public static void scrollOnce(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollBy(0, 500);");
    }

    public static void scrollToFooter(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToIntoView(
            WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
