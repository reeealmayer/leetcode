package easy;

public class SmallestNumberWithAllSetBits3370 {
    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
    }

    public static int smallestNumber(int n) {
        int x = 1;
        while (x < n) {
            x = x * 2 + 1;
        }

        return x;
    }
}
