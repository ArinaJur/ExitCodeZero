package sprint3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBankLogInTest {
    @Test
    public void testLogIn() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/");

        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("admin4");
        WebElement passcode = driver.findElement(By.xpath("//input[@name='password']"));
        passcode.sendKeys("admin");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String expectedResult = "ParaBank | Accounts Overview";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult);

        System.out.println(actualResult);
    }
}
