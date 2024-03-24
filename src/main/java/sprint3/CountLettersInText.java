package sprint3;
/*Написать метод, который принимает на вход текст
и возвращает количество латинских символов в тексте
Надя*/

public class CountLettersInText {
    public static int countLettersInText(String text, char letter) {

        if (text == null || letter == 0) {
            return -1;
        }

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.toLowerCase().charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }
}
