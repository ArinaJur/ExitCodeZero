package sprint3;


//Написать метод, который принимает на вход текст, н-р, “достопримечательность”,
// и возвращает количество гласных букв
//
//Для проверки работы алгоритма второму человеку написать следующий селениум тест:
//
//С помощью алгоритма первого человека подготовить expectedResult
//	- зайти на сайт https://ru.wikipedia.org/
//в поиске набрать слово “достопримечательность”
//в результатах поиска найти любое слово “достопримечательность”, считать текст
//подтвердить, что заголовок статьи содержит 7 гласных букв.


public class TC4CountVowels {
    public static String theNumberOfVowels(String INPUT_TEXT) {
        String text = INPUT_TEXT.toLowerCase().trim();
        char[] array = text.toCharArray();
        Integer counter = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == 'а' || array[i] == 'е'
                    || array[i] == 'ё'
                    || array[i] == 'и'
                    || array[i] == 'о'
                    || array[i] == 'э'
                    || array[i] == 'ы'
                    || array[i] == 'ю'
                    || array[i] == 'у'
                    || array[i] == 'я') {
                counter++;

            }
        }
        return counter.toString();
    }
}