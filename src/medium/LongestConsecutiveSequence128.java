package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> digits = new HashSet<>();
        int result = 0;
        int currentLength;

        for (int num : nums) {
            digits.add(num);
        }

        for (int num : digits) {
            if (!digits.contains(num - 1)) {
                int currentNum = num;
                currentLength = 1;
                while (digits.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                result = Math.max(currentLength, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
}
