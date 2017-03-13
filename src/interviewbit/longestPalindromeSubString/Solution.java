package interviewbit.longestPalindromeSubString;

/**
 * Created by adib on 9/10/16.
 */
public class Solution {

    /**
     * This solution gets accepted.
     * So you have to just check whether substring within a substring is palindrome or not if the first and the end characters are same.
     * @accepted
     * @param a
     * @return
     */
    public String longestPalindrome(String a) {
        if (a == null || a.length() == 0 || a.length() == 1)
            return a;
        int len = a.length();
        boolean [][] maxSubString = new boolean[len][len];
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int maxLength = 1;
        for ( int i = 0; i < len; i++) {
            maxSubString[i][i] = true;
        }
        for ( int i = 1; i < len; i++) {
            //Have to go diagonally so i represents length of substring.
            for (int j = 0; i + j < len; j++) {

                int start = j;
                int end = i + j;
                if (a.charAt(start) == a.charAt(end) && (i == 1 || maxSubString[start + 1][end - 1])) {
                    maxSubString[start][end] = true;
                    if ( i + 1 > maxLength) {
                        maxLength = i + 1;
                        maxStartIndex = start;
                        maxEndIndex = end;
                    }
                }
            }
        }
        return a.substring(maxStartIndex, maxEndIndex + 1);
    }

    /**
     * Wrote this solution initially. Solution is correct but it give out of memory error in interviewbit and time limit exceeded in leetcode. Although it is O(n^2).
     * Question is why do we need to get maxSubString[start+1][end] and maxSubString[start][end-1]
     * It doesn't get any value, because the value would be already be covered in other case. It is useful in the case of subsequence.
     * Secondly for the sub string you can just to see if the maxSubString[start + 1][end - 1] is palindrome or not if it and a[start]== a[end] then maxSubString[start][end] is also pallindrome else not.
     * The good thing about this is that you can use boolean array.
     * This will lead to less memory.
     * https://www.interviewbit.com/problems/longest-palindromic-substring/
     * https://leetcode.com/articles/longest-palindromic-substring/
     * @param a
     * @return
     */
    public String longestPalindromeFirstCut(String a) {
        if (a == null || a.length() == 0 || a.length() == 1)
            return a;
        int len = a.length();
        int [][] maxSubString = new int[len][len];
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int maxLength = 1;
        for ( int i = 0; i < len; i++) {
            maxSubString[i][i] = 1;
        }
        for ( int i = 1; i < len; i++) {
            //Have to go diagonally so i represents length of substring.
            for ( int j = 0; i + j < len; j++ ) {
                //j represents start index.
                int start = j;
                int end = j + i;
                int palindromeLength = 0;
                if (a.charAt(start) == a.charAt(end)) {
                    if ( i == 1) {
                        //Next to each other like aa or bb
                        palindromeLength = 2;
                    } else {
                        //Not adjacent like abca or aca or abba
                        int innerPalindromValue = maxSubString[start + 1][end - 1];
                        if (innerPalindromValue == i - 1) {
                            palindromeLength = 2 + innerPalindromValue;
                        } else {
                            palindromeLength = innerPalindromValue;
                        }
                    }
                }
                if ( maxSubString[start][end - 1] > palindromeLength) {
                    palindromeLength =  maxSubString[start + 1][end];
                }
                if ( maxSubString[start + 1][end] > palindromeLength) {
                    palindromeLength =  maxSubString[start + 1][end];
                }
                maxSubString[start][end] = palindromeLength;
                if ( palindromeLength > maxLength) {
                    maxStartIndex = start;
                    maxEndIndex = end;
                    maxLength = palindromeLength;
                }
            }
        }
        return a.substring(maxStartIndex, maxEndIndex + 1);
    }
}

