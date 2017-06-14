package EPI.Arrays.DutchNationalFlagProblem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by adib on 4/30/17.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        int[] elems = {0, 1, 2, 0, 2, 1, 1};
        Solution.partition(elems, 0);
        System.out.println(Arrays.toString(elems));
        elems = new int[]{0, 1, 2, 0, 2, 1, 1};
        Solution.partitionSinglePass(elems, 0);
        System.out.println(Arrays.toString(elems));
    }
}
