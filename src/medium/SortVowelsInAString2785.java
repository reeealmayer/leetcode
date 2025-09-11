package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortVowelsInAString2785 {
    public static String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);

        StringBuilder result = new StringBuilder();

        int idx = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(idx++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static boolean isVowel(Character c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> vowelToPosition = new HashMap<>();

        vowelToPosition.put('a', 2);
        vowelToPosition.put('a', 3);

        System.out.println(vowelToPosition);
    }
}
