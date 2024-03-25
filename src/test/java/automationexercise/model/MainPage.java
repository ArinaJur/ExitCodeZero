package automationexercise.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    public void clickLoginLink() {
        loginLink.click();
    }

}
