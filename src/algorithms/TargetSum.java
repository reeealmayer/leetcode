package algorithms;

public class TargetSum {
    public static boolean canReachTarget(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    public static boolean dfs(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            return currentSum == target;
        }

        if (dfs(nums, index + 1, currentSum + nums[index], target)) {
            return true;
        }

        if (dfs(nums, index + 1, currentSum - nums[index], target)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReachTarget(new int[] {9, 7, 3}, 14));
    }
}
