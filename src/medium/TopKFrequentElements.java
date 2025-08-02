package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> tempoList = freq.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).map(Map.Entry::getKey).toList().subList(0, k);
        return tempoList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1]) // убывание по частоте
        );

        for (Integer i : freq.keySet()) {
            priorityQueue.add(new int[]{i, freq.get(i)});
        }

        int[] result = new int[Math.min(k, freq.size())];
        for (int i = 0; i < result.length; i++) {
            result[i] = Objects.requireNonNull(priorityQueue.poll())[0];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 3, 4, 5, 6, 6}, 2)));
    }
}
