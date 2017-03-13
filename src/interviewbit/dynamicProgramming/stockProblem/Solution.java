package interviewbit.dynamicProgramming.stockProblem;

import java.util.List;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
 * Created by adib on 10/23/16.
 * Calculate the max profit with taking the lowest and the highest value.
 */
public class Solution {

    public int maxProfit(final List<Integer> prices) {
        if (prices == null || prices.size() == 0)
            return 0;
        int minStockPrice = prices.get(0);
        int maxProfit = 0;
        int len = prices.size();
        int i = 1;
        while ( i < len) {
            int price = prices.get(i);
            maxProfit = Math.max(maxProfit, Math.max(price - minStockPrice, 0));
            minStockPrice = Math.min(minStockPrice, price);
            i++;
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int minStockPrice = prices[0];
        int maxProfit = 0;
        int len = prices.length;
        int i = 1;
        while ( i < len) {
            int price = prices[i];
            maxProfit = Math.max(maxProfit, Math.max(price - minStockPrice, 0));
            minStockPrice = Math.min(minStockPrice, price);
            i++;
        }
        return maxProfit;
    }
}
