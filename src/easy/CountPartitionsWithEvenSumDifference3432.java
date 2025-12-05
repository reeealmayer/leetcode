package easy;

import java.util.Arrays;

public class CountPartitionsWithEvenSumDifference3432 {
    public static int countPartitions(int[] nums) {
        int result = 0;
        int leftSum = nums[0];
        int rightSum = sum(Arrays.copyOfRange(nums, 1, nums.length));
        for (int i = 0; i < nums.length - 1; i++) {
            if ((leftSum - rightSum) % 2 == 0) {
                result++;
            }
            leftSum += nums[i];
            rightSum -= nums[i];
            System.out.println(leftSum + " - " + rightSum + " = " + (leftSum - rightSum));
        }

        return result;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{1, 2, 2}));
    }
}
