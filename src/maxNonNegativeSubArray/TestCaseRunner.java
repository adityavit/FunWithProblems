package maxNonNegativeSubArray;

import java.util.ArrayList;

/**
 * Created by adib on 7/31/16.
 */
public class TestCaseRunner {
    public static void main(String[] args){
        Solution sol = new Solution();
        ArrayList<Integer> elems = new ArrayList<Integer>();
        elems.add(1967513926);
        elems.add(1540383426);
        elems.add(-1303455736);
        elems.add(-521595368);
        System.out.println(sol.maxset(elems));
    }
}
