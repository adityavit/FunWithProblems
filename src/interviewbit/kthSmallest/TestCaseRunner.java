package interviewbit.kthSmallest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by adib on 9/17/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> input = new ArrayList<>(Arrays.asList(new Integer[]{94, 87, 100, 11, 23, 98, 17, 35, 43, 66, 34, 53, 72, 80, 5, 34, 64, 71, 9, 16, 41, 66, 96}));
        System.out.println(sol.kthsmallest(input, 19));
        Collections.sort(input);
        System.out.println(input);
        System.out.println(input.get(18));
    }
}
