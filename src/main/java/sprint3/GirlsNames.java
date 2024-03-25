package sprint3;
//Написать метод, который принимает на вход массив популярных имен для девочек, и массив реальных имен девочек по
//статистике за 1 месяц. Метод возвращает количество раз, когда девочки были названы непопулярными именами

public class GirlsNames {
    public int gilsNames(String[] popularNamesArray, String[] statisticsNames) {
        int count = 0;
        for (int i = 0; i < statisticsNames.length; i++) {
            int countPopular = 0;
            for (int j = 0; j < popularNamesArray.length; j++) {
                if (statisticsNames[i].equals(popularNamesArray[j])) {
                     countPopular++;
                     break;
                }
            }
            if (countPopular == 0) {
               count++;
            }

        }

        return count;
    }
}
