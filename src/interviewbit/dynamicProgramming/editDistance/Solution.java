package interviewbit.dynamicProgramming.editDistance;

/**
 * https://www.interviewbit.com/problems/edit-distance/
 * https://leetcode.com/problems/edit-distance/
 * Wrote the wrong solution initially didn't create the recurrence equation properly.
 *
 * After i got the wrong answer corrected the equation.
 * Basically the point i didn't consider initially was if the char at i in a and j in b are not same,
 * then you can replace as well as delete or add the character.
 * Also you have to consider another row for empty string. so array should be of size aLen + 1, bLen + 1
 *
 * So recurrence equation comes out to be.
 * if for i ,j a.charAt(i) == b.charAt(j)
 * dp[i]j] = dp[i-1][j-1] // as the characters are same no operation is required here. Just take the solution which doesn't have both the characters.
 * if for i, j a.charAt(i) != b.charAt(j), then one of the operations is required so take the minimum of them.
 * dp[i][j] = 1 + min(dp[i-1][j-1], dp[i - 1][j], dp[i][j - 1])
 *
 * dp[i-1][j-1] (replace operation)
 * dp[i - 1][j] (deleted the char from i)
 * dp[i][j - 1] (added a character to i ,so now the j character of b matches so take j - 1)
 *
 * Created by adib on 11/2/16.
 */
public class Solution {
    public int minDistance(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        dp[0][0] = 0;
        for( int j = 1; j < bLen + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < aLen + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    //If both the characters are same.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //If both the strings are not same then min of the replace, deletion or addition operation.
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[aLen][bLen];
    }
}
