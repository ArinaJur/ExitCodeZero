package luma;

import automationexercise.model.BaseTest;
import luma.model.SignUpPage;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test
    void  testSignIn(){
        getDriver().get("https://magento.softwaretestingboard.com/customer/account/create/");

        getDriver().manage().window().maximize();

        SignUpPage signUpPage = new SignUpPage(getDriver());

        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterEmail("johndoe123@example123.com");
        signUpPage.enterPassword("Password123!");
        signUpPage.enterConfirmPassword("Password123!");

        signUpPage.clickCreateAccountButton();
    }
}
