package automationexercise.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static automationexercise.Helper.BASE_URL;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
