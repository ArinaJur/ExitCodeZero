package sprint3;

import java.util.HashSet;
import java.util.Set;

public class CounterLetters {

    CounterLetters(){}

    public static int countUniqueLetters(String word) {
        if (word == null){
            return -1;
        }
        return countUnique(word).size();
    }

    private static Set<Character> countUnique(
            String word) {
        Set<Character> uniqueLetters = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                uniqueLetters.add(c);
            }
        }
        return uniqueLetters;
    }
}
