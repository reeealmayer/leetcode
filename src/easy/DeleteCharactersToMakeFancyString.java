package easy;

public class DeleteCharactersToMakeFancyString {
    public static String makeFancyString(String s) {


        StringBuilder result = new StringBuilder();
        char current = s.charAt(0);
        result.append(current);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
                if (count < 3) {
                    result.append(s.charAt(i));
                }
            } else {
                current = s.charAt(i);
                count = 1;
                result.append(current);
            }

        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
    }
}
