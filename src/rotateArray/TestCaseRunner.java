package rotateArray;

import java.util.Arrays;

/**
 * Created by adib on 7/20/15.
 */
public class TestCaseRunner {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        sol.rotate(nums, 0);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }
}
