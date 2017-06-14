package EPI.Arrays.DeleteDuplicatesFromArray;

import java.util.Arrays;

/**
 * Created by adib on 5/14/17.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        int[] elems = {1, 3, 2 ,5 ,4, 2, 1, 4, 5, 6, 7, 8, 6, 3, 2, 1, 0};
        Arrays.sort(elems);
        Solution.deleteDuplicatesSortedArray(elems);
        System.out.println(Arrays.toString(elems));

        int[] elems1 = {1, 3, 2 ,5 ,4, 2, 1, 4, 5, 6, 7, 8, 6, 3, 2, 1, 0};
        int remainingElems = Solution.removeKeyFromArray(elems1, 5);
        System.out.println("Remaining elems = " + remainingElems);
        System.out.println(Arrays.toString(elems1));
    }
}
