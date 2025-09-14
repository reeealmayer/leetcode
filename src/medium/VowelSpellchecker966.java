package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class VowelSpellchecker966 {
    public static String[] bruteForce(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];

        int resultCount = 0;
        for (String fromQuery : queries) {
            int count = 0;
            int equalPosition = -1;
            int caseSensitiveEqualPosition = -1;
            int maskedEqualPosition = -1;
            for (String fromList : wordlist) {
                if (equalPosition == -1 && Objects.equals(fromQuery, fromList)) {
                    equalPosition = count;
                }

                if (caseSensitiveEqualPosition == -1 && Objects.equals(fromQuery.toLowerCase(), fromList.toLowerCase())) {
                    caseSensitiveEqualPosition = count;
                }

                String maskedFromQuery = fromQuery.replaceAll("(?i)[aeiou]", "*");
                String maskedFromList = fromList.replaceAll("(?i)[aeiou]", "*");
                if (maskedEqualPosition == -1 && Objects.equals(maskedFromList.toLowerCase(), maskedFromQuery.toLowerCase())) {
                    maskedEqualPosition = count;
                }
                count++;

            }
            if (equalPosition != -1) {
                result[resultCount++] = wordlist[equalPosition];
            } else if (caseSensitiveEqualPosition != -1) {
                result[resultCount++] = wordlist[caseSensitiveEqualPosition];
            } else if (maskedEqualPosition != -1) {
                result[resultCount++] = wordlist[maskedEqualPosition];
            } else {
                result[resultCount++] = "";
            }
        }

        return result;
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseSensitive = new HashMap<>();
        Map<String, String> masked = new HashMap<>();

        String[] result = new String[queries.length];

        for (String word : wordlist) {
            exact.add(word);

            caseSensitive.putIfAbsent(word.toLowerCase(), word);

            String maskedWord = mask(word.toLowerCase());
            masked.putIfAbsent(maskedWord, word);
        }

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exact.contains(q)) {
                result[i] = q;
            } else if (caseSensitive.containsKey(q.toLowerCase())) {
                result[i] = caseSensitive.get(q.toLowerCase());
            } else {
                result[i] = masked.getOrDefault(mask(q.toLowerCase()), "");
            }
        }


        return result;
    }

    private static String mask(String s) {
        return s.replaceAll("(?i)[aeiou]", "*");
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(spellchecker(new String[] {"zeo","Zuo"},
                new String[] {"zuo"})));
    }
}
