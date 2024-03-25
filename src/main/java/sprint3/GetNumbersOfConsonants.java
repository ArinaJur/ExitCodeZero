package sprint3;

public class GetNumbersOfConsonants {
    //Написать метод, который принимает на вход текст, н-р, “достопримечательность”, и возвращает количество согласных букв
    //
    //Для проверки работы алгоритма второму человеку написать следующий селениум тест:
    //    - зайти на сайт https://ru.wikipedia.org/
    //в поиске набрать слово “достопримечательность”
    //в результатах поиска найти любое слово “достопримечательность”, считать текст
    //с помощью алгоритма первого человека преобразовать actualResult
    //подтвердить, что заголовок статьи содержит 14 согласных букв.


    public int getNumbersOfConsonants(String word) {
       String modifWord = word.toLowerCase().trim();
        for (int i = 0; i <  modifWord.length(); i++) {
            char x =  modifWord.charAt(i);
            //   System.out.println("This word contains non-alphabetic characters.");
            if (!Character.isLetter(x)) return -1; // if non-alphabetic character found
        }
        int consonants = 0;
        for (int i = 0; i < modifWord.length(); i++) {
            char x = modifWord.charAt(i);
            if (x >= 'a' && x <= 'z') {
                if (x != 'a' && x != 'e' && x != 'i' && x != 'u' && x != 'o') {
                    consonants++;
                }
            }
        }
        return consonants;
       // return ("Number of consonants: " + count);
    }


//        public static int getNumberOfConsonants(String word) {
//            word = word.toLowerCase();
//            int count = 0;
//            HashSet<Character> vowels = new HashSet<>();
//            vowels.add('a');
//            vowels.add('e');
//            vowels.add('i');
//            vowels.add('o');
//            vowels.add('u');
//
//            for (int i = 0; i < word.length(); i++) {
//                char x = word.charAt(i);
//                if (Character.isLetter(x) && !vowels.contains(x)) {
//                    count++;
//                }
//            }
//            return count;
//        }
//
//        public static void main(String[] args) {
//            String inputWord = "Attraction";
//            int consonantCount = getNumberOfConsonants(inputWord);
//            System.out.println("Number of consonants: " + consonantCount);
//        }
//    }

//    public static void main(String[] args) {
//        System.out.println(getNumbersOfConsonants("   AttractioN   "));//6
//        System.out.println(getNumbersOfConsonants("A$ttraction"));//-1
//        System.out.println(getNumbersOfConsonants("budjet"));//4
//    }
}
//        String word = null;
//        int res = getNumbersOfConsonants(String word);
//        word = "anna";
//
//        if (res == -1) {
//            System.out.println("This word contains non-alphabetic characters.");
//        } else {
//            System.out.println("Number of  consonants: " + res);
//        }
//    }

