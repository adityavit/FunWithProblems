package linkedList.removeDuplicates;

import linkedList.common.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adib on 6/4/16.
 */
public class Solution {

    //Time Complexity : O(n)
    //Space Complexity: O(n)
    public void removeDuplicates(Node head) {
        Set<Node> nodeSet = new HashSet<Node>();

        Node pointer = head;
        while(pointer != null) {
            nodeSet.add(pointer);
            Node nextPointer = pointer.next;
            while(nextPointer != null && nodeSet.contains(nextPointer)) {
                // remove nextPointer from the list
                pointer.next = nextPointer.next;
                nextPointer = pointer.next;
            }
            pointer = pointer.next;
        }
    }
}
