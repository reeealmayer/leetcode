package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        Set<Character> uniqueCharacters = new HashSet<>();
        while (right < s.length()) {
            if (!uniqueCharacters.contains(s.charAt(right))) {
                uniqueCharacters.add(s.charAt(right));
                result = Math.max(uniqueCharacters.size(), result);
                right++;
            } else {
                char c = s.charAt(left);
                uniqueCharacters.remove(c);
                left++;
            }
        }
        return result;
    }
}
