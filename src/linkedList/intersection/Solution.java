package linkedList.intersection;

import linkedList.common.Node;

/**
 * Created by adib on 6/7/16.
 */
public class Solution {

    /**
     * CTCI : 2.7
     * https://leetcode.com/problems/intersection-of-two-linked-lists/
     * @param list1
     * @param list2
     * @return
     */
    public Node findIntersection(Node list1, Node list2) {
        //Case when either of the list is null
        if (list1 == null || list2 == null) {
            return null;
        }

        Node pointer1 = list1;
        Node pointer2 = list2;
        Node pointer3 = null, pointerSmall = null;

        //If both the list are not of the same size truncate the list, which is bigger making it equal to the smaller list.
        while (pointer1 != null || pointer2 != null) {
            if ( pointer1 == null && pointer3 == null) {
                pointer3 = list2;
                pointerSmall = list1;
            }

            if (pointer2 == null && pointer3 == null) {
                pointer3 = list1;
                pointerSmall = list2;
            }

            pointer1 = (pointer1 != null)?pointer1.next:null;
            pointer2 = (pointer2 != null)?pointer2.next:null;
            pointer3 = (pointer3 != null)?pointer3.next:null;
        }
        //Check for the case if the list are of the same size.
        //pointer3 and pointerSmall won't be initialized
        if (pointer3 == null && pointerSmall == null) {
            pointer3 = list1;
            pointerSmall = list2;
        }
        return recursiveIntersection(pointer3, pointerSmall);
    }

    private Node recursiveIntersection(Node list1, Node list2) {
        if ( list1 == list2) {
            return list1;
        }

        return recursiveIntersection(list1.next, list2.next);
    }
}
