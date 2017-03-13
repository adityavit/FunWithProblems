package binarySearch;

/**
 * Created by adib on 8/22/16.
 */
public class Solution {

    /**
     * Find the element in a sorted array.
     * @param arr Sorted array
     * @param elem elem to find
     * @return index where the elem is found
     */
    public int binarySearch(int[] arr, int elem) {
        if ( arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, u = arr.length -1, m;
        while (l <= u) {
            m = (l+u)/2;
            if (arr[m] == elem) {
                // The middle element is the element we are search
                return m;
            }
            if (arr[m] < elem) {
                // middle element is smaller than the element we are searching.
                // Look in the right side of the arr.
                l = m + 1;
            } else {
                // middle element is greater than the element we are searching.
                // Look in the left side of the array.
                u = m - 1;
            }
        }
        return -1;
    }

//    public int firstFirstOccurance(int[] arr, )
}
