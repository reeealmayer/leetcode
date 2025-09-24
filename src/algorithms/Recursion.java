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

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);

            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printN(int n) {
        System.out.print(n + " ");
        if (n == 1) {
            return;
        }

        printN(n - 1);
    }

    private static void printNModified(int a, int b) {
        System.out.println(a);
        if (a == b) {
            return;
        }
        if (a < b) {
            printNModified(a + 1, b);
        } else {
            printNModified(a - 1, b);
        }
    }

    private static void isPowOfTwo(int n) {
        if (n == 1) {
            System.out.println("YES");
            return;
        }

        if (n == 0 || n % 2 != 0) {
            System.out.println("NO");
            return;
        }

        isPowOfTwo(n / 2);
    }

    private static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }

        return (n % 10) + sumOfDigits(n / 10);
    }

    private static void printDigitsInReversedOrder(int n) {
        System.out.println(n % 10);
        if (n < 10) {
            return;
        }

        printDigitsInReversedOrder(n / 10);
    }

    private static void printDigitsInNaturalOrder(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigitsInNaturalOrder(n / 10);
        System.out.println(n % 10);
    }


    public static void main(String[] args) {
//        countDown(10);
//        System.out.println();
//        System.out.println(factorial(5));
//
//        int[] nums = {10, 7, 8, 9, 1, 5};
//        quickSort(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
//        printNModified(5, 1);
//        isPowOfTwo(10);
//        System.out.println(sumOfDigits(123));
//        printDigitsInReversedOrder(1234);
        printDigitsInNaturalOrder(123);
    }
}
