package interviewbit.PalindromeString;

/**
 * https://www.interviewbit.com/problems/palindrome-string/
 * Created by adib on 9/4/16.
 * accepted
 */
public class Solution {
    public int isPalindrome(String a) {
        int len = a.length();
        if ( len == 0 || len == 1) {
            return 1;
        }
        int i = 0, j = len - 1;
        while ( i <= j) {
            int chari = isAlphaNumeric(a.charAt(i));
            int charj = isAlphaNumeric(a.charAt(j));
            if ( chari < 0) {
                i++;
                continue;
            }
            if ( charj < 0) {
                j--;
                continue;
            }
            if (chari != charj) {
                return 0;
            } else {
                i++;
                j--;
            }
        }
        return 1;
    }

    private int isAlphaNumeric(char c) {
        if (c >= 'A' && c <= 'Z')
            return c - 'A';
        if (c >= 'a' && c <= 'z')
            return c - 'a';
        if (c >= '0' && c <= '9')
            return c - '0';
        return -1;
    }
}
