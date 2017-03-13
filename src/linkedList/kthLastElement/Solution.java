package linkedList.kthLastElement;

import linkedList.common.Node;

/**
 * Created by adib on 6/4/16.
 */
public class Solution {

    public Node findkthLastElement(Node head, int k) {
        Node pointer = head;
        Node kthPointer = null;
        int count = 0;
        while ( pointer != null) {
            count++;
            if( count == k) {
                kthPointer = head;
            }
            pointer = pointer.next;
            if ( kthPointer != null && pointer != null) {
                //Pointer != null condition is needed because the kth pointer should not be moved if the pointer was in the last element already.
                // Considers the edge case of 1 miss when the kth pointer points to k - 1 from the last.
                kthPointer = kthPointer.next;
            }
        }
        return kthPointer;
    }

    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     * @param head
     * @param k
     */
    public void removeNthFromEnd(Node head, int k) {

    }
}
