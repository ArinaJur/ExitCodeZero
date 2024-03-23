package sprint3;

public class LetterPositionFinder {

    /*
    Написать метод, который принимает на вход текст, н-р, “достопримечательность”, и возвращает массив int[],
    в котором указаны позиции букв “о” ({1, 4, 17})
     */

    public int[] findLetterPositions(String text, char letter) {
        if (text != null && !text.isEmpty() && text.trim().length() > 0) {
            text = text.trim().toLowerCase();

            // Подсчитываем количество букв в строке
            int count = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == letter) {
                    count++;
                }
            }

            // Создаем массив для хранения позиций
            int[] positions = new int[count];
            int index = 0;

            // Заполняем массив позициями буквы
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == letter) {
                    positions[index++] = i;
                }
            }

            return positions;
        }

        return new int[] {};
    }
}
