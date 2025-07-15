package not_sorted;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char c = result.charAt(j);
                if (c == prev) {
                    count++;
                } else {
                    current.append(count).append(prev);
                    count = 1;
                    prev = c;
                }
            }
            current.append(count).append(prev);
            result = current.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(7));
    }
}
