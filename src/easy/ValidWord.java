package easy;

public class ValidWord {
    public static final String VOWELS = "AEIOUaeiou";

    public static boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (VOWELS.indexOf(ch) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return hasVowel && hasConsonant;
    }

    public static void main(String[] args) {
        System.out.println(isValid("xaas;"));
    }
}
