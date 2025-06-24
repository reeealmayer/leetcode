import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDiff {
    public static int[][] divideArray(int[] nums, int k) {
        if (nums.length == 0 || nums.length % 3 != 0) {
            return new int[][] {};
        }

        Arrays.sort(nums);

        int[][] result = new int[nums.length / 3][];
        int row = 0;

        for (int i = 0; i < nums.length - 2; i += 3) {
            if (nums[i + 2] - nums[i] <= k ) {
                result[row] = new int[] {nums[i], nums[i + 1], nums[i + 2]};
                row++;
            } else {
                return new int[][] {};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = Arrays.deepToString(divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2));
        System.out.println(result);
    }
}
