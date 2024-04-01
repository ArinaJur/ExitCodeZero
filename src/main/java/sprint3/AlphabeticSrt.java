package sprint3;

public class AlphabeticSrt {
    /*Написать метод, который принимает на вход строку, состоящую из букв латинского алфавита и цифр,
     и возвращает строку, состоящую только из цифр, расположенных в столбик*/

    public static String alphabeticString(String sentence){
        String result = "";
        sentence = sentence.toLowerCase();

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) >= 48 && sentence.charAt(i) <= 57) {
                result += sentence.charAt(i) + "\n";
            }
        }
        return result;
    }
}
