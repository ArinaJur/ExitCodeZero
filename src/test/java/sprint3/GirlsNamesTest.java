package sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GirlsNamesTest {

    @Test
    public void testGirlsNamesHappyPath() {
        String[] popularNames = {"Irina", "Yelena", "Victoria", "Nadya", "Lana", "Katerina", "Natalia"};
        String[] statisticsNames =  {"Yelena", "Irina", "Tatyana", "Olga", "Anna", "Yulia", "Natalia"};
        int expectedResult = 4;

       int actualResult = new GirlsNames().gilsNames(popularNames,  statisticsNames);

        Assert.assertEquals(actualResult, expectedResult);

        }

    @Test
    public void testGirlsNamesAllPopular() {
        String[] popularNames = {"Irina", "Yelena"};
        String[] statisticsNames =  {"Irina", "Yelena", "Irina", "Irina", "Yelena", "Irina", "Yelena", "Irina"};
        int expectedResult = 0;

        int actualResult = new GirlsNames().gilsNames(popularNames,  statisticsNames);

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testGirlsNamesEmpty() {
        String[] popularNames = {};
        String[] statisticsNames =  {};
        int expectedResult = 0;

        int actualResult = new GirlsNames().gilsNames(popularNames,  statisticsNames);

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testGirlsNamesAllUnpopular() {
        String[] popularNames = {"Irina", "Diana", "Vera"};
        String[] statisticsNames =  {"Yelena", "Katerina"};
        int expectedResult = 2;

        int actualResult = new GirlsNames().gilsNames(popularNames,  statisticsNames);

        Assert.assertEquals(actualResult, expectedResult);

    }


    }

