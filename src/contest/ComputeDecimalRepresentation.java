package contest;

import java.util.ArrayList;
import java.util.Arrays;

public class ComputeDecimalRepresentation {
    public static int[] decimalRepresentation(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        int pow = 0;

        while (n != 0) {
            if (n % 10 != 0) {
                result.addFirst(n % 10 * powOfTen(pow));
            }
            pow++;
            n /= 10;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int powOfTen(int k) {
        int result = 1;

        for (int i = 0; i < k; i++) {
            result *= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decimalRepresentation(123)));
        System.out.println(Arrays.toString(decimalRepresentation(102)));
        System.out.println(Arrays.toString(decimalRepresentation(6)));
        System.out.println(Arrays.toString(decimalRepresentation(9999)));
    }
}
