package easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!sMap.containsKey(c)) {
                return false;
            }
            sMap.put(c, sMap.get(c) - 1);
            if (sMap.get(c) < 0) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aasst", "asast"));
    }
}
