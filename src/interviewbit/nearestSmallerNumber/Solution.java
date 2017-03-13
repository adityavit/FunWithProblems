package interviewbit.nearestSmallerNumber;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/nearest-smaller-element/
 * http://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 * Created by adib on 9/17/16.
 * This is a really good question. Although as this question is given in the stack section so it became relatively easy to solve.
 * Otherwise if the question is asked by it's own, it takes some to realize that you can use stack in this question.
 * The idea why stack can be used is that for the element a[i] solution will be either a[i-1] or the first number smaller that a[i],
 * Now once we find that number we don't need to remember other bigger numbers.
 * In the sense that once we find at position i there is no number smaller that a[i] for index < i then for the index above i the answer would be a[i] or
 * -1
 * Naive approach complexity is O(n^2)
 * This approach complexity is O(n)
 */
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.size() == 0) {
            return result;
        }
        Deque<Integer> smallestStack = new LinkedList<>();
        int i = 0;
        int len = arr.size();
        while (i < len) {
            while(smallestStack.size() != 0 && smallestStack.peek() >= arr.get(i)) {
                smallestStack.pop();
            }
            if (smallestStack.size() == 0) {
                result.add(-1);
            } else {
                result.add(smallestStack.peek());
            }
            smallestStack.push(arr.get(i));
            i++;
        }
        return result;
    }
}

