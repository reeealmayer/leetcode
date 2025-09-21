package contest;

import java.util.Arrays;

public class BitwiseOROfEvenNumbersInAnArray {
    public static int evenNumberBitwiseORs(int[] nums) {
//        int result = -1;
//        for (int num : nums) {
//            if (num % 2 == 0) {
//                if (result == -1) {
//                    result = num;
//                } else {
//                    result = result | num;
//                }
//            }
//        }
//
//        return result == -1 ? 0 : result;
        return Arrays.stream(nums).filter(a -> a % 2 == 0).reduce(0, (a, b) -> a | b);
    }

    public static void main(String[] args) {
        System.out.println(evenNumberBitwiseORs(new int[]{1, 8, 16}));
    }
}
