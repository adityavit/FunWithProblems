package interviewbit.addBinaryString;

/**
 * https://www.interviewbit.com/problems/add-binary-strings/
 * Created by adib on 9/5/16.
 * Original solution which i wrote, very verbose. Also the if conditions are not good.
 * Strategy: Start from the end of both the strings and then add the bits and maintain carry till you run out of one of
 * the shorter string then work on the longer string and add carry at the end. Send the reverse of the string.
 *
 * @accepted
 */
public class Solution {
    public String addBinary(String a, String b) {
        if ( a == null || b == null) {
            return "";
        }
        int lenA = a.length();
        int lenB = b.length();
        if (lenA == 0)
            return b;
        if (lenB == 0)
            return a;
        StringBuilder sb = new StringBuilder();
        int minLen = Math.min(lenA, lenB);
        int i = 0;
        int carry = 0;
        while (i < minLen) {
            int bitA = a.charAt(lenA - i - 1) - '0';
            int bitB = b.charAt(lenB - i - 1) - '0';
            int sum = bitA + bitB + carry;
            if (sum == 0 || sum == 1){
                sb.append(sum);
                carry = 0;
            } else {
                sb.append((sum == 2)?0:1);
                carry = 1;
            }
            i++;
        }
        while ( i < lenA) {
            int bitA = a.charAt(lenA - i - 1) - '0';
            int sum = bitA + carry;
            if (sum == 0 || sum == 1){
                sb.append(sum);
                carry = 0;
            } else {
                sb.append((sum == 2)?0:1);
                carry = 1;
            }
            i++;
        }
        while ( i < lenB) {
            int bitB = b.charAt(lenB - i - 1) - '0';
            int sum = bitB + carry;
            if (sum == 0 || sum == 1){
                sb.append(sum);
                carry = 0;
            } else {
                sb.append((sum == 2)?0:1);
                carry = 1;
            }
            i++;
        }
        if ( carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    /**
     * Here the sum is calculated using this logic. Think how would you have done with 10 as the base.
     * sum = (bitA + bitB + carry) % 2
     * carry = (bitA + bitB + carry) / 2
     * Also can go through both the strings if one of the string runs out just use 0 as the bit for that.
     * It is like appending 0 to the starting of the shorter bit string.
     * This can be easily made to any base with this logic, if base 16 divide using 16.
     * @accepted
     * @better
     */
    public String addBinaryBetter(String a, String b) {
        if ( a == null || b == null) {
            return "";
        }
        int lenA = a.length();
        int lenB = b.length();
        if (lenA == 0)
            return b;
        if (lenB == 0)
            return a;
        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(lenA, lenB);
        int i = 0;
        int carry = 0;
        while (i < maxLen) {
            int bitA = i < lenA ? a.charAt(lenA - i - 1) - '0' : 0;
            int bitB = i < lenB ? b.charAt(lenB - i - 1) - '0' : 0;
            int sum = (bitA + bitB + carry) % 2;
            carry = (bitA + bitB + carry) / 2;
            sb.append(sum);
            i++;
        }
        if ( carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}
