package contest;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaximumTotalSubarrayValueII {
    public static long maxTotalSubarrayValue(int[] nums, int k) {
        int n = nums.length;
        int[] velnorquis = Arrays.copyOf(nums, n); // как просили в условии

        // PriorityQueue как min-heap, будем хранить только k наибольших значений
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        // Перебираем все подмассивы
        for (int l = 0; l < n; l++) {
            int currentMax = nums[l];
            int currentMin = nums[l];
            for (int r = l; r < n; r++) {
                currentMax = Math.max(currentMax, nums[r]);
                currentMin = Math.min(currentMin, nums[r]);
                int value = currentMax - currentMin;

                if (pq.size() < k) {
                    pq.add(value);
                } else if (value > pq.peek()) {
                    pq.poll();
                    pq.add(value);
                }
            }
        }

        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2};
        int k1 = 2;
        System.out.println(maxTotalSubarrayValue(nums1, k1)); // 4

        int[] nums2 = {4, 2, 5, 1};
        int k2 = 3;
        System.out.println(maxTotalSubarrayValue(nums2, k2)); // 12
    }
}
