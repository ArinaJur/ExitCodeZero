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
public class Task16ToAlphabeticSrtTest {
    private WebDriver driver;
    private static final String URL = "https://www.textfixer.com/tools/remove-numbers-from-text.php";
    private static final String TEST_SENTENCE = "неCодержит5цифр";
    private static final String TEST_SENTENCE1 = "45645643456";
    private static final String TEST_SENTENCE2 = " ";
    private static final String TEST_SENTENCE3 = "";
    private static final String TEST_SENTENCE4 = " sdf23d@#$f5 ";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-dev-shm-usage");
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRemoveNumbersFromText() {
        Task16ToAlphabeticSrt task16 = new Task16ToAlphabeticSrt();
        final String actualResult = task16.toStringFromLetterNumberToLetter(TEST_SENTENCE);

        openPage(URL);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='newText']"));
        textarea.sendKeys(TEST_SENTENCE);

        WebElement removeNumbersBtn = driver.findElement(By.name("remove-numbers"));
        removeNumbersBtn.click();

        String expectedResult = textarea.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testRemoveNumbersFromTextContainsOnlyNumbers() {
        Task16ToAlphabeticSrt task16 = new Task16ToAlphabeticSrt();
        final String actualResult = task16.toStringFromLetterNumberToLetter(TEST_SENTENCE1);

        openPage(URL);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='newText']"));
        textarea.sendKeys(TEST_SENTENCE1);

        WebElement removeNumbersBtn = driver.findElement(By.name("remove-numbers"));
        removeNumbersBtn.click();

        String expectedResult = textarea.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testTextContainsOnlySpace() {
        Task16ToAlphabeticSrt task16 = new Task16ToAlphabeticSrt();
        final String actualResult = task16.toStringFromLetterNumberToLetter(TEST_SENTENCE2);

        openPage(URL);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='newText']"));
        textarea.sendKeys(TEST_SENTENCE2);

        WebElement removeNumbersBtn = driver.findElement(By.name("remove-numbers"));
        removeNumbersBtn.click();

        String expectedResult = textarea.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testEmptyText() {
        Task16ToAlphabeticSrt task16 = new Task16ToAlphabeticSrt();
        final String actualResult = task16.toStringFromLetterNumberToLetter(TEST_SENTENCE3);

        openPage(URL);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='newText']"));
        textarea.sendKeys(TEST_SENTENCE3);

        WebElement removeNumbersBtn = driver.findElement(By.name("remove-numbers"));
        removeNumbersBtn.click();

        String expectedResult = textarea.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testTextContainsNumbersAndSymbols() {
        Task16ToAlphabeticSrt task16 = new Task16ToAlphabeticSrt();
        final String actualResult = task16.toStringFromLetterNumberToLetter(TEST_SENTENCE4);

        openPage(URL);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='newText']"));
        textarea.sendKeys(TEST_SENTENCE4);

        WebElement removeNumbersBtn = driver.findElement(By.name("remove-numbers"));
        removeNumbersBtn.click();

        String expectedResult = textarea.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);
    }
    private void openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
}
