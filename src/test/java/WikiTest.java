import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiTest {

    public static final String URL = "https://www.wikipedia.org/";

    @Test
    public void testSearchWord() {

        String expectedResult = "Java";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Java");
        driver.findElement(By.xpath("//i[text()='Search']")).click();

        String value = driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();

        Assert.assertEquals(value, expectedResult);

        driver.quit();
    }
}
