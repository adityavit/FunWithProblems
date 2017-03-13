package stockProblem;

import java.util.PriorityQueue;

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
            //Found a buy price smaller than what is there in current buy
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

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * @param prices
     * @return
     */
    public int maxProfitNTransactions(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        int totalProfit = 0;
        int buy = 0; // Initial Index.
        int sell = 1; //Initial Sell Index.
        int profitSoFar = 0;
        while(sell < prices.length) {
            int profit = prices[sell] - prices[buy];
            if (profit > profitSoFar) {
                profitSoFar = profit;
            }
            if (profit < profitSoFar) {
                totalProfit += profitSoFar;
                profitSoFar = 0;
                buy = sell;
            }
            sell++;
        }
        return totalProfit + profitSoFar;
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
     * @param prices
     * @return
     */
    public int maxProfitAtmost2Transactions(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        int totalProfit = 0;
        int buy = 0; // Initial Index.
        int sell = 1; //Initial Sell Index.
        int profitSoFar = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(2);
        while(sell < prices.length) {
            int profit = prices[sell] - prices[buy];
            if (profit > profitSoFar) {
                profitSoFar = profit;
            }
            if (profit < profitSoFar) {
                if(minHeap.size() < 2) {
                    minHeap.add(profitSoFar);
                }else {
                    if(minHeap.peek() < profitSoFar) {
                        minHeap.poll();
                        minHeap.add(profitSoFar);
                    }
                }
                profitSoFar = 0;
                buy = sell;
            }
            sell++;
        }
        if(minHeap.size() < 2) {
            minHeap.add(profitSoFar);
        }else {
            if(minHeap.peek() < profitSoFar) {
                minHeap.poll();
                minHeap.add(profitSoFar);
            }
        }
        for(Integer profits: minHeap) {
            totalProfit+= profits;
        }
        return totalProfit;
    }

    public int maxProfitStockProblemTwo(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        int[] maxProfitResult = new int[prices.length];
        maxProfitResult[prices.length - 1] = 0;
        for(int i = prices.length - 2 ; i >= 0 ; i--) {
            maxProfitResult[i] = Math.max(prices[i+1] - prices[i] + maxProfitResult[i+1], maxProfitResult[i+1]);
        }
        return maxProfitResult[0];
    }
}
//
//    public int maxProfitNTrasaction(int[] prices){
//
//    }
