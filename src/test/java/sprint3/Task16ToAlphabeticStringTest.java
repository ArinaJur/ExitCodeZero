// https://docs.google.com/document/d/10Wrrsy5oMVxzQe2KMjTXcBAdifxfIRcNRRF1G8TAPZ0/edit
//
// 16. Написать метод, который принимает на вход строку, состоящую из букв латинского алфавита и цифр, и возвращает
// строку, состоящую только из букв.
//  Для проверки работы алгоритма второму человеку написать следующий селениум тест:
//  с помощью алгоритма первого человека подготовить expectedResult
//  зайти на сайт https://www.textfixer.com/tools/remove-numbers-from-text.php
//	-  в строке ввода текста набрать “неСодержит5цифр”
//  - нажать на кнопку Remove numbers
//  - считать полученный результат
//  - подтвердить, что преобразованное предложение не содержит цифр

package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task16ToAlphabeticStringTest {



    @Test
    public void  toText () {
        WebDriver driver = new ChromeDriver();

//        String data = "неСодержит5цифр";
        String data = "неСодержит 5цифр ";

        String expectedResult = Task16ToAlphabeticSrt.toStringFromLetterNumberToLetter(data);

                driver.get("https://www.textfixer.com/tools/remove-numbers-from-text.php");
        WebElement text = driver.findElement(By.xpath("//textarea[@id='newText']"));
        text.sendKeys("неСодержит5цифр");
        driver.findElement(By.xpath("//input[@value='Remove Numbers']")).click();

        String actualResult = text.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }



}
