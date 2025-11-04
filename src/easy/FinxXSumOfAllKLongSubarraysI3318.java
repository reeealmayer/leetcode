package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinxXSumOfAllKLongSubarraysI3318 {
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            // Считаем частоты элементов в окне
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Сортируем по частоте ↓, затем по значению ↓
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
            list.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue(); // частота
                } else {
                    return b.getKey() - a.getKey();     // значение
                }
            });

            // Берем top x и суммируем их с учетом количества вхождений
            int sum = 0;
            for (int j = 0; j < Math.min(x, list.size()); j++) {
                Map.Entry<Integer, Integer> e = list.get(j);
                sum += e.getKey() * e.getValue();
            }

            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
