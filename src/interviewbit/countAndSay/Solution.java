package interviewbit.countAndSay;

/**
 * https://www.interviewbit.com/problems/count-and-say/
 * Created by adib on 9/4/16.
 */
public class Solution {
    public String countAndSay(int a) {
        if ( a == 0)
            return "";
        String count = "1";
        for (int i = 1; i < a; i++) {
            count = getNext(count);
        }
        return count;

    }

    private String getNext(String count) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int len = count.length();
        char digit = count.charAt(0);
        int digitCount = 1;
        while (i < len) {
            if (digit == count.charAt(i) ){
                digitCount++;
            } else {
                sb.append(digitCount + "" + digit);
                digit = count.charAt(i);
                digitCount = 1;
            }
            i++;
        }
        sb.append(digitCount + "" + digit);
        return sb.toString();
    }
}
