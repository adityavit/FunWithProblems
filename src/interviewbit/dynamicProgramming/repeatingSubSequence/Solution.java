package interviewbit.dynamicProgramming.repeatingSubSequence;

/**
 * https://www.interviewbit.com/problems/repeating-sub-sequence/
 * http://www.geeksforgeeks.org/repeated-subsequence-length-2/
 * http://www.geeksforgeeks.org/longest-repeating-subsequence/
 * O(n^2) complexity solution. But space is less it uses O(n) rather than LCS which will use O(n^2)
 * Solved it myself.
 * The solution here which is used is different from the one on geeks for geeks or interviewbit, in which they use LCS to solve this.
 * So to solve it,
 * First we stored the index of the characters in the string where we see them before.
 * If cannot find the character earlier in the string we store -1 for that character.
 * so a string like abaca --> [ -1, -1 , 0, -1, 2]
 *
 * Now we have to find whether there is an increasing sub sequence after ignoring  -1.
 * Also to find the longest repeated sub sequence, It is about finding the longest increasing sub sequence.
 * Created by adib on 11/3/16.
 * @accepted
 */
public class Solution {
    public int anytwo(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int len = str.length();
        int[] seenCharIndex = new int[len];
        seenCharIndex[0] = -1;
        for ( int i = 1; i < len; i++) {
            seenCharIndex[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    seenCharIndex[i] = j;
                    break;
                }
            }
        }
        //Scan the list to see if there is an increasing subsequence.
        int smallestIndexValue = -1;
        for ( int i = 0; i < len ; i++) {
            if (seenCharIndex[i] != -1) {
                if (smallestIndexValue == -1) {
                    smallestIndexValue = seenCharIndex[i];
                    continue;
                }
                if (seenCharIndex[i] > smallestIndexValue) {
                    return 1;
                }
                if ( seenCharIndex[i] < smallestIndexValue) {
                    smallestIndexValue = seenCharIndex[i];
                }
            }
        }
        return 0;
    }
}
