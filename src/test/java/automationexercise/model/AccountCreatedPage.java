package automationexercise.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountCreatedPage
        extends BasePage {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    private WebDriver driver;

    @FindBy(xpath = "//li/a/b")
    private WebElement loginName;

    @FindBy(css = "b")
    private WebElement accountCreatedText;

    @FindBy(linkText = "Continue")
    private WebElement continueLink;

    public void verifyAccountCreated(String expected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(accountCreatedText));
        Assert.assertEquals(accountCreatedText.getText(), expected);
    }

    public void clickContinue() {
        continueLink.click();
    }

    public void verifyAccountLoginName(String value) {
        Assert.assertEquals(loginName.getText(), value);
    }
}
