package automationexercise;

//Test Case 7: Verify Test Cases Page
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Test Cases' button
//5. Verify user is navigated to test cases page successfully

//1. Запустите браузер
//2. Перейдите по URL-адресу «http://automationexercision.com».
//3. Убедитесь, что домашняя страница успешно видна.
//4. Нажмите кнопку «Тестовые примеры».
//5. Убедитесь, что пользователь успешно перешел на страницу тестовых примеров.

import automationexercise.model.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static automationexercise.Helper.BASE_URL;

public class TC07VerifyTestCasesPage extends BaseTest {

@Test
    public void testVerifyTestCasesPage() {

    final String expectedTitleHome = "Automation Exercise";
    final String expectedTitleTestCases = "Automation Practice Website for UI Testing - Test Cases";

    getDriver().manage().window().maximize();
    getDriver().get(BASE_URL);
    Assert.assertEquals(getDriver().getTitle(), expectedTitleHome);

    getDriver().findElement(By.xpath("//a[@href='/test_cases']/i[@class]")).click();
    Assert.assertEquals(getDriver().getTitle(), expectedTitleTestCases);

    getDriver().quit();

    }
}
