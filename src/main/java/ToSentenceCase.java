public class ToSentenceCase {
    //Написать алгоритм, который принимает на вход предложение и переводит его в Sentence case
    // Н-р, предложение “мама мыла Раму”
    //
    //
    //Для проверки работы алгоритма написать следующий Селениум тест
    //
    //- С помощью алгоритма первого человека подготовить expectedResult = “Мама мыла раму.”
    //- Пройти на сайт https://capitalizemytitle.com/
    //- Ввести в текстовое поле предложение “мама мыла Раму.”
    //- Нажать на кнопку Sentence case
    //- Считать результат преобразования
    //- Подтвердить, что результат работы программы соответствует expectedResult

    public String toSentenceCase(String sentence) {
        String newSentence = "";

        newSentence = sentence.trim().toLowerCase();

        String firstLetterInUpperCase = newSentence.substring(0, 1).toUpperCase();

        newSentence = newSentence.replaceFirst(newSentence.substring(0, 1), firstLetterInUpperCase);

        return newSentence;
    }
}
