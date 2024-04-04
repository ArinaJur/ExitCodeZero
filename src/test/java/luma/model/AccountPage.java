package luma.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
    private WebElement messageDivElement;

    @FindBy(xpath = "//div[@class='box-content']//p")
    private WebElement accountInfoParagraph;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMessageDivText() {
        return messageDivElement.getText();
    }

    public String getAccountInfoText() {
        return accountInfoParagraph.getText();
    }

    private void verify(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public void assertMessageDivText(String expectedText) {
        verify(getMessageDivText(), expectedText);
    }

    public void assertParagraphText(String expectedText) {
        verify(getAccountInfoText(), expectedText);
    }
}
