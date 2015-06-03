package mergeIntervals;


import java.util.*;

/**
 * Created by adib on 6/2/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Interval> elems = new ArrayList();
        elems.add(new Interval(1,3));
        elems.add(new Interval(2,6));
        elems.add(new Interval(8,10));
        elems.add(new Interval(15,18));

        List<Interval> resultList = sol.merge(elems);
        System.out.println("resultList = " + resultList);
    }
}
