package EPI.Strings.ReplaceAndRemove;

import java.util.Arrays;

/**
 * Created by adib on 6/22/17.
 */
public class Solution {
    public static void main(String[] args) {
        char[] str1 = {'a', 'a', 'a', 'd', 'b', '\0', '\0'};
        replaceAndRemove(str1 , 5);
        System.out.println("str1 = " + Arrays.toString(str1));
        char[] res1 = {'d', 'd', 'd', 'd', 'd', 'd', 'd'};
        assert(Arrays.equals(str1, res1));
        char[] str2 = {'b', 'b', 'a', 'b', 'e', '\0', '\0'};
        replaceAndRemove(str2 , 5);
        System.out.println("str2 = " + Arrays.toString(str2));
    }

    public static void replaceAndRemove(char[] input, int max) {
        if (input == null || input.length == 0) {
            return;
        }

        int aCounter = 0;

//        int maxPositionCount = 0;
//        for(int i = 0; i < max; i++) {
//            if(input[i] == 'b') {
//                continue;
//            }
//            if(input[i] == 'a') {
//                maxPositionCount++;
//            }
//            maxPositionCount++;
//        }
//        maxPositionCount--;
//        int i = max - 1;
//        while ( maxPositionCount >= 0 ) {
//            if(input[i] == 'b') {
//                input[i] = '\0';
//            }else if (input[i] == 'a') {
//                input[maxPositionCount--] = 'd';
//                input[maxPositionCount--] = 'd';
//            } else {
//                input[maxPositionCount--] = input[i];
//            }
//            i--;
//        }
    }
}
