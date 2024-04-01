/** Task 21
 * Написать метод, который принимает на вход текст  и возвращает количество цифр в тексте
 * Для проверки результат подготовить expected результат с помощью алгоритма другого человека
 * зайти на сайт https://involta.ru/tools/length-chars/
 * ввести текст “Это мой Текст из 3 слов и 11 букв”
 * нажать кнопку Посчитать
 * считать количество цифр из таблицы результатов
 * подтвердить, что в тексте содержится 3 цифры
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sprint3.CountSymbols;
import sprint3.Task21CountNumbersInText;

public class ConflictsSolvingTest {

    private static final String URL = "https://involta.ru/tools/length-chars/";
    private static final String INPUT_TEXT = "Это мой Текст из 3 слов и 11 букв";
    private final String TEST_TEXT = "Это мой Текст из русских слов, слова dot и 1 цифры.";

    @Test
    public void testCountNumbersInText() throws InterruptedException {
        int numbersInText = new Task21CountNumbersInText().countNumbersInText(INPUT_TEXT);


        String jjj = "";
        int aaa = 0;


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        Thread.sleep(1000);

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='input']"));
        textarea.sendKeys(INPUT_TEXT);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String text = driver.findElement(By.xpath("//div/span[text()='Всего цифр']/following-sibling::span")).getText();
        int actualResult = Integer.parseInt(text);

        Assert.assertEquals(actualResult, numbersInText);

        driver.quit();
    }
}
