package sprint3;

import java.util.Arrays;

public class CapitalizedCaseMG {
    public String capitalize(String sentence) {

        //проверка на неправильный аргумент
        if (sentence == null) {
            return "Server Error. Please try again.";
        }

        if (sentence.isEmpty()) {
            return "Empty input.";
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split("\\s+"); //создание массива слов с разделением по пробелу

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            //если полученная строка не пустая, преобразуем первый символ в верхний регистр
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
                result.append(capitalizedWord);
            }
            //добавляем преобразовнное слово в новую строку и ставим пробел после каждого, кроме последнего
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}