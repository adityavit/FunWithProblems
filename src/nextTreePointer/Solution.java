package nextTreePointer;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
     public void connect(TreeLinkNode root) {
        if (root == null) {
             return;
        }
        // System.out.println(root);
//          TreeLinkNode left = root.left;
//          TreeLinkNode right = root.right;
//        if (left != null) {
//             left.next = right;
//        }
//        if (right != null) {
//             if(root.next != null) {
//                 right.next = root.next.left;
//             } else {
//                 right.next = null;
//             }
//        }
//        connect(left);
//        connect(right);
    }
}