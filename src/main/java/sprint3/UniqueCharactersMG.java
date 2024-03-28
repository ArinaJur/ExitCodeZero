package sprint3;


public class UniqueCharactersMG {
    public String uniqueCharsCount(String sentence){
        //проверка на неправильный аргумент
        if (sentence == null) {
            return "Server Error. Please try again.";
        }

        if (sentence.isEmpty()) {
            return "Empty input.";
        }

        StringBuilder newSentence = new StringBuilder();
        char[] chars = sentence.trim().toLowerCase().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!newSentence.toString().contains(String.valueOf(chars[i]))) {
                newSentence.append(chars[i]);
            }
        }

        return "Количество уникальных символов: " + newSentence.length();
    }
}