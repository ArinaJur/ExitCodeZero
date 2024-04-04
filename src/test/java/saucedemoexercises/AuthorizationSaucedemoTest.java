package saucedemoexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class AuthorizationSaucedemoTest extends BaseTest {

    @Test
    public void testAuthorizationSaucedemoStandardUser() {

        final String BASE_URL = "https://www.saucedemo.com/";
        final String userName = "standard_user";
        final String PASSWORD = "secret_sauce";
        final String expectedLogoText = "Swag Labs";
        final String expectedTitle = "Products";
        final String expectedLink = "https://www.saucedemo.com/inventory.html";

        getDriver().get(BASE_URL);
        getDriver().manage().window().maximize();

        WebElement buttonText = getDriver().findElement(By.xpath("//div/input[@type='text']"));
        buttonText.sendKeys(userName);
        WebElement buttonPassword = getDriver().findElement(By.xpath("//div/input[@type='password']"));
        buttonPassword.sendKeys(PASSWORD);
        WebElement buttonSubmit = getDriver().findElement(By.xpath("//input[@type='submit']"));
        buttonSubmit.click();
        WebElement logoText = getDriver().findElement(By.xpath("//div[@class='app_logo']"));
        String actualLogoText = logoText.getText();
        WebElement title = getDriver().findElement(By.xpath("//span[@class='title']"));
        String actualTitle = title.getText();
        String actualLink = getDriver().getCurrentUrl();

        Assert.assertEquals(actualLink, expectedLink);
        Assert.assertEquals(actualLogoText, expectedLogoText);
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void testAuthorizationSaucedemoLockedUser() {

        final String BASE_URL = "https://www.saucedemo.com/";
        final String userName = "locked_out_user";
        final String PASSWORD = "secret_sauce";
        final String expectedErrorText = "Epic sadface: Sorry, this user has been locked out.";


        getDriver().get(BASE_URL);
        getDriver().manage().window().maximize();

        WebElement buttonText = getDriver().findElement(By.xpath("//div/input[@type='text']"));
        buttonText.sendKeys(userName);
        WebElement buttonPassword = getDriver().findElement(By.xpath("//div/input[@type='password']"));
        buttonPassword.sendKeys(PASSWORD);
        WebElement buttonSubmit = getDriver().findElement(By.xpath("//input[@type='submit']"));
        buttonSubmit.click();
        WebElement errorText = getDriver().findElement(By.xpath("//h3[contains(text(),'Epic sadface')]"));
        String actualErrorText = errorText.getText();
        String actualLink = getDriver().getCurrentUrl();

        Assert.assertEquals(actualLink, BASE_URL);
        Assert.assertEquals(actualErrorText, expectedErrorText);

    }
}
