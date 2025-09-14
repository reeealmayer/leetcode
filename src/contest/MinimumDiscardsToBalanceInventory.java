package contest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumDiscardsToBalanceInventory {
    public static int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int discarded = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        Queue<Integer> window = new LinkedList<>(); // храним элементы окна

        for (int i = 0; i < arrivals.length; i++) {
            int type = arrivals[i];

            // Проверяем: можно ли оставить предмет?
            if (freq.getOrDefault(type, 0) >= m) {
                discarded++; // выбросили
            } else {
                freq.put(type, freq.getOrDefault(type, 0) + 1);
                window.add(type);
            }

            // Если окно превысило размер w, удаляем самый старый элемент
            if (window.size() > w) {
                int oldType = window.poll();
                freq.put(oldType, freq.get(oldType) - 1);
                if (freq.get(oldType) == 0) {
                    freq.remove(oldType);
                }
            }
        }

        return discarded;
    }

    public static void main(String[] args) {

    }
}
