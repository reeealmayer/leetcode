public class SumOfKMirrorNumbers {
    public long kMirror(int k, int n) {
        long sum = 0;
        int found = 0;

        for (int len = 1; ; len++) {
            // диапазон "половинки" числа
            int start = (int) Math.pow(10, (len - 1) / 2);
            int end = (int) Math.pow(10, (len + 1) / 2);

            for (int half = start; half < end; half++) {
                long pal = makePalindrome(half, len % 2 == 1);
                if (isPalindromeInBase(pal, k)) {
                    sum += pal;
                    if (++found == n) return sum;
                }
            }
        }
    }

    private long makePalindrome(int half, boolean oddLength) {
        long pal = half;
        int x = oddLength ? half / 10 : half;
        while (x > 0) {
            pal = pal * 10 + (x % 10);
            x /= 10;
        }
        return pal;
    }

    private boolean isPalindromeInBase(long num, int k) {
        StringBuilder sb = new StringBuilder();
        long t = num;
        while (t > 0) {
            sb.append((char)('0' + (t % k)));
            t /= k;
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
