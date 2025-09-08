package easy;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers1317 {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int b = n - i;
            if (isNoZero(b) && isNoZero(i)) {
                return new int[]{b, i};
            }
        }
        return new int[]{};
    }

    private boolean isNoZero(int a) {
        while (a > 0) {
            if (a % 10 == 0) {
                return false;
            }
            a /= 10;
        }
        return true;
    }
}
