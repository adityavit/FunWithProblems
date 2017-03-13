package interviewbit.dynamicProgramming.regularExpressionII;

/**
 * https://www.interviewbit.com/problems/regular-expression-ii/
 * https://leetcode.com/problems/regular-expression-matching/
 * Ok this problem is kind of tricky.
 * Although it is based on the LCS kind of solution.
 * To create the recurrence equation for * is not that simple.
 * I solved this problem myself but took so much time to solve it.
 * Created by adib on 11/4/16.
 * @accepted
 */
public class Solution {
    public int isMatch(final String s, final String p) {
        if (s == null && p == null)
            return 1;
        if (s == null || p == null)
            return 0;
        if (s.length() == 0 && p.length() == 0)
            return 1;
        int pLen = p.length();
        int sLen = s.length();
        int[][] dp = new int[pLen + 1][sLen + 1];
        dp[0][0] = 1;
        for (int i = 1; i < sLen + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < pLen + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
                continue;
            }
            dp[i][0] = 0;
        }
        for (int i = 1; i < pLen + 1; i++) {
            for (int j = 1; j < sLen + 1; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.') {
                    //If the charaacter matches.
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if (p.charAt(i - 1) == '*') {
                    if (p.charAt(i - 2) == '.' || p.charAt(i - 2) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i][ j - 1] | dp[i - 2][j];
                    } else {
                        dp[i][j] = dp[i - 2][j];
                    }
                    continue;
                }
                if (p.charAt(i - 1) != s.charAt(j - 1)) {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[pLen][sLen];
    }

    /**
     * https://leetcode.com/problems/regular-expression-matching/
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchLeetCode(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null || p == null)
            return false;
        if (s.length() == 0 && p.length() == 0)
            return true;
        int pLen = p.length();
        int sLen = s.length();
        int[][] dp = new int[pLen + 1][sLen + 1];
        dp[0][0] = 1;
        for (int i = 1; i < sLen + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < pLen + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
                continue;
            }
            dp[i][0] = 0;
        }
        for (int i = 1; i < pLen + 1; i++) {
            for (int j = 1; j < sLen + 1; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.') {
                    //If the charaacter matches.
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if (p.charAt(i - 1) == '*') {
                    if (p.charAt(i - 2) == '.' || p.charAt(i - 2) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i][ j - 1] | dp[i - 2][j];
                    } else {
                        dp[i][j] = dp[i - 2][j];
                    }
                    continue;
                }
                if (p.charAt(i - 1) != s.charAt(j - 1)) {
                    dp[i][j] = 0;
                }
            }
        }
        boolean result = dp[pLen][sLen] == 1? true: false;
        return result;
    }
}
