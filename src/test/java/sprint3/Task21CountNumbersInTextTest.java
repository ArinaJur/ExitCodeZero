/** Task 21
 * Написать метод, который принимает на вход текст  и возвращает количество цифр в тексте
 * Для проверки результат подготовить expected результат с помощью алгоритма другого человека
 * зайти на сайт https://involta.ru/tools/length-chars/
 * ввести текст “Это мой Текст из 3 слов и 11 букв”
 * нажать кнопку Посчитать
 * считать количество цифр из таблицы результатов
 * подтвердить, что в тексте содержится 3 цифры
 */

package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task21CountNumbersInTextTest {

    private static final String URL = "https://involta.ru/tools/length-chars/";
    private static final String INPUT_TEXT = "Это мой Текст из 3 слов и 11 букв";

    @Test
    public void testCountNumbersInText() throws InterruptedException {
        int expectedResult = new Task21CountNumbersInText().countNumbersInText(INPUT_TEXT);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        Thread.sleep(1000);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='input']"));
        textarea.sendKeys(INPUT_TEXT);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String text = driver.findElement(By.xpath("//div/span[text()='Всего цифр']/following-sibling::span")).getText();
        int actualResult = Integer.parseInt(text);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
