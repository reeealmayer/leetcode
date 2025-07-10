public class MaxFreeTime2 {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n+1];
        gaps[0] = startTime[0];
        for (int i=1; i<n; i++) {
            gaps[i] = startTime[i] - endTime[i-1];
        }
        gaps[n] = eventTime - endTime[n-1];

        int[] maxLeft = new int[n+1], maxRight = new int[n+1];
        maxLeft[0] = gaps[0];
        for (int i=1; i<=n; i++) maxLeft[i] = Math.max(maxLeft[i-1], gaps[i]);
        maxRight[n] = gaps[n];
        for (int i=n-1; i>=0; i--) maxRight[i] = Math.max(maxRight[i+1], gaps[i]);

        int ans = 0;
        for (int i=0; i<n; i++) {
            int leftGap = gaps[i];
            int rightGap = gaps[i+1];
            int dur = endTime[i] - startTime[i];

            int bestOtherGap = 0;
            if (i-1 >= 0) bestOtherGap = Math.max(bestOtherGap, maxLeft[i-1]);
            if (i+2 <= n) bestOtherGap = Math.max(bestOtherGap, maxRight[i+2]);

            int interval = (dur <= bestOtherGap) ? dur : 0;
            ans = Math.max(ans, leftGap + interval + rightGap);
        }
        return ans;
    }
}
