package leetcode.threeSum;

import java.util.*;

public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        SolutionMap solM = new SolutionMap();
        int[] elems = {-10,-4,5,0,1,1,-8,3,-10,3,0,-6,-10,4,-9,-1,-10,6,-6,-2,3,2};
//        int[] elems = {-1,0,1,2,-1,-4 , -1, 2};
        List<List<Integer>> result = sol.threeSum(elems);
        List<List<Integer>> resultMap = solM.threeSum(elems);
        System.out.println(result);
        System.out.println(resultMap);
//        Set<List<Integer>> set = new HashSet();
//        List<Integer> testList = new ArrayList<Integer>();
//        testList.add(0);
//        testList.add(1);
//        System.out.println(testList.hashCode());
//        List<Integer> testList1 = new ArrayList<Integer>();
//        testList1.add(1);
//        testList1.add(1);
//        System.out.println(testList1.hashCode());
//        set.add(testList);
//        System.out.println("testList == testList1===="+ testList.equals(testList1));
//        testList.equals(testList1);
//        System.out.println("testList1 contains = " + set.contains(testList1));
    }
}