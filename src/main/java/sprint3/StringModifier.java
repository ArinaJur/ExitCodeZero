package sprint3;

import java.util.HashMap;
import java.util.Map;

public class StringModifier {
    /*
    Написать метод, который принимает на вход текст, н-р, “Семь раз отмерь, один раз отрежь.“.
    Метод должен менять слова-цифры на арабские цифры, те “7 раз отмерь, 1 раз отрежь.“
     */
    public static String stringToNum(String sentence) {
        sentence = sentence.toLowerCase();
        String[] arrStr = sentence.split(" ");
        StringBuilder newSentence = new StringBuilder();

        for (String s : arrStr) {
            newSentence.append(parserWordToInt(s)).append(" ");
        }
        return newSentence.toString();
    }

    private static String parserWordToInt(String word) {
        Map<String, String> wordInt = new HashMap<>();

        wordInt.put("один", "1");
        wordInt.put("два", "2");
        wordInt.put("три", "3");
        wordInt.put("четыре", "4");
        wordInt.put("пять", "5");
        wordInt.put("шесть", "6");
        wordInt.put("семь", "7");
        wordInt.put("восемь", "8");
        wordInt.put("девять", "9");
        wordInt.put("ноль", "0");

        if(wordInt.containsKey(word)) {
            return wordInt.get(word);
        }

        return word;
    }
}
