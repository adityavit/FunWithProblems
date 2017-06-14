package EPI.Arrays.DeleteDuplicatesFromArray;

/**
 * Created by adib on 5/14/17.
 */
public class Solution {
    /**
     * Problem 5.5
     * @param elems
     */
    public static void deleteDuplicatesSortedArray(int[] elems) {
        if (elems == null || elems.length == 0){
            return;
        }
        int uniqueSoFar = 0;
        int index = 0;
        while (index < elems.length) {
            if ( elems[index] != elems[uniqueSoFar]) {
                swap(elems, index, ++uniqueSoFar);
            }
            index++;
        }
        uniqueSoFar++;
        while(uniqueSoFar < elems.length) {
            elems[uniqueSoFar] = 0;
            uniqueSoFar++;
        }
    }

    /**
     * Variant 1:
     * Implement a function which takes as input an array and a key, and updates the array so that all the
     * occurrences of the key has been removed and the remaining elements have been shifted left to fill the emptied indices.
     * @param elems
     * @param key
     * @return
     */
    public static int removeKeyFromArray(int[] elems, int key) {
        if (elems == null || elems.length == 0){
            return 0;
        }
        int noKeySoFar = -1;
        int index = 0;
        while(index < elems.length) {
            if (elems[index] != key) {
                swap(elems, index, ++noKeySoFar);
            }
            index++;
        }
        return noKeySoFar+1;
    }

    public static void swap(int[] elems, int firstI, int secondI){
        int temp = elems[firstI];
        elems[firstI] = elems[secondI];
        elems[secondI] = temp;
    }

}
