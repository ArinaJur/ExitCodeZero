package sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnCountOfNumbersTest {


    @Test
    public void testCountNumbers() {
        int[] intArray = {5, 19, -55, 0};
        int[] expectedResult = {3, 1};

        int[] actualResult = new ReturnCountOfNumbers().returnCountOfNumbers(intArray);

        Assert.assertEquals(actualResult, expectedResult);


    }

    @Test
    public void testCountNumbersAllNeg() {
        int[] intArray = {-5, -19, -55, -10};
        int[] expectedResult = {0, 4};

        int[] actualResult = new ReturnCountOfNumbers().returnCountOfNumbers(intArray);

        Assert.assertEquals(actualResult, expectedResult);


    }

    @Test
    public void testCountNumbersAllPOS() {
        int[] intArray = {5, 19, 55, 10};
        int[] expectedResult = {4, 0};

        int[] actualResult = new ReturnCountOfNumbers().returnCountOfNumbers(intArray);

        Assert.assertEquals(actualResult, expectedResult);


    }

    @Test
    public void testCountNumbersEmpty() {
        int[] intArray = {};
        int[] expectedResult = {0, 0};

        int[] actualResult = new ReturnCountOfNumbers().returnCountOfNumbers(intArray);

        Assert.assertEquals(actualResult, expectedResult);


    }

}
