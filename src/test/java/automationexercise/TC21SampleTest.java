package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC21SampleTest {

    private static final String BASE_URL = "http://automationexercise.com";

    @Test
    public void testAddReviewOnProductHappyPath() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        Thread.sleep(3000);

        if (driver.findElement(By.xpath("//iframe[contains(@style, 'overflow: visible')]")).isDisplayed()) {
            System.out.println("Advertisement");
            driver.findElement(By.xpath("//a[@href='/products']")).click();
            // Assert.fail("Unable to run test");
            //driver.quit();

            Thread.sleep(3000);
            System.out.println("Products isDisplayed");

            driver.findElement(By.xpath("//a[@href='/products']")).click();
            System.out.println("click products");

            Thread.sleep(3000);
            if (driver.findElement(By.xpath("//iframe[contains(@style, 'overflow: visible')]")).isDisplayed()) {
                System.out.println("Advertisement");
                driver.findElement(By.xpath("//a[@href='/products']")).click();

            }
        }

        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println(text);
        driver.quit();
    }
}
//protected void scrollByVisibleElement(WebElement element) {
//    JavascriptExecutor js = (JavascriptExecutor) getDriver();
//    js.executeScript("arguments[0].scrollIntoView();", element);
//}