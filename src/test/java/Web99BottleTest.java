import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Web99BottleTest {
    @Test
    public void test99Bottles() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://99-bottles-of-beer.net");


    }

}
