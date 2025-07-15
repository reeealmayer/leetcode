package not_sorted;

import java.util.*;

public class FindAllKIndicesInAnArray {
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(n - 1, i + k);
                for (int j = start; j <= end; j++) {
                    marked[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (marked[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> kDistantIndices = findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1);
        System.out.println(kDistantIndices.toString());
    }
}
