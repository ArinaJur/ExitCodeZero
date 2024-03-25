package automationexercise.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DeleteAccountPage extends BasePage {

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    private WebDriver driver;

    @FindBy(css = "b")
    private WebElement accountDeletedText;

    @FindBy(linkText = "Continue")
    private WebElement continueLink;

    @FindBy(linkText = "Delete Account")
    private WebElement deleteLink;

    public String getAccountDeletedText() {
        return accountDeletedText.getText();
    }

    public void clickContinueLink() {
        continueLink.click();
    }

    public void clickDeleteLink() {
        deleteLink.click();
    }

    public void verifyAccountDeleted(String expected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(accountDeletedText));
        Assert.assertEquals(accountDeletedText.getText(), expected);
    }
}
