package linkedList.palindrome;

import linkedList.common.Node;

/**
 * Created by adib on 6/5/16.
 */
public class Solution {

    /**
     * CTCI : 2.6
     * LeetCode: https://leetcode.com/problems/palindrome-linked-list/
     * Checking the palindromic list. Split the list in the middle.
     * If the recurse on the second part, and compare it with the first part.
     * @param list
     * @return
     */
    public boolean checkPalindrome(Node list) {

        Node slowP = list;
        Node fastP = list;

        while (fastP != null) {
            slowP = slowP.next;
            fastP = fastP.next;
            if (fastP != null) {
               fastP = fastP.next;
            }
        }

        Node lastNode = checkPalindromeRecursive(slowP, list);

        if(lastNode == null)
            return false;

        return true;
    }

    private Node checkPalindromeRecursive(Node lastList, Node startList) {
        if (lastList == null) {
            return startList;
        }

        Node startListElem = checkPalindromeRecursive(lastList.next, startList);
        if (startListElem == null) {
            return null;
        }

        if (startListElem.getData() == lastList.getData()) {
            return startListElem.next;
        }

        return null;
    }
}
