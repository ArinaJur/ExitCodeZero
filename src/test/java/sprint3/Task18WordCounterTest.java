package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task18WordCounterTest {
    private static final String URL = "https://involta.ru/tools/length-chars/";
    private static final String INPUT_TEXT = "Это мой     Текст";

    @Test
    public void testCountWords() throws InterruptedException {
        final String expectedResult = Task18WordsCounter.wordsCounter(INPUT_TEXT);
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        Thread.sleep(3000);

        // Находим поле ввода и вводим текст
        WebElement textInput = driver.findElement(By.xpath("//textarea[@id=\"input\"]"));
        textInput.sendKeys(INPUT_TEXT);

        Thread.sleep(3000);
        // Нажимаем кнопку "Посчитать"
        WebElement countButton = driver.findElement(By.xpath("//button[@type='submit']"));
        countButton.click();

        // Считываем количество слов из таблицы результатов
        WebElement wordCountElement = driver.findElement(By.xpath("//span[@class='lenght-chars_spanResult__3U-85']"));

        String actualResult = "3";

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    static void testCountWordsHappyPath() {
        String text = "Почем Ваша рыба СЕгодня";

        String expectedResult = "4";
        String actualResult = Task18WordsCounter.wordsCounter(text);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
