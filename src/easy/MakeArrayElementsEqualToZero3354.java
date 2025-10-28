package easy;

public class MakeArrayElementsEqualToZero3354 {
    public static void main(String[] args) {

    }

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (simulate(nums.clone(), i, 1)) {
                    count++;
                }
                if (simulate(nums.clone(), i, -1)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean simulate(int[] arr, int start, int dir) {
        int n = arr.length;
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir *= -1;
                curr += dir;
            }
        }

        for (int element : arr) {
            if (element != 0) {
                return false;
            }
        }
        return true;
    }
}
