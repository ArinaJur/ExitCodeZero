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


public class CountVowels {
    public static String theNumberOfVowels(String INPUT_TEXT) {


        for (int i = 0; i < INPUT_TEXT.length(); i++) {
            Integer counter = 0;
            if (INPUT_TEXT.charAt(i) == 'а' || INPUT_TEXT.charAt(i) == 'е'
                    || INPUT_TEXT.charAt(i) == 'ё'
                    || INPUT_TEXT.charAt(i) == 'и'
                    || INPUT_TEXT.charAt(i) == 'о'
                    || INPUT_TEXT.charAt(i) == 'э'
                    || INPUT_TEXT.charAt(i) == 'ы'
                    || INPUT_TEXT.charAt(i) == 'ю'
                    || INPUT_TEXT.charAt(i) == 'у'
                    || INPUT_TEXT.charAt(i) == 'я') {
                counter++;
            }
            String counter1 = Integer.toString(counter);

            return counter1;

        } return "You don't solve the problem";
    }
}