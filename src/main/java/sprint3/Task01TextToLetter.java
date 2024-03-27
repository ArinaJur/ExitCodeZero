// https://docs.google.com/document/d/10Wrrsy5oMVxzQe2KMjTXcBAdifxfIRcNRRF1G8TAPZ0/edit
//
//   1.  Написать метод, который принимает на вход текст, н-р, “достопримечательность”, и возвращает количество
//   букв “о” в этом слове.
//
//   Для проверки работы алгоритма второму человеку написать следующий селениум тест:
//    - зайти на сайт https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C
//
//  считать заголовок статьи
//  с помощью алгоритма первого человека преобразовать actualResult
//  подтвердить, что в заголовке содержится 3 буквы “О”


package sprint3;

public class Task01TextToLetter {

    public int calculateLetterFromText(String text, char letter) {

        int count = 0;

        if (letter == '\u0000') {   //   '\u0000' -> null
            System.out.println("Letter is null.");

            count = -1;

        } else if (Character.isLetter(letter)) {

            String newText = text.toLowerCase();
            char newLetter = Character.toLowerCase(letter);

            for (int i = 0; i < newText.length(); i++) {
                if (newText.charAt(i) == newLetter) {
                    System.out.println(newText.charAt(i));

                    count++;
                }
            }
        } else {
            System.out.println("Symbol is not a letter");

            count = -1;
        }

        return count;
    }
}
