package sprint3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class RemoveDigitsTest {
    private WebDriver driver;
    private static final String URL = "https://www.textfixer.com/tools/remove-numbers-from-text.php";
    private static final String TEST_SENTENCE = "неCодержит5цифр";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRemoveNumbersFromText() {
        Task16ToAlphabeticSrt task16 = new Task16ToAlphabeticSrt();
        final String expectedResult = task16.toStringFromLetterNumberToLetter(TEST_SENTENCE);

        openPage(URL);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='newText']"));
        textarea.sendKeys(TEST_SENTENCE);

        WebElement removeNumbersBtn = driver.findElement(By.name("remove-numbers"));
        removeNumbersBtn.click();

        String actualResult = textarea.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);
    }
    private void openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
}
