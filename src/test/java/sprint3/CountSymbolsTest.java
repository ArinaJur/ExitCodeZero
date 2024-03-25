package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountSymbolsTest {

    /*
    - подготовить expected результат с помощью алгоритма другого человека
    - зайти на сайт https://involta.ru/tools/length-chars/
    - ввести текст “Это мой Текст из русских слов, слова dot и 1 цифры.”
    - нажать кнопку Посчитать
    - считать количество остальных символов из таблицы результатов
    - подтвердить, что в тексте содержится 2  символа, удовлетворяющих условию

     */

    private final String URL = "https://involta.ru/tools/length-chars/";
    private final String TEST_TEXT = "Это мой Текст из русских слов, слова dot и 1 цифры.";

    @Test
    public void testCountSymbols() {

        int expectedResult = new CountSymbols().countSymbols(TEST_TEXT);

        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(By.id("input")).sendKeys(TEST_TEXT);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String text =
                driver.findElement(By.xpath("//div/span[text()='Остальных символов']/following-sibling::span")).getText();

        int actualResult = Integer.parseInt(text.trim());

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
