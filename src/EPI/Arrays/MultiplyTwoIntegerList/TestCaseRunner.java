package EPI.Arrays.MultiplyTwoIntegerList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by adib on 4/30/17.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        List<Integer> listX = new ArrayList<>(Arrays.asList(new Integer[]{1, 9 , 3 , 7, 0 ,7 , 7, 2 ,1}));
        List<Integer> listy = new ArrayList<>(Arrays.asList(new Integer[]{-7, 6 , 1, 8, 3, 8 , 2, 5 ,7 , 2, 8, 7}));
        List<Integer> result = Solution.multiply(listX, listy);
        System.out.println(result);
    }
}
