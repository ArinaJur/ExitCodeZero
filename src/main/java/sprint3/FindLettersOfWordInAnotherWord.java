package sprint3;
/*Написать метод, который принимает на вход текст, например, “достопримечательность”,
и возвращает true, если из букв  данного слова можно построить слово “стрела”.

Для проверки работы алгоритма второму человеку написать следующий селениум тест:
	- зайти на сайт https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C

считать заголовок статьи (текст в теге h1)
подтвердить (с помощью алгоритма первого человека), что из букв заголовка можно составить слово “стрела”
*/

import java.util.ArrayList;
import java.util.Arrays;

public class FindLettersOfWordInAnotherWord {
    public static boolean findLettersOfWordInAnotherWord(String toFindWhat, String whereToFind) {
        if (toFindWhat == null && whereToFind == null || toFindWhat.length() == 0 || whereToFind.length() == 0 || toFindWhat.length() > whereToFind.length()) {

            return false;
        }
        ArrayList<String> arrayListToFindWhat = new ArrayList<>(Arrays.asList(toFindWhat.toLowerCase().split("")));
        ArrayList<String> arrayListWhereToFind = new ArrayList<>(Arrays.asList(whereToFind.toLowerCase().split("")));

        ArrayList<String> arrayListFound = new ArrayList<>(arrayListToFindWhat.size());

        for (int i = 0; i < arrayListToFindWhat.size(); i++) {
            for (int j = 0; j < arrayListWhereToFind.size(); j++) {
                if (arrayListToFindWhat.get(i).equals(arrayListWhereToFind.get(j))) {
                    arrayListFound.add(arrayListWhereToFind.get(j));
                    arrayListWhereToFind.remove(j);

                    break;
                }
            }
        }
        return arrayListToFindWhat.equals(arrayListFound);
    }

}
