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


There is another solution to this given here.I have not looked into but looks interesting.

[geek4geeks](http://www.geeksforgeeks.org/maximum-difference-between-two-elements/)


Looking into the problem further and basically solving the problem [Part-2](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

This problem can be visually seen as
```
                |
    |           |
    |       |   |         |
  | |     | |   | |       |
  | |     | |   | | |     |
  | | |   | | | | | |  |  |
| | | |   | | | | | |  |  |
0 1 2 3 4 5 6 7 8 9 10 11 12

```
Here you can think bars as the stock price for example day 0 has a price of 1 and day 5 has a price of 4 and day 4 has zero price. :)

Now this problem is basically finding minimum and maximum of these stock prices.
So i start at day 0 and difference keeps on increasing my profit keeps on increasing. When i reach day 3 then my stock price doesn't increase
any further, so basically i took the stock at day 0 and if i sold at day 2 getting a profit of 5. Then at day 4 stock decreases to 0 below that of
day 1 then i can safely start a new transaction and go till 6 increasing in profit, If these would have been multiple transaction i can break here again.
And from day 7 go up again till 8 <del>or let day 4 go till 8, both will lead same profit.</del>.

Looking for increasing sequeunce is the correct approach. Basically you have to increase the sell value till the profit increases. When the profit decreases,
then that would be the new value. The invariant in this problem is
Lets say a, b, c, d are the four values in the array in that order. Such that a<b  && c<d
So (b-a) + (d-c) > d-a
which leads to b-c > 0 which says whenever b is greater than c then from there starts the new buy value till the profit keeps on increasing. If decreases switch again.

Basically the idea is to look for increasing sequences. In the case of atmost 1 you have to look for just one sequence which will be of maximum diff.
In case of multiple transaction look for all the increasing sequences and add them up to get maximum profit. In case of two atmost look for the two maximum diff
sequence and if you find a one greater than either of two replace the previous one.

So finding at most one is finding diff of global minimum and global maximum.
Finding multiple transaction is finding the sum of all diffs of local minimum and local maximum.

```Java
    public class Solution {
        public int maxProfit(int[] prices) {
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
```