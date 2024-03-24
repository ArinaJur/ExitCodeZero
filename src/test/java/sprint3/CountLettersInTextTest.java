package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Написать метод, который принимает на вход текст и букву, которую нужно найти в тексте,   и возвращает количество заданных букв в тексте
Для проверки результата
подготовить expected результат с помощью алгоритма другого человека
зайти на сайт https://intexty.com/podschet-znakov-i-bukv/
задать для поиска символ “.”
ввести текст “Если мы будем стремиться с самого начала увидеть самый конец, мы никогда не сдвинемся с места. Важно сделать первый шаг, и важно быть уверенными в том, что он правильный.”
нажать кнопку Найти
считать результат
подтвердить, что в тексте содержится 2 точки
*/
public class CountLettersInTextTest {
    @Test
    public void testCountLettersInText() {

        final int expectedResult = CountLettersInText.countLettersInText("Если мы будем стремиться с самого начала увидеть самый конец, мы никогда не сдвинемся с места. Важно сделать первый шаг, и важно быть уверенными в том, что он правильный.", '.');

        WebDriver driver = new ChromeDriver();

        driver.get("https://intexty.com/podschet-znakov-i-bukv/");
        driver.findElement(By.id("analysis-text-input")).sendKeys("Если мы будем стремиться с самого начала увидеть самый конец, мы никогда не сдвинемся с места. Важно сделать первый шаг, и важно быть уверенными в том, что он правильный.");
        driver.findElement(By.id("symbol-pattern")).sendKeys(".");
        driver.findElement(By.id("calc-symbol-stats")).click();

//        String actualResult = driver.findElement(By.cssSelector("tbody tr td:nth-child(2)")).getText();
        int actualResult = Integer.parseInt(driver.findElement(By.xpath("//tbody/tr/td[2]")).getText());


        System.out.println(actualResult);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
