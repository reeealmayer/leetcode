package easy;

public class TheTwoSneakyNumbersOfDigitville3289 {
    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[2];
        int[] digitsToCount = new int[100];

        for (int num : nums) {
            digitsToCount[num] += 1;
        }

        int k = 0;
        for (int i = 0; i < digitsToCount.length; i++) {
            if (digitsToCount[i] == 2) {
                result[k++] = i;
            }
        }
        return result;
    }
}
