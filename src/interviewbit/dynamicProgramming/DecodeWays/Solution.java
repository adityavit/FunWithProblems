package interviewbit.dynamicProgramming.DecodeWays;

/**
 * https://leetcode.com/problems/decode-ways/
 * https://www.interviewbit.com/problems/ways-to-decode/
 *
 * This problem is not that hard, although the problem happens taking care of the '0'
 * If the digit is not 0 than the solution is sol[i - 1]
 * The idea is simple if a digit at i forms a number with i - 1 then solution gets added with the value sol[i - 2]
 *
 * Created by adib on 10/31/16.
 */
public class Solution {
    /**
     *
     * @param str
     * @return
     */
    public int numDecodings(String str) {
        if (str.length() == 0 || str.charAt(0) == '0')
            return 0;
        int len = str.length();
        if ( len == 1 )
            return 1;
        int[] noOfWays = new int[len];
        noOfWays[0] = 1;
        int firstTwoDigits = Integer.parseInt(str.substring(0, 2));
        if (firstTwoDigits == 10 || firstTwoDigits == 20) {
            noOfWays[1] = 1;
        } else {
            if (str.charAt(1) == '0') {
                return 0;
            }
            noOfWays[1] = firstTwoDigits >= 10 && firstTwoDigits <= 26 ? 2 : 1;
        }
        for ( int i = 2; i < len; i++) {
            if (str.charAt(i) != '0') {
                noOfWays[i] = noOfWays[i - 1];
            }
            int twoLetterInt = Integer.parseInt(str.substring(i - 1, i + 1));
            if ( twoLetterInt >= 10 && twoLetterInt <= 26) {
                noOfWays[i] += noOfWays[i - 2];
                continue;
            }
            if ( str.charAt(i) == '0' ) {
                //If the zero is prefixes a number which makes it greater than 26
                return 0;
            }
        }
        return noOfWays[len - 1];
    }
}
