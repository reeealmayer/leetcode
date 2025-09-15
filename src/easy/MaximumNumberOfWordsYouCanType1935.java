package easy;

public class MaximumNumberOfWordsYouCanType1935 {
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int wordCount = 0;
        for (String word : words) {
            boolean hasBrokenLetters = false;
            for (char c : brokenLetters.toCharArray()) {
                if (word.indexOf(c) != -1) {
                    hasBrokenLetters = true;
                    break;
                }
            }
            if (!hasBrokenLetters) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad"));
    }
}
