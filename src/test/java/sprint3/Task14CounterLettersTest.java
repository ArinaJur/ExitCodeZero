package sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;
import sprint3.provider.CounterDataProvider;

import static sprint3.CounterLetters.countUniqueLetters;

public class Task14CounterLettersTest {
    @Test
    public void testCountUniqueLettersHappyPath() {
        String word = "абракадабра";
        int expectedResult = 5;

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test //In condition: "уникальных букв" =>  'a' != 'A'
    public void testCountUniqueLettersSentenceCaseHappyPath() {
        String word = "АбРакадабра";
        int expectedResult = 7;

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test //In condition: "уникальных букв" => 'а'(russian) != 'a'(english)
    public void testCountUniqueLettersEnglishAndRussianHappyPath() {
        //English letters: word.charAt(0) = 'a', word.charAt(2) = 'p'
        String word = "aбpакадабра";
        int expectedResult = 7;

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test  // In condition: "уникальных букв" => number "1" is not letter
    public void testCountUniqueLettersNumberHappyPath() {
        String word = "1ая";
        int expectedResult = 2;

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test  //In condition: "уникальных букв" =>  symbol  "-" is not letter
    public void testCountUniqueLettersNumberAndSpecialSymbolHappyPath() {
        String word = "пол-литра";
        int expectedResult = 7;

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test //In condition: "уникальных букв" => space is not letter
    public void testCountUniqueLettersSpaceHappyPath() {
        String word = " ";
        int expectedResult = 0;

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCountUniqueLettersNull() {
        String word = null;
        int expectedResult = -1;

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCountUniqueLettersEmpty() {
        String word = "";
        int expectedResult = 0;

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "wordDataHappyPath", dataProviderClass = CounterDataProvider.class)
    public void testCountUniqueLettersHappyPath(String word, int expectedResult) {
        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "wordDataNegativeScenario", dataProviderClass = CounterDataProvider.class)
    public void testCountUniqueLettersNegativeScenario(String word, int expectedResult) {

        int actualResult = countUniqueLetters(word);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
