package saucedemoexercises.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {
    private final WebDriver driver;

    @FindBy(xpath = "//div/input[@type='text']")
    private WebElement usernameInput;

    @FindBy(xpath = "//div/input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    public SauceLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
