package sprint3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class StringModifierTest {
    /*
    - зайти на сайт https://dzen.ru/
- Набрать в строке поиска “Семь раз отмерь, один раз отрежь”
- в результатах поиска зайти по первой ссылке
- считать текст цитаты
- преобразовать  с помощью алгоритма первого человека actualResult
- подтвердить, что если в цитате заменить слова-цифры на арабские цифры, то получится фраза “7 раз отмерь, 1 раз отрежь.”
     */
    @Test
    public void testStringModifier() {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://dzen.ru/");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@aria-label='Поиск Яндекса']"));
        driver.switchTo().frame(iframe);

        WebElement iframeSearch = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@name='text']")));

        iframeSearch.click();
        iframeSearch.sendKeys("Семь раз отмерь, один раз отрежь");
        driver.findElement(By.xpath("//button[@class='arrow__button']")).click();

        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }}

        WebElement firstLink = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("li[data-cid='0']>div>div:first-child")));
        firstLink.click();

        List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
        String newestTabHandle = windowHandlesList.get(windowHandlesList.size() - 1);
        driver.switchTo().window(newestTabHandle);


        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".header>h1")));

        String text = title.getText();

        int startIndex = text.indexOf('"');
        int endIndex = text.lastIndexOf('"');

        String quote = "";

        if (startIndex != -1 && endIndex != -1) {
            quote = text.substring(startIndex + 1, endIndex);
        }

//        String quote = driver.findElement(By.cssSelector("h1[class='article__title']")).getText();
        String newStr = StringModifier.stringToNum(quote);

        boolean containsSubstring = newStr.contains("7 раз отмерь, 1 раз отрежь");

        Assert.assertTrue(containsSubstring);

        driver.quit();
    }
}

