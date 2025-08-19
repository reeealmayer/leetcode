package medium;

public class NumberOfZeroFilledSubarrays2348 {
    public static long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int streak = 0;
        for (int num : nums) {
            streak = (num == 0) ? streak + 1 : 0;
            result += streak;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));
    }
}
