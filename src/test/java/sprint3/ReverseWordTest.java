package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseWordTest {
    final  String word = "stressed";

    @Test
    public void testHappyReversedWord(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://onlinestringtools.com/reverse-string");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("textarea.data[data-autosave]")).sendKeys(word);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String expectedResult = (String) js.executeScript("return arguments[0].value", driver
                .findElement(By.cssSelector(".data[readonly]")));

        String actualResult = ReverseWord.getReversedWord(word);


        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
