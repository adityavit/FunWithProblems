package interviewbit.removeDuplicates;

import interviewbit.mergeIntervals.Interval;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by adib on 9/11/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.removeDuplicates(new ArrayList<>(Arrays.asList(new Integer[] {150, 150, 150}))));

//        Integer[] arrayElements = new Integer[] {100, 100};
//        Integer[] arrayElements = new Integer[] {128, 128};
//        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(arrayElements));
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(128);
        testList.add(128);
        System.out.println(testList.get(0).equals(testList.get(1)));
        if (testList.get(0) != testList.get(1)) {
            System.out.println(testList.get(0) + "!=" + testList.get(1));
        } else {
            System.out.println(testList.get(0) + "==" + testList.get(1));
        }
    }
}
