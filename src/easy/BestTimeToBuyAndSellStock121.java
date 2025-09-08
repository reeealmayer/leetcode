package easy;

public class BestTimeToBuyAndSellStock121 {
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                profit = Math.max(profit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
