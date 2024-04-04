package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// //Написать метод, который принимает на вход слово, например, “абракадабра”.
//    // Метод меняет максимально встречающуюся букву в слове на цифру 0 (должно получиться “0бр0к0д0бр0”).
//    // Если в слове одинаковое количество разных букв, то необходимо заменить на 0 ту букву,
//    // которая встречается в слове первой (“куку” -> “0у0у”)
//    //
//    //9.ДЛя проверки написать тест:
//    //- зайти на сайт https://ru.wikipedia.org/wiki/%D0%90%D0%B1%D1%80%D0%B0%D0%BA%D0%B0%D0%B4%D0%B0%D0%B1%D1%80%D0%B0_(%D0%B7%D0%BD%D0%B0%D1%87%D0%B5%D0%BD%D0%B8%D1%8F)
//    //
//    //- считать слово “Абракадабра” из заголовка статьи
//    //- с помощью алгоритма другого человека преобразовать actualResult
//    //подтвердить, что при замене самой часто встречающейся буквы из слова “Абракадабра” получается слово “0бр0к0д0бр0”
public class Test9LetterTo0Test {

    private static final String URL = "https://ru.wikipedia.org/wiki/%D0%90%D0%B1%D1%80%D0%B0%D0%BA%D0%B0%D0%B4%D0%B0%D0%B1%D1%80%D0%B0_(%D0%B7%D0%BD%D0%B0%D1%87%D0%B5%D0%BD%D0%B8%D1%8F)";


    @Test
    public void testLetterToO() {
        String expectedResult = "0бр0к0д0бр0";
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        String text = driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();
        text = text.split(" ")[0];

        String actualResult = new LetterTo0().letterTo0(text);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
