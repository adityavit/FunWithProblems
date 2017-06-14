package EPI.Arrays.NextPermutation;

import java.util.Arrays;

/**
 * Created by adib on 5/24/17.
 */
public class Solution {
    /**
     * The algorithm i have used here, the same algorithm has been defined by the EPI.
     * @param elems
     */
    public static void nextPermutation(int[] elems) {
        if (elems == null || elems.length == 0 || elems.length == 1)
            return;

        int lastI = elems.length - 1;
        while(lastI > 0) {
            if ( elems[lastI] > elems[lastI - 1]) {
                // If the previous elem is smaller than current element
                int nextGreaterElemI = findNextGreaterElemI(elems, elems[lastI - 1], lastI );
                swap(elems, lastI - 1, nextGreaterElemI);
                reverse(elems, lastI, elems.length - 1);
                return;
            }
            lastI--;
        }
    }

    private static int findNextGreaterElemI(int[] elems, int smallerElem, int startI) {
        for(int i = startI; i < elems.length; i++) {
            if(elems[i] < smallerElem) {
                return i - 1;
            }
        }
        return elems.length - 1;
    }

    private static void swap(int[] elems, int firstI, int secondI) {
        int temp = elems[firstI];
        elems[firstI] = elems[secondI];
        elems[secondI] = temp;
    }

    private static void reverse(int[] elems, int startI, int endI) {
        while(startI < endI) {
            swap(elems, startI, endI);
            startI++;
            endI--;
        }
    }
}
