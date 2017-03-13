package interviewbit.histogramMaximumArea;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * This is an awesome problem with the use of the stack.
 * https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 * Couldn't solve this problem myself although was very close to solving it,had to look for help on geek for geeks. Hopefully would be able to solve this problem next time myself.
 * Checked the algorithm from geeks for geeks and then wrote the code.
 *
 * So the logic is like this for solving this problem in O(n)
 * My initial solution was calculating the area as i am adding values to the stack, but the solution lies in calculating the area when the values are popped out of the stack.
 *
 * Put indexes in the stack rather than values as index will be used to create area. But all the comparisons are done using the value at that index in the input array.
 * So firstly if the stack is empty or the top value is smaller than the current index value add the value to the stack. In this way stack will contain index values in the increasing order.
 * If the value is same or less then
 * Pop the values till the time the next index value is not smaller than the current index value, at this point the current index value would be inserted.
 * Now for the all the values greater than or equal to current value, calculate the area and compare it with max area.
 * To calculate area keep in the mind that
 * area won't be just a.get(index) * i - index, although this looks correct but is wrong as calculates the value from index till i and deosn't consider the area for the higher values before index.
 * example 2 4 5 3 4 5 1 at i=6 stack will have 0 , 3 and for index = 3 a.get(index) = 3 so the area will come out to be 3 * 3 = 9 but actual area for 3 is 5 * 3 = 15.
 * So calculate the area by checking what is there in the stack after removing index and that becomes previousIndex, so the area is i - (previousIndex + 1) * a.get(index).
 * In the case it is the last index in the stack this (i - 0 )* a.get(index) this is because the element at this index is the smallest one till the i so it's area will start from 0th index.
 *
 * At the end just pop the element from the stack and calculate the area for these indexes in the similar way.
 * Created by adib on 9/19/16.
 */
public class Solution {
    public int largestRectangleArea(ArrayList<Integer> a) {
        if ( a == null || a.size() == 0) {
            return 0;
        }
        int i = 0;
        int maxArea = 0;
        int len = a.size();
        Deque<Integer> stack = new LinkedList<>();
        while ( i < len) {
            if ( stack.isEmpty() || a.get(stack.peek()) < a.get(i)) {
                //If stack is empty or the top element is smaller than the element at the current index.
                stack.push(i);
            } else {
                //If the current element is smaller than the value of the top of the stack.
                while ( stack.size() > 0 && a.get(stack.peek()) >= a.get(i) ) {
                    int index = stack.pop();
                    Integer previousIndex = stack.peek();
                    int area =  a.get(index) * (previousIndex != null ? (i - previousIndex - 1): i);
                    maxArea = area > maxArea ? area: maxArea;
                }
                stack.push(i);
            }
            i++;
        }
        while ( stack.size() > 0 ) {
            int index = stack.pop();
            Integer previousIndex = stack.peek();
            int area =  a.get(index) * (previousIndex != null ? (i - previousIndex - 1): i);
            maxArea = area > maxArea ? area: maxArea;
        }
        return maxArea;
    }
}
