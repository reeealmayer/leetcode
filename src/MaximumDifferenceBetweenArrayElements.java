public class MaximumDifferenceBetweenArrayElements {
    public static int maxAdjacentDistance(int[] nums) {
        int result = Math.abs(nums[0] - nums[nums.length - 1]);

        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.max(result, Math.abs(nums[i + 1] - nums[i]));
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{-2, 1, -5}));
    }
}
