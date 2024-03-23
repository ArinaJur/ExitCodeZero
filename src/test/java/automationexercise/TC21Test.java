package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21Test {

    private static final String BASE_URL = "http://automationexercise.com";

    //functional, UI, navigation
    @Test
    public void testAddReviewOnProductHP() throws InterruptedException {
        final String expectedResult = "ALL PRODUCTS";
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        if (driver.findElement(By.xpath("//iframe[contains(@style, 'overflow: visible')]")).isDisplayed()) {
            System.out.println("Advertisement");
            Thread.sleep(70000);
            //you should close the Advertisement manually
        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        System.out.println("click Products");

        if (driver.findElement(By.xpath("//iframe[contains(@style, 'overflow: visible')]")).isDisplayed()) {
            System.out.println("Advertisement");
            Thread.sleep(70000);
            //you should close the Advertisement manually
        }

        String text = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();

        Assert.assertEquals(text, expectedResult);

        driver.quit();
    }

}

