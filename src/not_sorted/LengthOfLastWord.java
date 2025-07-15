package not_sorted;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpace = s.lastIndexOf(' ');
        return s.length() - lastSpace - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Today is a nice day"));
    }
}
