package stockProblem;

/**
 * Created by adib on 6/14/15.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int buy, sell, maxProfit, diffSoFar;
        if(prices.length ==0 || prices.length == 1)
            return 0;
        //start the first pointer at first index;
        buy =0;
        //start second pointer and the second index;
        sell = 1;
        maxProfit = 0;
//iterate over the elements;
        while(sell<prices.length) {
            diffSoFar = prices[sell] - prices[buy];
            if(diffSoFar > maxProfit)
                maxProfit = diffSoFar;
            //Found a price smaller than what is there in i
            if(diffSoFar < 0)
                buy = sell;
            sell++;
        }
        return maxProfit;
    }

    public int maxProfitNaive(int[] prices) {
        int buy, sell, maxProfit, diffSofar;
        maxProfit = 0;
        for(buy = 0; buy < prices.length-1; buy++){
            for(sell = buy + 1; sell < prices.length; sell++) {
                diffSofar = prices[sell] - prices[buy];
                if(diffSofar > maxProfit)
                    maxProfit = diffSofar;
            }
        }
        return maxProfit;
    }
}
