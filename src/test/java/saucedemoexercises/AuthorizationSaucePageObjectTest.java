package saucedemoexercises;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import saucedemoexercises.model.SauceLoginPage;
import saucedemoexercises.model.SauceProductsPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AuthorizationSaucePageObjectTest extends BaseTest {

    private static final String BASE_URL = "https://www.saucedemo.com/";

    @Test
    public void testLoginHP(){

        SauceLoginPage loginPage = new SauceLoginPage(getDriver());
        SauceProductsPage productsPage = new SauceProductsPage(getDriver());

        loginPage.open(BASE_URL);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(productsPage.getCurrentUrl(),
                            BASE_URL + "inventory.html");
        Assert.assertEquals(productsPage.getLogoText(), "Swag Labs");
        Assert.assertEquals(productsPage.getPageTitle(), "Products");

        List<String> productNamesAZ = productsPage.selectSortOption("Name (A to Z)");
        System.out.println(productNamesAZ);
        productsPage.assertSortingOrder("az", productNamesAZ);

        List<String> productNamesZA = productsPage.selectSortOption("Name (Z to A)");
        List<String> reversedList = getReversedList(productNamesAZ);
        productsPage.assertSortingOrder("za", reversedList);
        productsPage.assertSortingOrder("za", productNamesZA);
        Assert.assertEquals(reversedList, productNamesZA);
    }

    private List<String> getReversedList(List<String> productNames) {
        List<String> reversedList = new ArrayList<>(productNames);
        Collections.reverse(reversedList);
        return reversedList;
    }
}
