package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlphabeticStrTest {
    @Test
    public void testAlphabeticStr() {
        WebDriver driver = new ChromeDriver();
        String testData = "1, 2, 3, 4, 5, я иду тебя искать";
        String expectedResult = AlphabeticSrt.alphabeticString(testData);
        driver.get("https://www.browserling.com/tools/extract-numbers");
        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='extract-numbers-text']"));
        textarea.sendKeys((testData));

        driver.findElement(By.xpath("//input[@id='extract-numbers-submit']")).click();

        String actualResult = textarea.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
}
