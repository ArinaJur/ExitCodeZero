// https://docs.google.com/document/d/10Wrrsy5oMVxzQe2KMjTXcBAdifxfIRcNRRF1G8TAPZ0/edit
//
//20.Написать метод, который принимает на вход текст  и возвращает количество пробелов
//Для проверки результата
//подготовить expected результат с помощью алгоритма другого человека
//зайти на сайт https://involta.ru/tools/length-chars/
//ввести текст “Это мой     Текст”
//нажать кнопку Посчитать
//считать количество пробелов из таблицы результатов
//подтвердить, что в тексте содержится 6 пробелов
package sprint3;

public class CountTextSpaces {

    public int toCountSpaces(String text){

        int spacesCount = 0;
        // Перебираем каждый символ в тексте
        for (int i = 0; i < text.length(); i++) {
            // Если текущий символ - пробел, увеличиваем счетчик пробелов
            if (text.charAt(i) == ' ') {
                spacesCount++;
            }
        }
        return spacesCount;
    }
}
