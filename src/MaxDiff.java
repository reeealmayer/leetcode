public class MaxDiff {
    public int maxDiff(int num) {
        String s = String.valueOf(num);

        // --------- Получаем максимум (замена на 9) ---------
        char[] maxChars = s.toCharArray();
        char targetMax = 0;
        for (char c : maxChars) {
            if (c != '9') {
                targetMax = c;
                break;
            }
        }

        for (int i = 0; i < maxChars.length; i++) {
            if (maxChars[i] == targetMax) {
                maxChars[i] = '9';
            }
        }
        int a = Integer.parseInt(new String(maxChars));

        // --------- Получаем минимум (замена на 1 или 0) ---------
        char[] minChars = s.toCharArray();
        char targetMin = 0;

        if (minChars[0] != '1') {
            targetMin = minChars[0];
            for (int i = 0; i < minChars.length; i++) {
                if (minChars[i] == targetMin) {
                    minChars[i] = '1';
                }
            }
        } else {
            // ищем первую цифру ≠ 0 или 1 для замены на 0
            for (int i = 1; i < minChars.length; i++) {
                if (minChars[i] != '0' && minChars[i] != '1') {
                    targetMin = minChars[i];
                    for (int j = 1; j < minChars.length; j++) {
                        if (minChars[j] == targetMin) {
                            minChars[j] = '0';
                        }
                    }
                    break;
                }
            }
        }

        int b = Integer.parseInt(new String(minChars));
        return a - b;
    }
}
