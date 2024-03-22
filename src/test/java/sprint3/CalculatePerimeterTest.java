
package sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatePerimeterTest {

    @Test
    public void testCalculatePerimeterHappyPath() {
        int sideA = 2;
        int sideB = 2;
        int sideC = 2;
        int sideD = 2;
        int expectedResult = 8;

        int actualResult = new CalculatePerimeter().calculatePerimeter(sideA, sideB, sideC, sideD);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCalculatePerimeterZero() {
        int sideA = 0;
        int sideB = 10;
        int sideC = 10;
        int sideD = 0;
        int expectedResult = -1;

        int actualResult = new CalculatePerimeter().calculatePerimeter(sideA, sideB, sideC, sideD);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCalculatePerimeterOutOfRange() {
        int sideA = 1;
        int sideB = 2147483647;
        int sideC = 1;
        int sideD = 1;
        int expectedResult = -1;

        int actualResult = new CalculatePerimeter().calculatePerimeter(sideA, sideB, sideC, sideD);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCalculatePerimeterNegative() {
        int sideA = -2;
        int sideB = 2;
        int sideC = 7;
        int sideD = 2;
        int expectedResult = -1;

        int actualResult = new CalculatePerimeter().calculatePerimeter(sideA, sideB, sideC, sideD);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void resultSquare1() {

        // int a = 24, b = 8, c = 4, d = 6;  // 42
        //  int a = 0, b = 8, c = 4, d = 6;
        int a = -8, b = 8, c = 4, d = 6;
        int expectedResult = -1;

        int actualResult = new CalculatePerimeter().calculatePerimeter(a, b, c, d);

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testCalculatePerimeterOutOfRangeLENA() {
        int sideA = 600;
        int sideB = 2147483647;
        int sideC = 40;
        int sideD = 8;
        int expectedResult = -1;

        int actualResult = new CalculatePerimeter().calculatePerimeter(sideA, sideB, sideC, sideD);

        Assert.assertEquals(actualResult, expectedResult);
    }
}