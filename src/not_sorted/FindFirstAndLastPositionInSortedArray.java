package not_sorted;

import java.util.stream.Stream;

public class FindFirstAndLastPositionInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int last = findLast(nums, target);
        int first = findFirst(nums, target);

        return new int[] {first, last};
    }

    private static int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 2, 3};
        int[] x = searchRange(ints, 2);
        Stream.of(x).forEach(System.out::println);

    }
}
