package interviewbit.histogramMaximumArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adib on 9/19/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] tc1 = {2, 74, 5, 25, 60, 10, 93, 58, 95, 20, 28, 80, 76, 28, 75, 100, 2, 73, 42, 34, 66, 51, 89, 85, 73, 10, 43 };
        ArrayList<Integer> elems = new ArrayList<>(Arrays.asList(tc1));
        System.out.println(sol.largestRectangleArea(elems));
    }
}
