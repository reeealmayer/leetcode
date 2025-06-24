import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;

            if (isEnough(nums, p, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isEnough(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        return count >= p;
    }
}
