package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 10. Написать метод, который принимает на вход текст, н-р, “Упади семь раз и восемь раз поднимись.”
 * Метод должен менять слова-цифры на арабские цифры, те “Упади 7 раз и 8 раз поднимись.”
 *
 * ДЛя проверки методa написать тест:
 * - зайти на сайт https://www.google.com/
 * - Набрать в строке поиска “Упади семь раз и восемь раз поднимись.”
 * - в результатах поиска зайти по первой ссылке
 * - считать текст цитаты
 * подтвердить с помощью алгоритма первого человека, что если в цитате заменить слова-цифры на арабские цифры,
 * то получится фраза “Упади 7 раз и 8 раз поднимись.”
 */

public class Task10ReplaceWordsWithNumbersTest {

    private static final String URL = "https://www.google.com/";
    final String inputText = "Упади семь раз и восемь раз поднимись.";
    final String resultText = "Упади 7 раз и 8 раз поднимись";

    @Test
    public void testReplaceWordsWithNumbers() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        WebElement searchArea = driver.findElement(By.xpath("//textarea[@title='Search']"));
        searchArea.click();
        searchArea.sendKeys(inputText);
        searchArea.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='search']//h3"));

        Thread.sleep(2000);

        if (!elements.isEmpty()) {
            WebElement firstElement = elements.get(0);
            Thread.sleep(1000);
            firstElement.click();
        } else {
            Assert.fail();
            driver.quit();
        }

        Thread.sleep(1000);

        String actualText = driver.findElement(By.xpath("//h1")).getText();

        String text = inputText.replace(".", "");
        int startIndex = actualText.indexOf(text);

        String actualResult = "";
        if (startIndex != -1) {
            actualResult = actualText.substring(startIndex, startIndex + text.length());
            actualResult = new Task10ReplaceWordsWithNumbers().replaceWordsWithNumbers(actualResult);
        } else {
            actualResult = actualText;
        }

        Assert.assertEquals(actualResult, resultText);

        driver.quit();
    }
}
