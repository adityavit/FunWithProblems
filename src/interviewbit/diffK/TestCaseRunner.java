package interviewbit.diffK;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by adib on 9/25/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] elems = {1, 3, 2};
        List<Integer> elemsLst = Arrays.asList(elems);
        System.out.println(sol.diffPossible(elemsLst, 0));
    }
}
