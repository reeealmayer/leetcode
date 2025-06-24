public class ManhattanDistance {
    public int maxDistance(String s, int k) {
        return Math.max(
                Math.max(calc(s, k, 'N', 'E'), calc(s, k, 'N', 'W')),
                Math.max(calc(s, k, 'S', 'E'), calc(s, k, 'S', 'W'))
        );
    }

    private int calc(String s, int k, char a, char b) {
        int mx = 0, ans = 0, used = 0;
        for (char c : s.toCharArray()) {
            if (c == a || c == b) {
                mx++;
            } else if (used < k) {
                used++;
                mx++;
            } else {
                mx--;
            }
            ans = Math.max(ans, mx);
        }
        return ans;
    }
}
