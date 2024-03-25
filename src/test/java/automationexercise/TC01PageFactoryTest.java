package automationexercise;

import automationexercise.model.AccountCreatedPage;
import automationexercise.model.SignupPage;
import automationexercise.model.DeleteAccountPage;
import automationexercise.model.LoginPage;
import automationexercise.model.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * 1. Launch browser
 * 2. Navigate to url '<a href="http://automationexercise.com"></a>'
 * 3. Verify that home page is visible successfully
 * 4. Click on 'Signup / Login' button
 * 5. Verify 'New User Signup!' is visible
 * 6. Enter name and email address
 * 7. Click 'Signup' button
 * 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
 * 9. Fill details: Title, Name, Email, Password, Date of birth
 * 10. Select checkbox 'Sign up for our newsletter!'
 * 11. Select checkbox 'Receive special offers from our partners!'
 * 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
 * 13. Click 'Create Account button'
 * 14. Verify that 'ACCOUNT CREATED!' is visible
 * 15. Click 'Continue' button
 * 16. Verify that 'Logged in as username' is visible
 * 17. Click 'Delete Account' button
 * 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 * */
public class TC01PageFactoryTest {
    private WebDriver driver;
    private static final String url = "https://automationexercise.com";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        login();
        signup();
        create();
        delete();
    }

    private void login() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();
        String expectedResult = "New User Signup!";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifySignupHeaderText();
        loginPage.verifyText(expectedResult);
        loginPage.enterName("Alice");
        loginPage.enterEmail("alice%d@gmail.com".formatted(
                new Random().nextInt(10000)));
        loginPage.clickSignupButton();
    }

    private void signup() {
        String expectedResult = "ENTER ACCOUNT INFORMATION";
        SignupPage signupPage = new SignupPage(driver);
        signupPage.verifyAccountInformationHeader();
        signupPage.verifyAccountText(expectedResult);
        signupPage.clickNewsletter();
        signupPage.clickGender();
        signupPage.setCredential("Alice", "alice");
        signupPage.setDate("2", "February", "2000");
        signupPage.enterFullName("Pashu", "Pati");
        signupPage.enterCompany("MB");
        signupPage.enterAddress("Che", "Bukovina", "Iowa", "Canada");
        signupPage.clickLoginForm();
        signupPage.enterCity("Che");
        signupPage.enterZipcode("12345");
        signupPage.enterMobileNumber("+380990909999");
        signupPage.clickSignupButton();
    }

    private void create() {
        String expectedResult = "Alice";
        String expected = "ACCOUNT CREATED!";
        AccountCreatedPage create = new AccountCreatedPage(driver);
        create.verifyAccountCreated(expected);
        create.clickContinue();
        skipAdv();
        create.verifyAccountLoginName(expectedResult);
    }

    private void delete() {
        String expected = "ACCOUNT DELETED!";
        DeleteAccountPage delete = new DeleteAccountPage(driver);
        delete.clickDeleteLink();
        delete.verifyAccountDeleted(expected);
        delete.clickContinueLink();
    }

    private void skipAdv() {
        try {
            Thread.sleep(2000);
            Actions actions = new Actions(driver);
            actions.moveByOffset(100, 200).click().perform();
            Thread.sleep(2000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
