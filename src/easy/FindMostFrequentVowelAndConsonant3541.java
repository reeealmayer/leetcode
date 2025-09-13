package easy;

public class FindMostFrequentVowelAndConsonant3541 {
    public static int maxFreqSum(String s) {
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        
        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (isVowel(c)) {
                maxVowelFreq = Math.max(maxVowelFreq, chars[i]);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, chars[i]);
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }

    private static boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println(maxFreqSum("aasscc"));
        System.out.println((int) 'b');
    }
}
