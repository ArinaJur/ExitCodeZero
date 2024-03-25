package sprint3.provider;

import org.testng.annotations.DataProvider;

public class CounterDataProvider {

    public static final String data = "Это мой Текст из русских слов и слова dot";

    @DataProvider(name = "negativeTestData")
    public Object[][] negativeTestData() {

        return new Object[][] {
                {null, -1},
                {" ", 0},
                {"", 0}
        };
    }

    @DataProvider(name = "textData")
    public Object[][] textData() {

        return new Object[][] {
                {"Привет, мир!", 9},
                {"Как дела?", 7},
                {"Hello, world!", 0},
                {"1234567890", 0},
                {"Тестирование", 12},
                {"АаЙйЯя", 6},
                {"azAz", 0},
        };
    }

    @DataProvider(name = "happyPathUniqueWords")
    public Object[][] wordsDataProvider() {

        return new Object[][] {
                {"абракадабра", 5},
                {"hello", 4},
                {"banana", 3},
                {"programming", 8},
                {"unique", 5}
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
