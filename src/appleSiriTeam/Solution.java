package appleSiriTeam;

/**
 * Created by adib on 5/25/17.
 */
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        // ArrayList<String> strings = new ArrayList<String>();
        // strings.add("Hello, World!");
        // strings.add("Welcome to CoderPad.");
        // strings.add("This pad is running Java 8.");
        int[] elems = {1,2,3,4,5};
        System.out.println(maxSum(elems));

        int[] elems1 = {1,-2,3,10,1};
        System.out.println(maxSum(elems1));

        int[] elems2 = {-2, -4, 3, 1, -1};
        System.out.println(maxSum(elems2));

        int[] elems3 = {-2, -2, -3, -1, -1};
        System.out.println(maxSum(elems3));
        // for (String string : strings) {
        //   System.out.println(string);
        // }
    }

    private static int maxSum(int[] elems) {
        if ( elems == null || elems.length == 0)
            return 0;

        if (elems.length == 1)
            return Math.max(elems[0], 0);

        int[] dpArray = new int[elems.length];
        dpArray[0] = Math.max(elems[0], 0);
        dpArray[1] = Math.max(elems[1], dpArray[0]);
        for ( int i = 2; i < elems.length; i++) {
            dpArray[i] = Math.max(dpArray[i-2] + elems[i], dpArray[i-1]);
        }
        return dpArray[elems.length -1];
    }
}



/*
Your previous Python 3 content is preserved below:


"""
Given an array of numbers, calculate the maximum of sum where each number is not contiguous number of any other. E.g.

Given input [1,2,3,4,5]
The maximum sum sequence is
[1,3,5] = 9


Given input [1,-2,3,10,1]
The maximum sum sequence is
[1, 10] = 11

A = [1, 2, 4, 6, 9]

[1 , 1, 4, 11, 11]



"""

def calculate_maximum_sum(elements):
    # TODO: implement
    return 0


input1 = [1, 2, 3, 4, 5]
max_sum1 = calculate_maximum_sum(input1)
print("Max sum 1: ", max_sum1);
assert(max_sum1 == 9)

input2 = [1, -2, 3, 10, 1]
max_sum2 = calculate_maximum_sum(input2)
print("Max sum 2: ", max_sum2);
assert(max_sum2 == 11)

input3 = [-2, -4, 3, 1, -1]
max_sum3 = calculate_maximum_sum(input3)
print("Max sum 3: ", max_sum3);
assert(max_sum3 == 3)

[-2, -2,


 */
