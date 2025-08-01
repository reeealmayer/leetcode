package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String tempoString = new String(chars);
            if (!result.containsKey(tempoString)) {
                result.put(tempoString, new ArrayList<>());
            }
            result.get(tempoString).add(s);
        }

        return result.values().stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eaat", "taae", "tan", "ate", "nat", "bat"}));
    }
}
