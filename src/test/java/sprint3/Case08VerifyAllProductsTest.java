package sprint3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Case08VerifyAllProductsTest {
    //Запустить браузер
    //2. Перейдите по URL-адресу «http://automationexercision.com».
    //3. Убедитесь, что домашняя страница успешно видна.
    //4. Нажмите кнопку «Продукты».
    //5. Убедитесь, что пользователь успешно перешел на страницу ВСЕ ПРОДУКТЫ.
    //6. Введите название продукта в поле поиска и нажмите кнопку поиска.
    //7. Убедитесь, что надпись «ПОИСК ПРОДУКТОВ» отображается.
    //8. Убедитесь, что все продукты, связанные с поиском, видны.

    @Test
    public void TestCase08VerifyAllProducts() {

        final String URL = "https://automationexercise.com/";
        final String expectedTitleHome = "Automation Exercise";
        final String expectedTitleProducts = "Automation Exercise - All Products";
        final String expectedTitleDetails = "Automation Exercise - Product Details";

        int expectedResultTops = 13;

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(URL);

        Assert.assertEquals(driver.getTitle(), expectedTitleHome);

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitleProducts);

        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Tops");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        List<WebElement> tops = driver.findElements(By.xpath("//div[@class='product-overlay']"));
        int actualResultTops = tops.size();
        Assert.assertEquals(actualResultTops, expectedResultTops);

        driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
        //Assert.assertEquals(driver.getTitle(),expectedTitleDetails);


    }


}
