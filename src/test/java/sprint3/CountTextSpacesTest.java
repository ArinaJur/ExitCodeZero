package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountTextSpacesTest {
    //Для проверки результата
    //подготовить expected результат с помощью алгоритма другого человека
    //зайти на сайт https://involta.ru/tools/length-chars/
    //ввести текст “Это мой     Текст”
    //нажать кнопку Посчитать
    //считать количество пробелов из таблицы результатов
    //подтвердить, что в тексте содержится 6 пробелов

    private static final String TEST_TEXT = "Это мой     Текст";
    private static final String URL = "https://involta.ru/tools/length-chars/";

    @Test
    public void testCountTextSpaces() {

        int expectedResult = new Task20CountTextSpaces().toCountSpaces(TEST_TEXT);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);
        driver.findElement(By.id("input")).sendKeys(TEST_TEXT);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String text = driver.findElement(By.xpath("//div/span[text()='Пробелов']/following-sibling::span")).getText();

        int actualResult = Integer.parseInt(text.trim());

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
