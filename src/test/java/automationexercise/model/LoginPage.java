package automationexercise.model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@class='signup-form']//h2")
    private WebElement signupHeaderText;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public String getText() {
        return signupHeaderText.getText();
    }

    public void verifySignupHeaderText() {
        Assert.assertTrue(signupHeaderText.isDisplayed());
    }

    public void verifyText(String expectedResult) {
        Assert.assertEquals(getText(), expectedResult);
    }
}
