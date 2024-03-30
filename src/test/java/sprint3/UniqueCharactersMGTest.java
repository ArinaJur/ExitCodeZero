package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class UniqueCharactersMGTest {
    private static final String URL = "https://ciox.ru/count-the-number-of-unique-characters";
    private static final String TEST_SENTENCE = "куковали кукушки";

    public void testUniqueCharsCount_Ciox() {
        final String expectedResult = new UniqueCharactersMG().uniqueCharsCount(TEST_SENTENCE);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.get(URL);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='text_line']"));
        textarea.sendKeys(TEST_SENTENCE);

        WebElement button = driver.findElement(By.xpath("//span[@class='button_c inline_c']"));
        button.click();

        WebElement output = driver.findElement(By.xpath("//input[@class='input_c']"));

        String actualResult = output.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}