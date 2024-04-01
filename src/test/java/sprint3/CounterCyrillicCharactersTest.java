package sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;
import sprint3.provider.CounterDataProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sprint3.Task22CounterCyrillicCharacters.countCyrillicCharacters;
import static sprint3.CounterLetters.countUniqueLetters;

public class CounterCyrillicCharactersTest {

    @Test(dataProvider = "textData",
            dataProviderClass = CounterDataProvider.class)
    public void testCountCyrillicCharacters(
            String text, int expectedResult) {
        int actual = countCyrillicLetters(text);
        int actualResult = countCyrillicCharacters(text);
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actual, expectedResult);
        Assert.assertEquals(actual, actualResult);
    }

    @Test(dataProvider = "negativeTestData",
            dataProviderClass = CounterDataProvider.class)
    public void testCountUniqueLettersNegative(
            String word, int expectedResult) {
        int actual = countCyrillicLetters(word);
        int actualResult = countCyrillicCharacters(word);
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actual, expectedResult);
        Assert.assertEquals(actual, actualResult);
    }

    @Test(dataProvider = "happyPathUniqueWords",
            dataProviderClass = CounterDataProvider.class)
    public void testCountUniqueLetters(
            String word, int expected) {
        int actual = countUniqueLetters(word);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "negativeTestData",
            dataProviderClass = CounterDataProvider.class)
    public void testCountUniqueLettersInvalidWords(
            String word, int expected) {
        int actual = countUniqueLetters(word);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "wordDataHappyPath",
            dataProviderClass = CounterDataProvider.class)
    public void testCountUniqueLettersHappyPath(
            String word, int expectedResult) {
        int actualResult = countUniqueLetters(word);
        Assert.assertEquals(actualResult, expectedResult);
    }

    private int countCyrillicLetters(String text) {
        if (text == null){
            return -1;
        }

        Matcher matcher = Pattern.compile("[а-яА-Я]").matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
