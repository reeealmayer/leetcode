package not_sorted;

import java.util.HashSet;
import java.util.Set;

public class FindTheOriginalTypedString {
    public int possibleStringCount(String word) {
        Set<String> result = new HashSet<>();
        int n = word.length();

        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && word.charAt(i) == word.charAt(j)) {
                j++;
            }

            int len = j - i;

            if (len >= 2) {
                // Сжимаем от 1 до len-1 символов этой группы
                for (int k = 1; k < len; k++) {
                    String compressed = word.substring(0, i) + repeatChar(word.charAt(i), k) + word.substring(j);
                    result.add(compressed);
                }
            }

            i = j;
        }

        result.add(word); // случай, если Алиса не зажимала ничего

        return result.size();
    }

    private String repeatChar(char ch, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) sb.append(ch);
        return sb.toString();
    }
}
