import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ToSentenceCaseTest {

    ////Для проверки работы алгоритма написать следующий Селениум тест
    //    //
    //    //- С помощью алгоритма первого человека подготовить expectedResult = “Мама мыла раму.”
    //    //- Пройти на сайт https://capitalizemytitle.com/
    //    //- Ввести в текстовое поле предложение “мама мыла Раму.”
    //    //- Нажать на кнопку Sentence case
    //    //- Считать результат преобразования
    //    //- Подтвердить, что результат работы программы соответствует expectedResult

    private static final String URL = "https://capitalizemytitle.com/";
    private static final String TEST_SENTENCE = "мама мыла Раму.";

    @Test
    public void testCapitalizeMyTitle_toSentenceCase() throws InterruptedException {
        final String expectedResult = new ToSentenceCase().toSentenceCase(TEST_SENTENCE);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        //Act
        driver.get(URL);
        //xPath
        //       //textarea[@id='main_input']

        //css
        //        textarea#main_input

        //3 ways to find element by addresses
        driver.findElement(By.name("main_input"));
        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='main_input']"));
        driver.findElement(By.cssSelector("textarea#main_input"));

        textarea.sendKeys(TEST_SENTENCE);

        Thread.sleep(3000);

//        WebElement sentenceCaseButton = driver.findElement(By.id("sentencecase"));
//        sentenceCaseButton.click();

        driver.findElement(By.id("sentencecase")).click();

//        Thread.sleep(3000);

        String actualResult = textarea.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
//        driver.close(); //- не закрывает connection
    }

    @Test
    public void testToSentenceCaseHappyPath() {
        final String expectedResult = "Мама мыла раму.";

        final String actualResult = new ToSentenceCase().toSentenceCase(TEST_SENTENCE);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Ignore
    @Test
    public void testToSentenceCaseEmptyString() {
        final String sentence = "";
        final String expectedResult = "";

        final String actualResult = new ToSentenceCase().toSentenceCase(sentence);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
