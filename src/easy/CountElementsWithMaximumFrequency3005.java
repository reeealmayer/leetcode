package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountElementsWithMaximumFrequency3005 {
    public static int maxFrequencyElements(int[] nums) {
//        int maxFrequency = Integer.MIN_VALUE;
//        Map<Integer, Integer> digitToFrequency = new HashMap<>();
//        int result = 0;
//
//        for (int num : nums) {
//            int currentFrequency = digitToFrequency.getOrDefault(num, 0) + 1;
//            maxFrequency = Math.max(currentFrequency, maxFrequency);
//            digitToFrequency.put(num, currentFrequency);
//        }
//
//        Set<Map.Entry<Integer, Integer>> entries = digitToFrequency.entrySet();
//
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            if (entry.getValue() == maxFrequency) {
//                result += entry.getValue();
//            }
//
//        }
//
//
//        return result;
        byte[] numFrequencies = new byte[101];
        byte max = 0;
        int result = 0;

        for (int n : nums) {
            byte f = ++numFrequencies[n];
            if (f > max) {
                max = f;
                result = f;
            } else if (f == max) {
                result += f;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));
    }
}
