package interviewbit.zigZagString;

/**
 * https://www.interviewbit.com/problems/zigzag-string/
 * Created by adib on 9/9/16.
 * Relatively easy problem if you can decide upon the next element in the list and next to next element.
 * if b == 1 then take care as the i == b - 1 = 0 in that case return the string back as the loop will go infinitely.
 * when i = 0 or i = b - 1 then next element will be 2 * b - 2 (i + 1) or 2 * b - 2 * (b - i)
 * else the next element will be alternating between these two values.
 * @aacepted
 */
public class Solution {
    public String convert(String a, int b) {
        if (a == null || a.length() == 0) {
            return "";
        }
        int i = 0, j = 0;
        int lastIndex = 0;
        int len = a.length();
        StringBuilder sb = new StringBuilder();
        if (len <= b || b == 1) {
            return a;
        }
        while ( i < b ) {
            sb.append(a.charAt(i));
            int nextElemDistance = 2 * b - 2 * (i + 1);
            int nextToNextElemDistance = 2 * b - 2 * (b - i);
            lastIndex = i;
            j = nextElemDistance != 0? i + nextElemDistance: i + nextToNextElemDistance;
            while (j < len) {
                sb.append(a.charAt(j));
                if ( j - lastIndex == nextElemDistance) {
                    lastIndex = j;
                    if ( nextToNextElemDistance > 0) {
                        j = j + nextToNextElemDistance;
                    } else {
                        j = j + nextElemDistance;
                    }
                } else {
                    lastIndex = j;
                    if (nextElemDistance > 0) {
                        j = j + nextElemDistance;
                    } else {
                        j = j + nextToNextElemDistance;
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }
}

