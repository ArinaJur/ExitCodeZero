package sprint3;

public class Task22CounterCyrillicCharacters {

    /**
     * 22
     * Написать метод, который принимает на вход текст  и возвращает количество кириллических символов
     * в тексте
     * Для проверки результата
     * подготовить expected результат с помощью алгоритма другого человека
     * зайти на сайт <a href="https://involta.ru/tools/length-chars/">...</a>
     * ввести текст “Это мой Текст из русских слов и слова dot”
     * нажать кнопку Посчитать
     * считать количество кириллических символов из таблицы результатов
     * подтвердить, что в тексте содержится 30 кириллических символов
     */
    public static int countCyrillicCharacters(String data) {
        if (data == null) {

            return -1;
        }
        data = data.trim();
        if (data.isEmpty()) {

            return 0;
        }
        int count = 0;
        data = data.toLowerCase();
        for (char c : data.toCharArray()) {
            if ((Character.UnicodeBlock.of(c).equals(Character.UnicodeBlock.CYRILLIC))) {
                count++;
            }
        }
        return count;
    }
}


