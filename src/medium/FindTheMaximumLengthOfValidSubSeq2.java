package medium;

public class FindTheMaximumLengthOfValidSubSeq2 {
    public int maximumLength(int[] nums, int k) {
        int res = 2;

        for (int j = 0; j < k; j++) {
            int[] dp = new int[k];

            for (int num : nums) {
                int mod = num % k;
                int pos = (j - mod + k) % k;
                dp[mod] = dp[pos] + 1;
            }

            for (int val : dp) {
                res = Math.max(res, val);
            }
        }

        return res;
    }
}
