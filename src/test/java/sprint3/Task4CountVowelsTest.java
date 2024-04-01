package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task4CountVowelsTest {

    private static final String URL = "https://ru.wikipedia.org";
    private static final String INPUT_TEXT = "достопримечательность";

    @Test
    public void testCountTheNumberOfVowels() throws InterruptedException {

        //С помощью алгоритма первого человека подготовить expectedResult
        final String expectedResult = "7";

        WebDriver driver = new ChromeDriver();

        //	- зайти на сайт https://ru.wikipedia.org/
        driver.get(URL);

        Thread.sleep(3000);

        //в поиске набрать слово “достопримечательность”
        //input[@id='searchInput']
        WebElement textarea = driver.findElement(By.xpath("//input[@id='searchInput']"));

        textarea.sendKeys(INPUT_TEXT);

        driver.findElement(By.xpath("//input[@id='searchButton']")).click();

        Thread.sleep(3000);

        String actualResult = Task4CountVowels.theNumberOfVowels(driver.findElement(
                By.xpath("//h1[@id='firstHeading']")).getText());


        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    static void countVowelsHappyPath() {

        String INPUT_TEXT = "достопримечательность";

        String expectedResult = "7";
        String actualResult = Task4CountVowels.theNumberOfVowels(INPUT_TEXT);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
