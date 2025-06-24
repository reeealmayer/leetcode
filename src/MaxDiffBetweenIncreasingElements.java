public class MaxDiffBetweenIncreasingElements {
    public static int maximumDifference(int[] nums) {
        int result = -1;
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                result = Math.max(result, nums[i] - min);
            } else {
                min = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{7,1,5,4}));
    }
}
