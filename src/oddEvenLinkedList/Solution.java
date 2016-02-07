package oddEvenLinkedList; 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null)
            return null;

        ListNode current = head;
        ListNode evenListHead = null;
        int counter = 1;

        while(current != null) {
            if(counter == 2) {
                evenListHead = current;
            }

            //assign current.next to something else
            ListNode next = current.next;

            //Check if next to next is present.
            //If yes make the current.next to current.next.next i.e skip one.
            if(current.next != null && current.next.next != null) {
                current.next = current.next.next;
            } else {
                //In case there is no next or next.next
                //This condition is easy to forget, so go till the end of test case to see it.
                current.next = null;
            }
            current = next;
            counter++;
        }
        //Iterate over the odd list and add evenlist at the end
        current = head;
        while(current != null && current.next != null) {
            current = current.next;
        }
        current.next = evenListHead;
        return head;
    }
}