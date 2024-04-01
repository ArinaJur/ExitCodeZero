package sprint3;

public class Task10ReplaceWordsWithNumbers {
    /**
     * 10. Написать метод, который принимает на вход текст, н-р, “Упади семь раз и восемь раз поднимись.”
     * Метод должен менять слова-цифры на арабские цифры, те “Упади 7 раз и 8 раз поднимись.”
     */

    public static String replaceWordsWithNumbers(String text) {
        if (text == null || text.isEmpty()) {
            return "Wrong input";
        }

        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            String elem = words[i];
            words[i] = switch (elem.toLowerCase()) {
                case "один" -> "1";
                case "два" -> "2";
                case "три" -> "3";
                case "четыре" -> "4";
                case "пять" -> "5";
                case "шесть" -> "6";
                case "семь" -> "7";
                case "восемь" -> "8";
                case "девять" -> "9";
                case "десять" -> "10";
                default -> elem;
            };
        }

        return String.join(" ", words);
    }
}
