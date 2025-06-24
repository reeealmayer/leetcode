import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {
    public static int partitionArray(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        if (k == 0) {
            return nums.length - 1;
        }

        int result = 1;

        Arrays.sort(nums);

        int startSub = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - startSub > k) {
                result++;
                startSub = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{2,2,4,5}, 0));
    }
}
