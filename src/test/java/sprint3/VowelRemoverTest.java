package sprint3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VowelRemoverTest {


        // public final static String URL = "https://www.yahoo.com/";
        public final static  String URL = "https://www.google.com/";
        private static final String TEST_SENTENCE = "абракадабра";

        private static final String TEST_EMPTY = "";

        private static final String TEST_NULL = null;


        protected void scrollByVisibleElement(WebElement element, WebDriver driver) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
        }


        @Test
        public void testVowelRemover() throws InterruptedException {
            final String expectedResult = "бркдбр";

            WebDriver driver = new ChromeDriver();

            driver.get(URL);
            driver.manage().window().maximize();



            driver.findElement(By.name("q")).sendKeys(TEST_SENTENCE);

            driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
            WebElement searchResult = driver.findElement(By.xpath("//div[@data-attrid='title']"));

            String actualResult = searchResult.getText();//считываем результат
            actualResult = new VowelRemover().removeVowels(actualResult);
            Assert.assertEquals(actualResult, expectedResult);
            driver.quit();
        }


    // @Ignore
    @Test
    public void testEmpty() throws InterruptedException {
        final String expectedResult = "";

        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.manage().window().maximize();


        driver.findElement(By.name("q")).sendKeys(TEST_EMPTY);

        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        WebElement searchResult = driver.findElement(By.name("q"));
        String actualResult = searchResult.getText(); //считываем результат
        actualResult = new VowelRemover().removeVowels(actualResult);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }

}
