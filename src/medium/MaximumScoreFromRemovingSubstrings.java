package medium;

public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        // Определяем порядок удаления: сначала удаляем более дорогую подстроку
        if (y > x) {
            return process(s, y, x, "ba", "ab");
        } else {
            return process(s, x, y, "ab", "ba");
        }
    }

    private int process(String s, int bigReward, int smallReward, String bigString, String smallString) {
        int result = 0;
        StringBuilder sb = new StringBuilder();

        // Первый проход: удаляем все вхождения более дорогой подстроки
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == bigString.charAt(0) && c == bigString.charAt(1)) {
                sb.deleteCharAt(len - 1); // удаляем первую букву пары
                result += bigReward;
            } else {
                sb.append(c);
            }
        }

        // Второй проход: удаляем оставшиеся подстроки (менее приоритетные)
        StringBuilder finalSb = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            int len = finalSb.length();
            if (len > 0 && finalSb.charAt(len - 1) == smallString.charAt(0) && c == smallString.charAt(1)) {
                finalSb.deleteCharAt(len - 1);
                result += smallReward;
            } else {
                finalSb.append(c);
            }
        }

        return result;
    }


    public static void main(String[] args) {
    }
}
