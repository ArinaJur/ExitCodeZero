import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CapitalizedCaseMGTest {
    private static final String URL = "https://convertcase.net/";
    private static final String TEST_SENTENCE = "Я не провалил тест. Я просто нашел сто способов написать его неправильно.";

    public void testCapitalizedCaseMG_ConvertCase() {
        final String expectedResult = CapitalizedCaseMG.capitalize(TEST_SENTENCE);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.get(URL);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='content']"));
        textarea.sendKeys(TEST_SENTENCE);

        WebElement capitalizedButton = driver.findElement(By.xpath("//button[@id='capitalized']"));
        capitalizedButton.click();

        String actualResult = textarea.getAttribute("value");

    }

}
