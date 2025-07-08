import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberOfEventsThatCanBeAttended2 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(e -> e[1])); // сортируем по endDay

        int n = events.length;
        int[][] dp = new int[n + 1][k + 1]; // dp[i][j] — макс value, если из первых i событий выбрать <= j

        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) endTimes[i] = events[i][1];

        for (int i = 1; i <= n; i++) {
            int[] event = events[i - 1];
            int start = event[0], end = event[1], value = event[2];

            // ищем индекс последнего события, которое заканчивается ДО начала текущего
            int prevIndex = upperBound(endTimes, start - 1);

            for (int j = 1; j <= k; j++) {
                // максимум между: не брать текущее событие или взять и прибавить value
                dp[i][j] = Math.max(dp[i - 1][j], dp[prevIndex][j - 1] + value);
            }
        }

        return dp[n][k];
    }

    // бинарный поиск: индекс последнего события с endDay < target
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target + 1) {
                res = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
