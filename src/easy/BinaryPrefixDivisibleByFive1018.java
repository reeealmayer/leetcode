package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleByFive1018 {
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            result.add(prefix == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}).stream().forEach(System.out::println);
    }
}
