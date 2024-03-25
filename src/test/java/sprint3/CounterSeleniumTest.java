package sprint3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static sprint3.CounterCyrillicCharacters.countCyrillicCharacters;
import static sprint3.CounterLocators.BUTTON_SUBMIT;
import static sprint3.CounterLocators.CSS_SELECTOR;
import static sprint3.CounterLocators.INPUT_XPATH;
import static sprint3.provider.CounterDataProvider.data;

public class CounterSeleniumTest {

    private WebDriver driver;
    private static final String url = "https://involta.ru/tools/length-chars/";

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
    public void testCount() {
        String expected = String.valueOf(30);
        int actualCount = countCyrillicCharacters(data);

        openPage(url);
        sendText(data, INPUT_XPATH);
        clickButton(BUTTON_SUBMIT);
        String actualValue = getText(CSS_SELECTOR);

        Assert.assertEquals(expected, actualValue);
        Assert.assertEquals(String.valueOf(actualCount), actualValue);
        Assert.assertEquals(expected, String.valueOf(actualCount));
    }

    private void openPage(String url) {
        driver.get(url);
        driver.manage()
              .window()
              .maximize();
    }

    private String getText(String locator) {
        return driver.findElement(By.cssSelector(locator))
                     .getText();
    }

    private void clickButton(String locator) {
        driver.findElement(By.xpath(locator))
              .click();
    }

    private void sendText(String data, String locator) {
        driver.findElement(By.xpath(locator))
              .sendKeys(data);
    }
}
