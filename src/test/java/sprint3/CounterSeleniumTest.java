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
        driver.get(url);
        driver.manage()
              .window()
              .maximize();

        String expected = String.valueOf(30);
        int actualCount = Counter.countCyrillicCharacters(data);

        sendText(data, INPUT_XPATH);
        clickButton(BUTTON_SUBMIT);
        String actualValue = getText(CSS_SELECTOR);

        Assert.assertEquals(expected, actualValue);
        Assert.assertEquals(String.valueOf(actualCount), actualValue);
        Assert.assertEquals(expected, String.valueOf(actualCount));
    }

    private String getText(String locator) {
        By selector = By.cssSelector(locator);
        WebElement spanElement = driver.findElement(selector);
        return spanElement.getText();
    }

    private void clickButton(String locator) {
        By submit = By.xpath(locator);
        WebElement button = driver.findElement(submit);
        button.click();
    }

    private void sendText(String data, String locator) {
        By input = By.xpath(locator);
        WebElement textarea = driver.findElement(input);
        textarea.sendKeys(data);
    }
}
