package stockProblem;

/**
 * Created by adib on 6/14/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] stockPrices = {20, 8, 10, 30, 15, 40, 7, 50};
        //Max Profit in case of atmost one transaction.
        int maxProfit = sol.maxProfit(stockPrices);
        System.out.println("maxProfit = " + maxProfit);

        // Max Profit Naive way.
        int maxProfitNaive = sol.maxProfitNaive(stockPrices);
        System.out.println("maxProfitNaive = " + maxProfitNaive);
    }
}
