// https://docs.google.com/document/d/10Wrrsy5oMVxzQe2KMjTXcBAdifxfIRcNRRF1G8TAPZ0/edit
//
// 1. Написать метод, который принимает на вход текст, н-р, “достопримечательность”, и возвращает количество букв “о” в этом слове.
//
//Для проверки работы алгоритма второму человеку написать следующий селениум тест:
//	- зайти на сайт https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C
//
// считать заголовок статьи
// с помощью алгоритма первого человека преобразовать actualResult
// подтвердить, что в заголовке содержится 3 буквы “О”

package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1LetterCounterTest {

    @Test
    public void wordHasThreeLetterOHP() {
        WebDriver driver = new ChromeDriver();

        int expectedResult = 3;

        driver.get("https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C");
        String title = driver.findElement(By.xpath("//span[@class='mw-page-title-main']")).getText();

        int actualResult = Task1LetterCounter.countLetter(title, 'о');

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    @Test
    public void wordHasThreeLetterO() {
        WebDriver driver = new ChromeDriver();

        int expectedResult = 3;

        driver.get("https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C");
        String title = driver.findElement(By.xpath("//span[@class='mw-page-title-main']")).getText();

        int actualResult = Task1LetterCounter.countLetter(title, 'О');

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void wordHasNumber() {
        WebDriver driver = new ChromeDriver();

        int expectedResult = 0;

        driver.get("https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C");
        String title = driver.findElement(By.xpath("//span[@class='mw-page-title-main']")).getText();

        int actualResult = Task1LetterCounter.countLetter(title, '2');

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void wordHasThreeLetterM() {
        WebDriver driver = new ChromeDriver();

        int expectedResult = 0;

        driver.get("https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C");
        String title = driver.findElement(By.xpath("//span[@class='mw-page-title-main']")).getText();

        int actualResult = Task1LetterCounter.countLetter(title, 'm');

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

}
