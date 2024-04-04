import com.github.dockerjava.api.model.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.sql.DriverManager.getDriver;

public class CheckFilterZtoA extends BaseTest {

    private void loginToSauceDemo() {
        WebElement username = getDriver().findElement(By.id("user-name"));
        ((WebElement) username).sendKeys("standard_user");
        WebElement password = getDriver().findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        getDriver().findElement(By.id("login-button")).click();
    }

    private void openSauceDemo() {
        getDriver().get("https://www.saucedemo.com/");
    }

    private void clickDropdownFilter() {
        getDriver().findElement(By.xpath("//select[@data-test=\"product-sort-container\"]")).click();
    }

    private void clickFilterZtoA() {
        getDriver().findElement(By.xpath("//option[@value='za']")).click();
    }

    private List<String> getTexts(List<WebElement> list) {
        List<String> texts = new ArrayList<>();
        for (WebElement productName : list) {
            texts.add(productName.getText());
        }
        return texts;
    }

    @Test
    public void checkFilterZtoA() {

        openSauceDemo();
        loginToSauceDemo();
        clickDropdownFilter();
        clickFilterZtoA();

        List<WebElement> productsNamesElements = getDriver().findElements(By.xpath("//div[@class='inventory_item_name ']"));
        List<String> productsNamesText = getTexts(productsNamesElements);

        List<String> expectedResult = new ArrayList<>(getTexts(productsNamesElements));

        expectedResult.sort(Collections.reverseOrder());

        Assert.assertEquals(productsNamesText, expectedResult);
    }
}
