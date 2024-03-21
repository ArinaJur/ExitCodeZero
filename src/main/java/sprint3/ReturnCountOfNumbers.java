package sprint3;
//Написать метод, коорый принимает на вход массив целых чисел (положительных и отрицательных) и
//возвращает массив количества положительных значений и отрицательных значений. ноль считается положительным значением.
//        (приходит {5, 19, -55, 0} возвращает {3, 1})

public class ReturnCountOfNumbers {
    public int[] returnCountOfNumbers(int[] arrayNumbers) {;
        int cPos = 0;
        int cNeg = 0;
        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] >= 0) {
                cPos++;
            } else {
                cNeg++;
            }

        }
        return new int[]{cPos, cNeg};
    }



}
