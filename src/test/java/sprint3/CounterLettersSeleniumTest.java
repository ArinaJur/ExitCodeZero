package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static sprint3.CounterLetters.countUniqueLetters;

public class CounterLettersSeleniumTest {

    private WebDriver driver;
    public static final String word = "абракадабра";
    public static final String url = "https://yandex.com/";

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void testCountUniqueLetters() throws InterruptedException {
        driver.get(url);
        driver.manage()
                .window()
                .maximize();

        int expectedResult = 5;

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@class='search3__input mini-suggest__input']"))
                .sendKeys(word);

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Search']"))
                .click();
        Thread.sleep(1000);

        String wordSearching = driver.findElement(By.xpath("//b[text()='абракадабра']")).getText();
        Thread.sleep(1000);

        int actualResult = countUniqueLetters(wordSearching);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
