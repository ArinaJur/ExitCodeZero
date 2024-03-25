package sprint3.provider;

//Написать метод, который принимает на вход текст, н-р, “достопримечательность”,
// и возвращает количество гласных букв
//
//Для проверки работы алгоритма второму человеку написать следующий селениум тест:
//
//С помощью алгоритма первого человека подготовить expectedResult
//	- зайти на сайт https://ru.wikipedia.org/
//в поиске набрать слово “достопримечательность”
//в результатах поиска найти любое слово “достопримечательность”, считать текст
//подтвердить, что заголовок статьи содержит 7 гласных букв.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sprint3.CountVowels;

public class CountVowelsTest {

    private static final String URL = "https://ru.wikipedia.org";
    private static final String INPUT_TEXT = "достопримечательность";

    @Test
    public void testCountTheNumberOfVowels() throws InterruptedException {

        //С помощью алгоритма первого человека подготовить expectedResult
        final String expectedResult = CountVowels.theNumberOfVowels(INPUT_TEXT);

        WebDriver driver = new ChromeDriver();

        //	- зайти на сайт https://ru.wikipedia.org/
        driver.get(URL);

        Thread.sleep(3000);

        //в поиске набрать слово “достопримечательность”
        WebElement textarea = driver.findElement(By.xpath("//input[@id='searchInput']"));

        textarea.sendKeys(INPUT_TEXT);

        driver.findElement(By.xpath("//input[@id='searchButton']")).click();

        Thread.sleep(3000);

        String actualResult = CountVowels.theNumberOfVowels(String.valueOf(driver.findElement(
                By.xpath("//h1[@id='firstHeading']"))));

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}