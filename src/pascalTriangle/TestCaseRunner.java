package pascalTriangle;

import java.util.*;

/**
 * Created by adib on 6/7/15.
 */
public class TestCaseRunner {
    public static void main(String[] args){
        Solution sol = new Solution();
        List<List<Integer>> triange = sol.generate(5);
        System.out.println(triange);
    }

}
