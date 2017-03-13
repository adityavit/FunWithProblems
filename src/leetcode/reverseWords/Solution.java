package leetcode.reverseWords;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Created by adib on 8/13/16.
 */
public class Solution {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String tempString = " " + s + " ";
        int lastSpaceIndex = tempString.length() - 1;
        for( int i = tempString.length() - 2 ; i > -1 ; i-- ) {
            if (tempString.charAt(i) == ' ') {
                if (lastSpaceIndex - i == 1) {
                    lastSpaceIndex = i;
                    continue;
                }
                String word = tempString.substring(i+1 , lastSpaceIndex);
                if(sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(word);
                lastSpaceIndex = i;
            }
        }
        return sb.toString();
    }

    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverseString(s, 0, s.length - 1);
        int lastSpaceIndex = -1;
        for (int i = 0; i <= s.length; i++ ) {
            if (i == s.length || s[i] == ' ' ) {
                if ( i == 0) {
                    //If there are trailing spaces in s they will come in the front after reverse
                    reverseString(s, lastSpaceIndex + 1, i );
                } else {
                    reverseString(s, lastSpaceIndex + 1, i - 1);
                }
                lastSpaceIndex = i;
            }
        }
    }

    public void reverseString(char[] s, int startIndex, int endIndex) {
        while (endIndex > startIndex) {
            char temp = s[startIndex];
            s[startIndex] = s[endIndex];
            s[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
