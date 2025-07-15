package not_sorted;

import java.util.ArrayList;
import java.util.List;

public class MinimumDeletions {
    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        List<Integer> nums = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) nums.add(f);
        }

        int ans = n;
        for (int v = 0; v <= n; v++) {
            int deletions = 0;
            for (int x : nums) {
                if (x < v) deletions += x;
                else if (x > v + k) deletions += x - (v + k);
            }
            ans = Math.min(ans, deletions);
        }
        return ans;
    }
}
