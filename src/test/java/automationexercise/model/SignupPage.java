package automationexercise.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignupPage
        extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".login-form > form")
    private WebElement loginForm;

    @FindBy(css = "b")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement accountInformationHeader;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "id_gender1")
    private WebElement genderRadio;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = ".btn:nth-child(22)")
    private WebElement submitButton;

    @FindBy(id = "days")
    private WebElement daysDropdown;

    @FindBy(id = "months")
    private WebElement monthsDropdown;

    @FindBy(id = "years")
    private WebElement yearsDropdown;

    public void clickNewsletter() {
        newsletterCheckbox.click();
    }

    public void clickGender() {
        genderRadio.click();
    }

    public void enterCompany(String company) {
        companyInput.sendKeys(company);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        zipcodeInput.sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void clickSignupButton() {
        submitButton.click();
    }

    public void clickLoginForm() {
        loginForm.click();
    }

    public void setDate(String day, String month, String year) {
        daysDropdown.findElement(By.xpath("//option[. = '" + day + "']")).click();
        monthsDropdown.findElement(By.xpath("//option[. = '" + month + "']")).click();
        yearsDropdown.findElement(By.xpath("//option[. = '" + year + "']")).click();
    }
    public void enterAddress(
            String address1,
            String address2,
            String state,
            String country) {
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);
        stateInput.sendKeys(state);
        countryDropdown.findElement(By.xpath("//option[. = '" + country + "']")).click();
    }

    public void enterFullName(
            String firstName,
            String lastName) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
    }

    public void setCredential(
            String login,
            String password) {
        nameInput.clear();
        nameInput.sendKeys(login);
        passwordInput.sendKeys(password);
    }

    public void verifyAccountInformationHeader() {
        Assert.assertTrue(accountInformationHeader.isDisplayed());
    }

    public void verifyAccountText(String expectedResult) {
        Assert.assertEquals(accountInformationHeader.getText(), expectedResult);
    }
}
