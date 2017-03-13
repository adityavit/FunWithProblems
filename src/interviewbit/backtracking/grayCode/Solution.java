package interviewbit.backtracking.grayCode;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/gray-code/
 * https://leetcode.com/problems/gray-code/
 * This problem is good one i would say. Although it has a solution which uses bit manupilation if someone understands gray code very well.
 * But important thing to see in gray code is that it follows the principle of reflexivity.
 * It took me quite some time to write this backtracking solution, because of the complex logic in the recursion.
 *
 * This is how it works.
 * For gray code of 3 would be
 * 000
 * 001
 *   - last bit gets repeated in the order it came.
 * 011
 * 010
 *  --  Write the same bits in the order from last to up with 1 as the n th bit.
 * 110
 * 111
 * 101
 * 100
 * If you take a look at this for the n th bit, the n - 1 bits repeats itself when nth bit is 1 as if there is mirror when the n th bit changed to 1.
 *
 * To denote this change i used a variable changed, changed reverses the cycle of generating bits.
 * Changed becomes true for n - 1 bits when the nth bit turns to 1. So that sequence can start for the n - 1 bit with 1.
 *
 *
 * Another way of solving this problem.
 * As described on the wiki page https://en.wikipedia.org/wiki/Gray_code
 *
 * i th Gray code for n bits so 2^n solutions can be found using the formulation i ^ (i >> 1) or i xor (i/2)
 * I still couldn't figure out why it works, but wiki has this explanation.
 *
 * These characteristics suggest a simple and fast method of translating a binary value into the corresponding Gray code.
 * Each bit is inverted if the next higher bit of the input value is set to one.
 * This can be performed in parallel by a bit-shift and exclusive-or operation if they are available: the nth Gray code is obtained by computing n ^ floor(n/2)
 *
 * time: O(2^n) as there 2^n solutions to the problem.
 * Created by adib on 10/16/16.
 */
public class Solution {
    public ArrayList<Integer> grayCode(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( num == 0) {
            return result;
        }
        grayCodeRecursive(num, result, new StringBuilder(), false);
        return result;
    }

    public void grayCodeRecursive(int num, ArrayList<Integer> result, StringBuilder sb, boolean changed) {
        if ( sb.length() > num )
            return;

        if (sb.length() == num) {
            result.add(convertBinaryToInt(sb.toString()));
            return;
        }

        if (!changed) {
            for ( int i = 0; i < 2; i++) {
                sb.append(i);
                int len = sb.length();
                grayCodeRecursive(num, result, sb, changed);
                changed = true;
                sb.deleteCharAt(len - 1);
            }
        } else {
            for ( int i = 1; i >= 0; i--) {
                sb.append(i);
                int len = sb.length();
                grayCodeRecursive(num, result, sb, !changed);
                changed = false;
                sb.deleteCharAt(len - 1);
            }
        }
    }

    public int convertBinaryToInt(String binary) {
        int result = 0;
        for ( int i = 0; i < binary.length(); i++) {
            result = result * 2 + (binary.charAt(i) - '0');
        }
        return result;
    }
}
