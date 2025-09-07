package easy;

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero1304 {
    public static int[] sumZero(int n) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; ++i) {
            ans[index++] = i;
            ans[index++] = -i;
        }
        if (n % 2 == 1) {
            ans[index] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(7)));
    }
}
