package sprint3.provider;

import org.testng.annotations.DataProvider;

public class CounterDataProvider {

    public static final String data = "Это мой Текст из русских слов и слова dot";

    @DataProvider(name = "negativeTestData")
    public Object[][] negativeTestData() {
        return new Object[][] {
                {null, -1},
                {"", 0}
        };
    }

    @DataProvider(name = "wordDataHappyPath")
    public Object[][] wordDataHappyPath() {

        return new Object[][]{
                {"абракадабра", 5},
                {"АбРакадабра", 7},
                {"aбpакадабра", 7}, //English letters: word.charAt(0) = 'a', word.charAt(2) = 'p'
                {"1ая", 2},
                {"пол-литра", 7},
                {" ", 0}
        };
    }

    @DataProvider(name = "wordDataNegativeScenario")
    public Object[][] wordDataNegativeScenario() {

        return new Object[][]{
                {"", 0},
                {null, -1}
        };
    }
}
