package interviewbit.lastWordLength;

/**
 * https://www.interviewbit.com/problems/length-of-last-word/
 * Rather than checking for space check for non-space character.
 * Created by adib on 9/4/16.
 * accepted
 */
public class Solution {
    public int lengthOfLastWord(final String a) {
        if ( a == null || a.length() == 0){
            return 0;
        }
        int start = -1, end = -1, j = 0;
        int len = a.length();
        String str = a;
        while (j < len) {
            char charj = str.charAt(j);
            if (charj != ' ') {
                if ( j == 0 || str.charAt(j - 1) == ' ') {
                    start = j;
                }
                if (j == len - 1 || str.charAt(j + 1) == ' ') {
                    end = j;
                }
            }
            j++;
        }
        return end == -1? 0 : end - start + 1;
    }

    // Inspired by their solution. More clean.
    public int betterLengthOfLastWord(final String a) {
        if ( a == null || a.length() == 0){
            return 0;
        }
        int len = 0, j = 0;
        int aLen = a.length();
        while ( j < aLen ) {
            if (a.charAt(j)  != ' ') {
                len++;
            } else {
                // if it is not the end check if the next character is a character
                if (j != aLen - 1 && a.charAt(j + 1) != ' ')
                    len = 0;
            }
            j++;
        }
        return len;
    }
}
