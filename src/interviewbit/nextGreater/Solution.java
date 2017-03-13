package interviewbit.nextGreater;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/nextgreater/
 * This is an awesome question although looks really easy.
 * O(n^2) solution is very to see. Although O(n) solution is not that easy to see.
 * Approaches i took to solve this question.
 * The logic i was trying to use was once i have found a higher number at index j for a number at i where i < j then any number between i and j
 * will have the higer number also at j or less then j. For example 10 7 4 6 8 11 6 so for i = 0 j = 5 then all the other values higher index will lie between
 * j = 5.
 * 1. Tried two pointer approach didn't work. You can try and see.
 * 2. Then tied using queue, It looked promising, index i was starting at 10 and then putting all the elements smaller than 10 in queue till reach a higher number than a[i]
 * This solution looked promising but then realised it might not work also even if it works would O(n^2) when numbers are reverse sorted.
 * 3. Then i thought rather than putting all the numbers smaller, i tried putting 10 in stack if it greater than next number, so that i can check it later.
 * And that worked. So i compared i and i + 1 numbers, if i is smaller than i + 1 number then a[i + 1] is the answer for i and compare the elements in the stack
 * to see if there is any number which is also smaller than a[i + 1], if yes a[i+1] is also the answer for that, and pop that number out.
 * If a[i] > a[i+] then just put i in the stack hoping that later there might be a number which might be greater than a[i].
 * This solved it in O(n).
 * Created by adib on 9/23/16.
 */
public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        if ( a == null || a.size() == 0)
            return a;
        int i = 0;
        int len = a.size();
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        while ( i < len - 1) {
            int elem = a.get(i);
            int nextElem = a.get(i + 1);
            if ( elem < nextElem) {
                result.add(nextElem);
                while ( !stack.isEmpty() && a.get(stack.peek()) < nextElem) {
                    result.set(stack.pop(), nextElem);
                }
            } else {
                stack.push(i);
                result.add(-1);
            }
            i++;
        }
        result.add(-1);
        return result;
    }
}
