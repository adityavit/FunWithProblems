package interviewbit.removeDuplicatesTwo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by adib on 9/12/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(new ArrayList<>(Arrays.asList(new Integer[] {0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4}))));
    }
}
