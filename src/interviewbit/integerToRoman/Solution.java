package interviewbit.integerToRoman;

/**
 * https://www.interviewbit.com/problems/integer-to-roman/
 * Created by adib on 9/5/16.
 * This can be further restructured
 * if you see code for 1000, 100 , 10 is similar and
 * code for 500, 50 , 5 is similar so those can be two functions.
 * @accepted
 */
public class Solution {

    public String intToRoman(int a) {
        if ( a == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (a >= 900) {
            // this will have an M in it.
            if (a >= 1000) {
                //Starts with M
                int numOfM = a / 1000;
                for ( int i = 0; i < numOfM; i++) {
                    sb.append("M");
                }
                return sb.append(intToRoman(a % 1000)).toString();
            }
            sb.append("CM");
            return sb.append(intToRoman(a % 900)).toString();
        }
        if ( a >= 400) {
            if (a >= 500) {
                //Starts with M
                sb.append("D");
                return sb.append(intToRoman(a - 500)).toString();
            }
            sb.append("CD");
            return sb.append(intToRoman(a - 400)).toString();
        }
        if (a >= 90) {
            // this will have an M in it.
            if (a >= 100) {
                //Starts with M
                int numOfC = a / 100;
                for ( int i = 0; i < numOfC; i++) {
                    sb.append("C");
                }
                return sb.append(intToRoman(a % 100)).toString();
            }
            sb.append("XC");
            return sb.append(intToRoman(a % 90)).toString();
        }
        if ( a >= 40) {
            if (a >= 50) {
                //Starts with M
                sb.append("L");
                return sb.append(intToRoman(a - 50)).toString();
            }
            sb.append("XL");
            return sb.append(intToRoman(a - 40)).toString();
        }
        if (a >= 9) {
            // this will have an M in it.
            if (a >= 10) {
                //Starts with M
                int numOfX = a / 10;
                for ( int i = 0; i < numOfX; i++) {
                    sb.append("X");
                }
                return sb.append(intToRoman(a % 10)).toString();
            }
            sb.append("IX");
            return sb.append(intToRoman(a % 9)).toString();
        }
        if ( a >= 4) {
            if (a >= 5) {
                //Starts with M
                sb.append("V");
                return sb.append(intToRoman(a - 5)).toString();
            }
            sb.append("IV");
            return sb.append(intToRoman(a - 4)).toString();
        }
        // When a is smaller then 4
        int numOfI = a / 1;
        for ( int i = 0; i < numOfI; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
}
