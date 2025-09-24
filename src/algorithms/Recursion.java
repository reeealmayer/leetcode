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

    public static int binarySearch(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    public static int search(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return search(arr, target, left, mid - 1);
        } else {
            return search(arr, target, mid + 1, right);
        }
    }


    public static void main(String[] args) {
        countDown(10);
        System.out.println();
        System.out.println(factorial(5));
    }
}
