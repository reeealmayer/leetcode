package not_sorted;

public class MaxFreeTime {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int ans = 0, sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += gaps[i];
            if (i >= k) {
                ans = Math.max(ans, sum);
                sum -= gaps[i - k];
            }
        }
        return ans;
    }
}
