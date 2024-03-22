package sprint3;

import java.util.Arrays;

public class LetterTo0 {
    //Task 9
    // Написать метод, который принимает на вход слово, например, “абракадабра”.
    // Метод меняет максимально встречающуюся букву в слове на цифру 0
    // (должно получиться “0бр0к0д0бр0”).
    // Если в слове одинаковое количество разных букв, то необходимо заменить
    // на 0 ту букву, которая встречается в слове первой (“куку” -> “0у0у”)


    public String letterTo0(String word) {
        word = word.trim().toLowerCase();
        char[] letters = word.toCharArray();
        Arrays.sort(letters);

        int count = 0;

        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] != letters[i + 1]) {
                count++;
            }
        }

        int[] counts = new int[count];
        char[] uniqueLetters = new char[count];

        for (int i = 0, j = 0; i < letters.length && j < counts.length; i++) {
            if (letters[i] == letters[i + 1]) {
                counts[j] = counts[j] + 1;
            } else {
                uniqueLetters[j] = letters[j];
                j++;
            }
        }

        int max = 0;
        int index = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                index = i;
            }
        }

        char[] newWord = word.toCharArray();

        for (int i = 0; i < newWord.length; i++) {
            if (newWord[i] == uniqueLetters[index]) {
                newWord[i] = '0';
            }
        }

        StringBuilder result = new StringBuilder();

        for (char l : newWord) {
            result.append(l);
        }

        return result.toString();
    }
}
