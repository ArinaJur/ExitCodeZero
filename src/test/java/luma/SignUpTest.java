package luma;

import luma.model.AccountPage;
import luma.model.SignUpPage;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.Random;

public class SignUpTest extends BaseTest {

    @Test
    void  testSignIn(){
        getDriver().get("https://magento.softwaretestingboard.com/customer/account/create/");

        getDriver().manage().window().maximize();

        SignUpPage signUpPage = new SignUpPage(getDriver());

        String firstName = "John";
        String lastName = "Doe";
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        String email = String.format("johndoei%d@%s%d.com",
                                     generateRandomInt(),
                                     generateRandomString(5),
                                     generateRandomInt());
        signUpPage.enterEmail(email);
        signUpPage.enterPassword("Password123!");
        signUpPage.enterConfirmPassword("Password123!");

        signUpPage.clickCreateAccountButton();

        AccountPage accountPage = new AccountPage(getDriver());
        accountPage.assertMessageDivText("Thank you for registering with Main Website Store.");
        accountPage.assertParagraphText(firstName+" "+lastName+"\n"+email);
    }

    private int generateRandomInt() {
        return (int) (Math.random() * 1000);
    }

    private static String generateRandomString(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
