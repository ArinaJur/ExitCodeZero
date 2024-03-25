package sprint3;
/*
Task1.
Написать метод, который принимает на вход текст, н-р, “достопримечательность”,
и возвращает количество букв “о” в этом слове.

Для проверки работы алгоритма второму человеку написать следующий селениум тест:
- перейти по ссылке:
https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C
- считать заголовок статьи
- с помощью алгоритма первого человека преобразовать actualResult
- подтвердить, что в заголовке содержится 3 буквы “О”

 */
public class LetterCounter {
    public static int countLetter(String text, char letter){
        int count = 0;

        try {
            String textToLowerCase = text.toLowerCase();
            char lt = Character.toLowerCase(letter);

            for (int i = 0; i < textToLowerCase.length(); i++) {
                if (textToLowerCase.charAt(i) == letter) {
                    count++;
                }
            }
        }catch (NullPointerException e){
            System.err.println("The provided text return Null");
        }
        return count;
    }
}


