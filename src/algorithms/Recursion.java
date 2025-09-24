package algorithms;

public class Recursion {

    public static void countDown(int n) {
        System.out.print(n + " ");
        if (n == 0) {
            return;
        }
        countDown(n - 1);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * (factorial(n - 1));
        }
    }

    public static int sum(int[] array, int n) {
        if (n == 0) {
            return 0;
        }
        return array[n - 1] + sum(array, n - 1);
    }

    public static int findMax(int[] array, int n) {
        if (n == 0) {
            return array[0];
        }

        int subMax = findMax(array, n - 1);
        return Math.max(subMax, array[n - 1]);
    }

    public static void main(String[] args) {
        countDown(10);
        System.out.println();
        System.out.println(factorial(5));
    }
}
