package sprint3;

public class CountSymbols {
//    Написать метод, который принимает на вход текст  и возвращает количество не буквб  не цифр и не пробелов в тексте
//    (посчитать запятые, точки, восклицательные знаки и тп)

    public int countSymbols(String text) {
        if (text == null || text.isEmpty()) {
            return -1;
        }

        String[] arrayText = text.toLowerCase().trim().split("");
        int count = 0;

        for (int i = 0; i < arrayText.length; i++) {
            if (isLetter(arrayText[i]) || isDigit(arrayText[i]) || arrayText[i].equals(" ")) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    public boolean isLetter(String text) {
        char[] charArray = text.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isLetter(charArray[i])) {
                return false;

            }
        }
        return true;
    }

    public boolean isDigit(String text) {
        char[] charArray = text.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isDigit(charArray[i])) {
                return false;
            }
        }
        return true;
    }
}
