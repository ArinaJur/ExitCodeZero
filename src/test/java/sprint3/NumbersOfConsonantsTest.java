package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//Для проверки работы алгоритма второму человеку написать следующий селениум тест:
//    - зайти на сайт https://ru.wikipedia.org/
//в поиске набрать слово “достопримечательность”
//в результатах поиска найти любое слово “достопримечательность”, считать текст
//с помощью алгоритма первого человека преобразовать actualResult
//подтвердить, что заголовок статьи содержит 14 согласных букв.


public class NumbersOfConsonantsTest {

    @Test
    public void testNumbersOfConsonants() throws InterruptedException {
        int expectedResult = 6;
        WebDriver driver = new ChromeDriver();
        driver.get("https://wikipedia.org/");
        WebElement inputField = driver.findElement(By.xpath("//input[@name='search']"));
        //Thread.sleep(2000);
        String testWord = "Attraction";
        inputField.sendKeys(testWord);
        //inputField.sendKeys(Keys.ENTER);
        // Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://en.m.wikipedia.org/wiki/Attraction");
        //Thread.sleep(2000);
        WebElement word = driver.findElement(By.xpath("//span[@class='mw-page-title-main']"));
        String modWord = word.getText().trim();// method to retrieve the visible  text
        int actualResult = new GetNumbersOfConsonants().getNumbersOfConsonants(modWord);
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


}
