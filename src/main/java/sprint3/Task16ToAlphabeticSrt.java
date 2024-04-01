// https://docs.google.com/document/d/10Wrrsy5oMVxzQe2KMjTXcBAdifxfIRcNRRF1G8TAPZ0/edit
//
// 16. Написать метод, который принимает на вход строку, состоящую из букв латинского алфавита и цифр, и возвращает
// строку, состоящую только из букв.
//  Для проверки работы алгоритма второму человеку написать следующий селениум тест:
//  с помощью алгоритма первого человека подготовить expectedResult
//  зайти на сайт https://www.textfixer.com/tools/remove-numbers-from-text.php
//	-  в строке ввода текста набрать “неСодержит5цифр”
//  - нажать на кнопку Remove numbers
//  - считать полученный результат
//  - подтвердить, что преобразованное предложение не содержит цифр

package sprint3;

public class Task16ToAlphabeticSrt {

    public static String toStringFromLetterNumberToLetter(String stringText) {

        String newStringText;

        if (stringText.equals(null)) {
            System.out.println("Text is null");
            newStringText = "";
        }

        newStringText = stringText.trim();

        String letterText = "";
        String number = "0123456789";

        for (int i = 0; i < newStringText.length(); i++) {
            if (!number.contains(String.valueOf(newStringText.charAt(i)))) {
                letterText += String.valueOf(newStringText.charAt(i));
            }

        }

        if (letterText.isEmpty()) {
            System.out.println("Text is empty");
        } else {
            System.out.println(letterText);
        }

        return letterText;
    }
}
