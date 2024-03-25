package sprint3;

/**
 * Написать метод, который принимает String параметр и переворачивает текст, например, “stressed” → “desserts”
 * <p>
 * Для проверки результата
 * с помощью алгоритма другого человека преобразовать слово “stressed”, получив expectedResult
 * зайти на сайт https://onlinestringtools.com/reverse-string
 * ввести в поле input string слово “stressed””
 * считать результат из поля reversed string
 * подтвердить, что программа преобразования текста  работает правильно
 */

public class ReverseWord {
    public static String getReversedWord(String word) {
        if (word == null || word.isEmpty()) {
            return "Word not found";
        }

        StringBuilder reversedWord = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord.append(word.charAt(i));
        }


        return reversedWord.toString();
    }
}
