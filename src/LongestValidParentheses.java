public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            }

            if (right > left) {
                left = 0;
                right = 0;
            }

        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            }

            if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }
}
