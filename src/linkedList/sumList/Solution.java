package linkedList.sumList;

import linkedList.common.Node;

/**
 * Created by adib on 6/4/16.
 */

public class Solution {

    // LeetCode solution really succinct code.
    // Also look at the usage of dummyHead removes the need for the check of result == null

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }
    /**
     * CTCI: 2.5.1
     * LeetCode: https://leetcode.com/problems/add-two-numbers/ (only changed the node type and val type.)
     * @param list1
     * @param list2
     * @return
     */
    public Node sumListReverse(Node list1, Node list2) {
        Node pointer1 = list1;
        Node pointer2 = list2;
        Node result = null, resultPointer = null;
        int carry = 0;

        while(pointer1 != null && pointer2 != null) {
            int sum = pointer1.getData() + pointer2.getData() + carry;
            int sumDigit = sum % 10;
            carry = sum/10;

            if (result == null) {
                result = new Node(sumDigit);
                resultPointer = result;
            } else {
                resultPointer.next = new Node(sumDigit);
                resultPointer = resultPointer.next;
            }

            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        Node remainingPointer = (pointer1 == null)? pointer2 : pointer1;

        if (remainingPointer != null) {
            while (remainingPointer != null) {
                int sum = remainingPointer.getData() + carry;
                int sumDigit = sum%10;
                carry = sum/10;
                if (result == null) {
                    result = new Node(sumDigit);
                    resultPointer = result;
                } else {
                    resultPointer.next = new Node(sumDigit);
                    resultPointer = resultPointer.next;
                }
                remainingPointer = remainingPointer.next;
            }
        }

        if ( carry != 0 ) {
            resultPointer.next = new Node(carry);
        }

        return result;
    }
    
    public Node sumListForward(Node list1, Node list2) {
        Node pointer1 = list1;
        Node pointer2 = list2;

        //Make the list of the same length
        while(pointer1 != null || pointer2 != null) {
            if (pointer1 == null) {
                Node zeroNode = new Node(0);
                zeroNode.next = list1;
                list1 = zeroNode;
            }

            if (pointer2 == null) {
                Node zeroNode = new Node(0);
                zeroNode.next = list2;
                list2 = zeroNode;
            }

            pointer1 = (pointer1 != null)? pointer1.next : null;
            pointer2 = (pointer2 != null)? pointer2.next: null;
        }

        Node result = new Node(0);
        int carry = recursiveSumList(list1, list2, result);
        if (carry != 0) {
            Node carryNode = new Node(carry);
            carryNode.next = result.next;
            result.next = carryNode;
        }
        return result.next;
    }

    private int recursiveSumList(Node list1, Node list2, Node result) {

        if (list1 == null && list2 == null) {
            return 0;
        }

        int carry = recursiveSumList(list1.next, list2.next, result);
        int sum = list1.getData() + list2.getData() + carry;
        int digitSum = sum % 10;
        Node sumNode = new Node(digitSum);
        sumNode.next = result.next;
        result.next = sumNode;
        return sum/10;
    }

}
