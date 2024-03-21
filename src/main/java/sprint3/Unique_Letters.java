package sprint3;//Написать метод, который принимает на вход текст, н-р, “достопримечательность”,
// и возвращает количество уникальных букв.

import java.util.HashMap;


public class Unique_Letters {
    public static int uniqueLetters(String word) {
        String word2 = word.trim().toLowerCase();
        String word3 = "";

        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Подсчёт количества каждого символа
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c : charCountMap.keySet()) {
            if (charCountMap.get(c) == 1) {
                word3 += c + "";
            }

        }
        return word3.length();
    }
}

