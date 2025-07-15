package not_sorted;

import java.util.Arrays;

public class NumOfSubSeq {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;

        // Предрасчёт степеней двойки
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
