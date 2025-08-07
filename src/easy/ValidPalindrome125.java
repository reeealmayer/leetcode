package easy;

public class ValidPalindrome125 {
    public static boolean isPalindrome(String s) {
        StringBuilder alphabeticString = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                alphabeticString.append(Character.toLowerCase(c));
            }
        }

        int left = 0;
        int right = alphabeticString.length() - 1;

        while (right >= left) {
            if (alphabeticString.charAt(left) != alphabeticString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("qweswq"));
    }
}
