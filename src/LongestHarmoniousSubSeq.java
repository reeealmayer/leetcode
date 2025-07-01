import java.util.HashMap;

public class LongestHarmoniousSubSeq {

    public static int findLHS(int[] nums) {
        int result = 0;

        HashMap<Integer, Integer> digitFreq = new HashMap<>();

        for (int num : nums) {
            digitFreq.put(num, digitFreq.getOrDefault(num, 0) + 1);
        }

        for (int key : digitFreq.keySet()) {
            if (digitFreq.containsKey(key + 1)) {
                int len = digitFreq.get(key) + digitFreq.get(key + 1);
                result = Math.max(result, len);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}
