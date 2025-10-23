package easy;

public class CheckIfDigitsAreEqualInStringAfterOperationsI3461 {
    public static boolean hasSameDigits(String s) {
        if (s.length() < 2) {
            return false;
        }
        StringBuilder tempo = new StringBuilder();
        while (s.length() > 2) {
            for (int i = 0; i < s.length() - 1; i++) {
                int i1 = ((s.charAt(i) - '0') + (s.charAt(i + 1) - '0')) % 10;
                tempo.append(i1);
            }
            s = tempo.toString();
            tempo = new StringBuilder();
        }

        return s.charAt(0) - '0' == s.charAt(1) - '0';
    }

    public static void main(String[] args) {
        System.out.println(hasSameDigits("34789"));
    }
}
