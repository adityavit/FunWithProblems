package linkedList.partitionList;

import linkedList.common.Node;

/**
 * Created by adib on 6/4/16.
 */
public class Solution {

    public Node partition(Node head, int k) {
        if(head == null) {
            return null;
        }
        Node pointer = head.next;
        Node previous = head;

        while (pointer != null) {
            if (pointer.getData() < k) {
                previous.next = pointer.next;
                pointer.next = head;
                head = pointer;
                pointer = previous.next;
            } else {
                previous = pointer;
                pointer = pointer.next;
            }
        }

        return head;
    }
}
