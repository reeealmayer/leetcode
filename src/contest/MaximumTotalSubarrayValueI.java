package contest;

import java.util.Arrays;

public class MaximumTotalSubarrayValueI {
    public static long maxTotalValue(int[] nums, int k) {
        int diff = Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt();
        return (long) diff * k;
    }

    public static void main(String[] args) {
        System.out.println(maxTotalValue(new int[]{4,2,5,1}, 3));
    }
}
