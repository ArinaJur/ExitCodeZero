package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LetterPositionFinderTest {

     private final String URL = "https://ru.wikipedia.org/wiki/" +
             "%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C";



    @Test
    public void testPositionOfLetterHappyPath(){
        final char letter = 'о';
        final int[] expectedResult = {1, 4, 17};

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        String titleOfArticle = driver.findElement(By.cssSelector(".mw-page-title-main")).getText();

        int[] actualResult = new LetterPositionFinder().findLetterPositions(titleOfArticle, letter);

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    @Test
    public void testTextHasNoMatchLetter(){
        final char letter = '9';
        final int[] expectedResult = {};

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        String titleOfArticle = driver.findElement(By.cssSelector(".mw-page-title-main")).getText();

        int[] actualResult = new LetterPositionFinder().findLetterPositions(titleOfArticle, letter);

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
}
