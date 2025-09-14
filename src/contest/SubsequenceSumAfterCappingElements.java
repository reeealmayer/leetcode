//package contest;
//
//import java.util.Arrays;
//import java.util.BitSet;
//
//public class SubsequenceSumAfterCappingElements {
//    public static boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
//        int n = nums.length;
//        boolean[] answers = new boolean[n];
//
//        for (int x = 1; x <= n; x++) {
//            int[] capped = new int[n];
//            for (int i = 0; i < n; i++) {
//                capped[i] = Math.min(nums[i], x);
//            }
//
//            BitSet dp = new BitSet(k + 1);
//            dp.set(0); // сумма 0 достижима
//
//            for (int val : capped) {
//                // сдвигаем битсет на val и делаем OR
//                BitSet shifted = dp.get(0, k + 1);
//                shifted.shiftLeft(val); // тут нужен кастомный сдвиг
//                dp.or(shifted);
//            }
//
//            answers[x - 1] = dp.get(k);
//        }
//
//        return answers;
//    }
//
//    private static BitSet shiftLeft(BitSet bs, int shift) {
//        BitSet res = new BitSet();
//        for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
//            res.set(i + shift);
//            if (i + shift == Integer.MAX_VALUE) break; // защита от переполнения
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(subsequenceSumAfterCapping(new int[]{4, 3, 2, 4}, 5)));
//    }
//}
