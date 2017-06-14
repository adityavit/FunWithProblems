package EPI.Arrays.NextPermutation;

import java.util.Arrays;

/**
 * Created by adib on 5/24/17.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
//        int[] permut = {1, 2, 3, 4, 5};
//        for(int i = 0; i < 119; i++) {
//            Solution.nextPermutation(permut);
//            System.out.println(Arrays.toString(permut));
//        }
        int[] permut2 = {6, 2, 1, 5, 4, 3, 0};
        Solution.nextPermutation(permut2);
        System.out.println(Arrays.toString(permut2));
    }
}
