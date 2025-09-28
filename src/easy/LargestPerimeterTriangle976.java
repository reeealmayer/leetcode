package easy;

import java.util.Arrays;

public class LargestPerimeterTriangle976 {
    public static int largestPerimeter(int[] nums) {
        int perimeter = 0;

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i] + nums[i - 1] > nums[i - 2]
                    && nums[i] + nums[i - 2] > nums[i - 1]
                    && nums[i - 2] + nums[i - 1] > nums[i]) {
                perimeter = Math.max(perimeter, nums[i] + nums[i - 1] + nums[i - 2]);
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{1, 2, 1, 10}));
    }
}
