package sprint3;

public class CalculatePerimeter {
    public int calculatePerimeter(int sideA, int sideB, int sideC, int sideD) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 || sideD <= 0) {

            return -1;
        }
        int perimeter = sideA + sideB + sideC + sideD;
        if (perimeter > 0) {

            return perimeter;
        }

        return -1;
    }

}


