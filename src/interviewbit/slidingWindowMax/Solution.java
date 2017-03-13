package interviewbit.slidingWindowMax;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adib on 9/18/16.
 */
public class Solution {

public int[] maxSlidingWindow(int[] nums, int b) {
    if ( nums == null || nums.length == 0 ) {
        return nums;
    }
    if ( b == 0) {
        return nums;
    }
    Deque<Integer> sortQueue = new LinkedList<>();
    int startIndex = 0;
    int len = nums.length;
    int endIndex = Math.min(b - 1, len - 1);
    int i = 0;
    while ( i <= endIndex) {
        //Initial b elements.
        int elem = nums[i];
        if ( i == 0 ) {
            sortQueue.addLast(elem);
            i++;
            continue;
        }
        if (elem > sortQueue.peekLast()) {
            sortQueue.clear();
            sortQueue.addLast(elem);
        } else {
            while (sortQueue.peekFirst() < elem ) {
                sortQueue.pollFirst();
            }
            sortQueue.addFirst(elem);
        }
        i++;
    }
    int[] result = new int[len - b + 1];
    result[0] = sortQueue.peekLast();
    if ( b > len) {
        return result;
    }
    endIndex++;
    startIndex = 1;
    while (endIndex < len) {
        int addingElem = nums[endIndex];
        int removingElem = nums[startIndex - 1];
        // If the removing element is last of the queue remove it. Else don't worry.
        if ( removingElem == sortQueue.peekLast() ) {
            sortQueue.pollLast();
        }

        if ( sortQueue.size() == 0 || addingElem > sortQueue.peekLast()) {
            sortQueue.clear();
            sortQueue.addLast(addingElem);
        } else {
            while (sortQueue.peekFirst() < addingElem ) {
                sortQueue.pollFirst();
            }
            sortQueue.addFirst(addingElem);
        }
        result[startIndex] = sortQueue.peekLast();
        endIndex++;
        startIndex++;
    }
    return result;
}

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( a == null || a.size() == 0 ) {
            return result;
        }
        if ( b == 0) {
            return new ArrayList<Integer>(a);
        }
        Deque<Integer> sortQueue = new LinkedList<>();
        int startIndex = 0;
        int len = a.size();
        int endIndex = Math.min(b - 1, len - 1);
        int i = 0;
        while ( i <= endIndex) {
            //Initial b elements.
            int elem = a.get(i);
            if ( i == 0 ) {
                sortQueue.addLast(elem);
                i++;
                continue;
            }
            if (elem > sortQueue.peekLast()) {
                sortQueue.clear();
                sortQueue.addLast(elem);
            } else {
                while (sortQueue.peekFirst() < elem ) {
                    sortQueue.pollFirst();
                }
                sortQueue.addFirst(elem);
            }
            i++;
        }
        result.add(sortQueue.peekLast());
        if ( b > len) {
            return result;
        }
        endIndex++;
        startIndex = 1;
        while (endIndex < len) {
            int addingElem = a.get(endIndex);
            int removingElem = a.get(startIndex - 1);
            // If the removing element is last of the queue remove it. Else don't worry.
            if ( removingElem == sortQueue.peekLast() ) {
                sortQueue.pollLast();
            }

            if ( sortQueue.size() == 0 || addingElem > sortQueue.peekLast()) {
                sortQueue.clear();
                sortQueue.addLast(addingElem);
            } else {
                while (sortQueue.peekFirst() < addingElem ) {
                    sortQueue.pollFirst();
                }
                sortQueue.addFirst(addingElem);
            }
            result.add(sortQueue.peekLast());
            endIndex++;
            startIndex++;
        }
        return result;
    }
}

