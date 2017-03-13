package interviewbit.dynamicProgramming.stockProblemII;

import java.util.List;

/**
 * Created by adib on 11/2/16.
 */
public class Solution {
    public int maxProfit(final List<Integer> stocks) {
        if (stocks.size() == 0 || stocks.size() == 1)
            return 0;
        int buy = 0;
        int sell = 1;
        int profit = 0;
        int maxProfit = 0;
        int len = stocks.size();
        while ( sell < len) {
            if (stocks.get(sell) < stocks.get(sell - 1)) {
                maxProfit += profit;
                profit = 0;
                buy = sell;
            } else {
                profit = stocks.get(sell) - stocks.get(buy);
            }
            sell++;
        }
        maxProfit += profit;
        return maxProfit;
    }
}
