package sorting;

import java.util.Arrays;

/**
 * Created by adib on 6/12/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        int[] elems = {10, 5, 3, 2, 0, -1 , 5, 7, 8, 2};
//        int[] elems = {};
        Solution sol = new Solution();
        sol.qSort(elems);
        System.out.println("elems = " + Arrays.toString(elems));
    }
}
