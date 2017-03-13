package interviewbit.compareVersion;

/**
 * Created by adib on 9/4/16.
 */
public class Solution {
    public int compareVersion(String a, String b) {
        if (a == null || b == null){
            return 0;
        }
        String[] aSplit = a.split("\\.");
        String[] bSplit = b.split("\\.");
        int minLen = Math.min(aSplit.length, bSplit.length);
        int i = 0;
        while (i < minLen) {
            int digitComp = compareDigits(aSplit[i], bSplit[i]);
            if (digitComp != 0) {
                return digitComp;
            }
            i++;
        }
        if ( i == aSplit.length && i == bSplit.length ) {
            return 0;
        }
        return i == bSplit.length ? 1: -1;
    }

    private int compareDigits(String num1, String num2) {
        double num1Val = 0, num2Val = 0;
        int i = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        while ( i < len1) {
            num1Val = 10*num1Val + (num1.charAt(i) - '0');
            i++;
        }
        i = 0;
        while ( i < len2) {
            num2Val = 10*num2Val + (num2.charAt(i) - '0');
            i++;
        }
        if (num1Val == num2Val) {
            return 0;
        }
        return num1Val > num2Val? 1: -1;
    }
}
