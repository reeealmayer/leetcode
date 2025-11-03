package medium;

public class MinimumTimeToMakeRopeColorful1578 {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                total += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return total;
    }
}
