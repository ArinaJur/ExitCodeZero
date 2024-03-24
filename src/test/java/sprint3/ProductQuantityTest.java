package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductQuantityTest {
    @Test
    public void testItemsQuantity() throws InterruptedException {
        int expectedResult = 6;
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        WebElement name = driver.findElement(By.xpath("//input[@id='user-name']"));
        name.sendKeys("standard_user");
        WebElement passcode = driver.findElement(By.xpath("//input[@id='password']"));
        passcode.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> listItems = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualResult = listItems.size();
        //Thread.sleep(3000);
        Assert.assertEquals(actualResult, expectedResult);

        //driver.quit();
    }
}
