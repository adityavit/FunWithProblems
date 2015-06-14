Stock Buying and selling.

This is an awesome problem, think perfect for the interview.

[Problem](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

If you look at the problem closely, basically you have to find maximum difference between elements a[sell] - a[buy] such that buy < sell.
As you cannot sell a stock before buying.

- A naive way to solve this problem is taking the difference between each element and then take the maximum one. It is not that hard to write the code for that

```Java
    int maxProfitNaive(int[] prices) {
        int buy, sell, maxProfit, diffSofar;
        maxProfit = 0;
        for(buy = 0; buy < prices.length-1; buy++){
            for(sell = buy + 1; sell < prices.length; sell++) {
                diffSofar = prices[sell] - prices[buy];
                if(diffSoFar > maxProfit)
                    maxProfit = diffSofar;
             }
        }
    }
```

It is not hard to see that this an O(n2) algorithm, because for every buy you are iterating over all the remaining elements as sell option.


- A better Solution is slightly more clever. So proud of myself to come up with this one without help :) .
If you are thinking right now that how i came up with this, Dude you have to come up in right state of mind, and it will come. Keep going. :)

Basically the idea is very simple if there is an element which is smaller than the current prices[buy] after buy then difference of that further prices[sell] will be always higher.

 The invariant here is that if there is a price[buy] between price[currentBuy] and price[sell] such that price[buy] < price[currentBuy] then
  price[sell] - price[buy] > price[sell] - price[currentBuy]

  currentBuy ..... buy .... sell

 So based on this idea
 Find the diff between buy and sell by incrementing sell.
 if diff is greater than maxProfit so far than put diff as the maxProfit.
 If diff is negative then you found a buy which is smaller than currentBuy so put that as the currentBuy price.

 It is not hard to see that this is O(n) solution. Iteration is done just once over the array.

