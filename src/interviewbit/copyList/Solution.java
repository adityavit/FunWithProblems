package interviewbit.copyList;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/copy-list/
 * Created by adib on 9/26/16.
 */

/**
 * Another approach found in the Hints
 * Approach 2 : Using 2 traversals of the list.
 * Step 1: create a new node for each existing node and join them together eg: A->B->C will be A->A’->B->B’->C->C’
 * Step2: copy the random links: for each new node n’, n’.random = n.random.next
 * Step3: detach the list: basically n.next = n.next.next; n’.next = n’.next.next
 */
public class Solution {

    private static class RandomListNode{
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    /**
     * Iterative solution is slightly harder to write.
     * But it becomes easy, if you do the mapping of next and random pointers separately.
     * So algorithm is still O(n), and stack is not an issue then.
     * @param head
     * @return
     * @accepted
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        //Converts the node from old linkedList -> new Linked List
        Map<RandomListNode, RandomListNode> nodeConversionMap = new HashMap<>();
        RandomListNode newListHead = null;
        RandomListNode oldListHeadIt = head;
        RandomListNode newListHeadIt = null;
        //Copy the next pointers
        while(oldListHeadIt != null) {
            RandomListNode newNode = new RandomListNode(oldListHeadIt.label);
            if (newListHead == null) {
                newListHead = newNode;
            } else {
                newListHeadIt.next = newNode;
            }
            nodeConversionMap.put(oldListHeadIt, newNode);
            newListHeadIt = newNode;
            oldListHeadIt = oldListHeadIt.next;
        }

        oldListHeadIt = head;
        newListHeadIt = newListHead;
        //copy the random pointers.
        while(oldListHeadIt != null) {
            RandomListNode randomNode = oldListHeadIt.random;
            RandomListNode newNodeRandomRef = null;
            if (randomNode != null) {
                newNodeRandomRef = nodeConversionMap.get(randomNode);
            }
            newListHeadIt.random = newNodeRandomRef;
            newListHeadIt = newListHeadIt.next;
            oldListHeadIt = oldListHeadIt.next;
        }
        return newListHead;
    }

    /**
     * I tried first with the recursive solution, but it gave stack overflow.
     * In the recursive solution stack size was coming out to be length of the list O(n)
     * @param head
     * @param nodeConversionMap
     * @return
     */
    public RandomListNode deepCopyRec(RandomListNode head, Map<RandomListNode, RandomListNode> nodeConversionMap) {
        if (head == null) {
            return null;
        }
        if ( nodeConversionMap.containsKey(head)) {
            return nodeConversionMap.get(head);
        }
        RandomListNode newNode = new RandomListNode(head.label);
        nodeConversionMap.put(head, newNode);
        newNode.next = deepCopyRec(head.next, nodeConversionMap);
        newNode.random = deepCopyRec(head.random, nodeConversionMap);
        return newNode;
    }
}
