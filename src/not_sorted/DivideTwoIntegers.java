package not_sorted;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        int result = 0;

        while (longDividend >= longDivisor) {
            long temp = longDivisor;
            long multiple = 1;
            while (longDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            longDividend -= temp;
            result += multiple;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide(100, 24));
    }
}
