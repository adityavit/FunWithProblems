package interviewbit.dynamicProgramming.interleavingStrings;

/**
 * https://leetcode.com/problems/interleaving-string/
 * https://www.interviewbit.com/problems/interleaving-strings/
 * Created by adib on 11/4/16.
 */
public class Solution {

    /**
     * So, I was able to solve this problem without any help.
     * But the solution i came up was sub optimal.
     * And it was much harder to think of DP in 3D array so took a lot of time.
     * Time compleixy = ( len1 * len2 * len3)
     * space complexity = ( len1 * len2 * len3) which can reduced further to (len1 * len2).
     * So there is an easier solution, which runs in O(len1 * len2) and takes space O(len1 * len2) which can be reduced further to O(len1).
     * @param str1
     * @param str2
     * @param str3
     * @return
     * @accepted
     */
    public int isInterleave(String str1, String str2, String str3) {
        if (str1 == null && str2 == null && str3 == null)
            return 1;
        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();
        int[][][] dp = new int[len1 + 1][len2 + 1][len3 + 1];
        dp[0][0][0] = 1;
        // when str3 = "" or k = 0;
        for(int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                dp[i][j][0] = 0;
            }
        }
        //when str1 = "" or i = 0;
        for (int j = 1; j < len2 + 1; j++) {
            for (int k = 1; k < len3 + 1; k++) {
                if (str2.charAt(j - 1) == str3.charAt(k - 1)) {
                    dp[0][j][k] = dp[0][j - 1][k - 1];
                } else {
                    dp[0][j][k] = 0;
                }
            }
        }
        //when str2 = "" or j = 0;
        for (int i = 1; i < len1 + 1; i++) {
            for (int k = 1; k < len3 + 1; k++) {
                if (str1.charAt(i - 1) == str3.charAt(k - 1)) {
                    dp[i][0][k] = dp[i - 1][0][k - 1];
                } else {
                    dp[i][0][k] = 0;
                }
            }
        }
        for (int k = 1; k < len3 + 1; k++ ) {
            for (int i = 1; i < len1 + 1; i++ ) {
                for ( int j = 1; j < len2 + 1; j++ ) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i - 1) == str3.charAt(k - 1)) {
                        //chars are same at i and j and k
                        // Then either use character at i or character at j
                        dp[i][j][k] = dp[i - 1][j][k - 1] | dp[i][j - 1][k - 1];
                        continue;
                    }
                    if (str1.charAt(i - 1) == str3.charAt(k - 1)) {
                        // only i character matches the kth character then.
                        // then match the rest with the j
                        dp[i][j][k] = dp[i - 1][j][k - 1];
                        continue;
                    }
                    if (str2.charAt(j - 1) == str3.charAt(k - 1)) {
                        // only matches the j character with the k the character
                        // then match the rest with the i
                        dp[i][j][k] = dp[i][j - 1][k - 1];
                        continue;
                    }
                    dp[i][j][k] = 0;
                }
            }
        }
        return dp[len1][len2][len3];
    }
}
