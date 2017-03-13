package interviewbit.longestCommonPrefix;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/longest-common-prefix/
 * Created by adib on 9/4/16.
 * accepted
 */
public class Solution {
    public String longestCommonPrefix(ArrayList<String> a) {
        if ( a == null || a.size() == 0)
            return "";
        String longestCP = a.get(0);
        int longestCPPointer = longestCP.length();
        int i = 1;
        while ( i < a.size()) {
            String nextStr = a.get(i);
            int j = 0;
            int maxJ = Math.min(longestCPPointer, nextStr.length());
            while ( j < maxJ ) {
                if ( longestCP.charAt(j) != nextStr.charAt(j) ) {
                    break;
                }
                j++;
            }
            longestCPPointer = j;
            i++;
        }
        return longestCP.substring(0, longestCPPointer);
    }
}
