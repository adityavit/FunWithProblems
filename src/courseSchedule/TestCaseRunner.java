package courseSchedule;

import java.util.Arrays;

/**
 * Created by adib on 7/11/15.
 */
public class TestCaseRunner {
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] a = new int[1][2];
        a[0][0] = 0;
        a[0][1] = 1;
//        a[1][0] = 1;
//        a[1][1] = 0;
        System.out.println(sol.canFinish(2, a));
        System.out.println(Arrays.toString(sol.findOrder(2, a)));

    }
}
