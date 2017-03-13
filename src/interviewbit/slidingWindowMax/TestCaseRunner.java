package interviewbit.slidingWindowMax;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adib on 9/18/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] elems = {90, 140, 440, 630, 885, 838, 176, 756, 536, 430, 645, 367, 943, 150, 214, 619, 616, 82, 19, 994, 431, 440, 399, 273, 166, 170, 596, 586, 350, 497, 401, 56, 486, 472, 661, 269, 136, 51, 222, 4, 877, 722, 877, 76, 318, 643, 946, 836, 17, 315, 404, 86, 687, 313, 447, 1, 337, 782, 32, 376, 327, 540, 51, 428, 619, 526, 530, 935, 631, 444, 92, 473, 3, 855, 405, 396, 591, 926, 576, 138, 98};
        int[] elemsInt = {90, 140, 440, 630, 885, 838, 176, 756, 536, 430, 645, 367, 943, 150, 214, 619, 616, 82, 19, 994, 431, 440, 399, 273, 166, 170, 596, 586, 350, 497, 401, 56, 486, 472, 661, 269, 136, 51, 222, 4, 877, 722, 877, 76, 318, 643, 946, 836, 17, 315, 404, 86, 687, 313, 447, 1, 337, 782, 32, 376, 327, 540, 51, 428, 619, 526, 530, 935, 631, 444, 92, 473, 3, 855, 405, 396, 591, 926, 576, 138, 98};
//        Integer[] elems = {661, 269, 136, 51, 222, 4, 877, 722, 877, 76, 318, 643, 946};
        int[] values = sol.maxSlidingWindow(elemsInt, 5);
        List<Integer> result = sol.slidingMaximum(Arrays.asList(elems), 5);
//        System.out.println(Arrays.toString(elems));
//        System.out.println(result);
//        Integer[] values = {885, 885, 885, 885, 885, 838, 756, 756, 943, 943, 943, 943, 943, 619, 619, 994, 994, 994, 994, 994, 440, 440, 596, 596, 596, 596, 596, 586, 497, 497, 661, 661, 661, 661, 661, 269, 877, 877, 877, 877, 877, 877, 946, 946, 946, 946, 946, 836, 687, 687, 687, 687, 687, 782, 782, 782, 782, 782, 540, 540, 619, 619, 619, 935, 935, 935, 935, 935, 631, 855, 855, 855, 855, 926, 926, 926, 926 };
//        System.out.println(Arrays.toString(values));
//        System.out.println(values.length + " " +result.size());
        for( int i = 0; i < values.length ; i++) {
            if (!result.get(i).equals(values[i]) ) {
                System.out.println("i = " + i);
                System.out.println("values[i] = " + values[i]);
                System.out.println("result.get(i) = " + result.get(i));
            }
        }
    }
}
