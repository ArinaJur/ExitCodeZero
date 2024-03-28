package sprint3;

public class Task21CountNumbersInText {
    /**
     * Написать метод, который принимает на вход текст  и возвращает количество цифр в тексте
     */

    public static int countNumbersInText(String text) {
        if (text == null || text.isEmpty()) {
            return -1;
        }

        int count = 0;

        for (String letter : text.split("")) {
            if (letter.matches("[0-9]")) {
                count++;
            }
        }

        return count;
    }
}
