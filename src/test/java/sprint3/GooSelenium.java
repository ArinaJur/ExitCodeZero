package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GooSelenium {

    @Test
    public void testGoogle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement text = driver.findElement(By.id("APjFqb"));
        text.sendKeys("Selenium");

        Thread.sleep(2000);

        WebElement button = driver.findElement(By.className("gNO89b"));
        button.click();

        WebElement link = driver.findElement(By.xpath("//a[@href = 'https://www.selenium.dev/']/h3"));
        String resultText = link.getText();

        Assert.assertEquals(resultText, "Selenium");
        Thread.sleep(3000);

        driver.quit();
    }
}
