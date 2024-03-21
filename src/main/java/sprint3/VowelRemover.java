package sprint3;

public class VowelRemover {

    private static final String VOWELS
            = "aeiouyAEIOUYаеёиоуыэюяАЕЁИОУЫЭЮЯáéíóúýÁÉÍÓÚÝàèìòùỳÀÈÌÒÙỲâêîôûŷÂÊÎÔÛŶäëïöüÿÄËÏÖÜŸăĕĭŏŭĂĔĬŎŬäöüÄÖÜß";

    // Sprint3, Task 15
    // Write a method that takes a string as input and returns a string without vowels.

    public static String removeVowels(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            // Check if the character 'c' is not found in the list of vowels.
            // If the character is not a vowel, append it to the result StringBuilder.
            if (VOWELS.indexOf(c) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
