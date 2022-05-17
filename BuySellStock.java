//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BuySellStock {
    public static void main(String[] args) {
       int [] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit=0;
        int prev_profit=0;
        int buy=Integer.MIN_VALUE;
        int prev_buy= 0;

        for(int price : prices) {
            prev_buy = buy;
            buy= Math.max(prev_profit-price , prev_buy);
            prev_profit = profit;
            profit= Math.max(prev_buy+price, prev_profit);
        }
        return profit;
    }
}
