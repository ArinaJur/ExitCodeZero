package sprint3;

public class Task18WordsCounter {
    public static String wordsCounter(String INPUT_TEXT) {
        Integer wordCount = 0;
        boolean word = false;
        Integer endOfLine = INPUT_TEXT.length() - 1;

        for (int i = 0; i < INPUT_TEXT.length(); i++) {
            if (Character.isLetter(INPUT_TEXT.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(INPUT_TEXT.charAt(i)) && word) {
                wordCount++;
                word = false;
            } else if (Character.isLetter(INPUT_TEXT.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        String wordCount1 = Integer.toString(wordCount);
        return wordCount1;
    }
}
