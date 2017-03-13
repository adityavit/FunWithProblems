package interviewbit.largestConsecutiveSequence;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;

/**
 * Created by adib on 10/1/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] elems = {1, 8 , 3, 12, 2, 11, 9, 0, -1, 10, 6};
        System.out.println(sol.longestConsecutive(Arrays.asList(elems)));
        BitSet bitset = new BitSet();
    }
}
