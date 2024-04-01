package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UniqueLettersTest {

    @Test
    public void testUniqueLetters() {
        WebDriver driver = new ChromeDriver();
//        int expectedResult = UniqueLetters.uniqueLetters("Достопримечательность");
        int expectedResult = 9;

        driver.get("https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C");
        WebElement heading = driver.findElement(By.xpath("//h1//span"));
        int actualResult = UniqueLetters.uniqueLetters(heading.getText());

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
}
