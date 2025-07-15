package not_sorted;

public class LongestSubSeqOfBinaryString {
    public int longestSubsequence(String s, int k) {
        int zeros = 0;
        int ones = 0;
        int n = s.length();
        long value = 0;
        long pow = 1;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (value + pow > k) {
                    continue;
                }
                value += pow;
                ones++;
            }
            pow <<= 1;

            if (pow > k) {
                break;
            }
        }
        return ones + zeros;
    }
}
