package easy;

public class PowerOfFour342 {
    public boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        long result = 1;
        for (int i = 1; i < 100; i++) {
            result *= 4;
        }
    }
}
