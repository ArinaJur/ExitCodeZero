package sprint3;

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
