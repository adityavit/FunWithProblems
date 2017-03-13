package interviewbit.trees.nextRightPointer;

/**
 * https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * This problem is not that hard to solve if you realize that next nodes for the level + 1 can be formed when you iterate over the linked list formed
 * at level.
 * So iterate over the linked list in level and then mark the head of the next linked list in the level + 1.
 * As you iterate over the linked list if both the left and right are present join them.
 * If right is present then that becomes the last node else if left is present that becomes the last node.
 * No associate the next of the last node to the next node left or right in the level depending upon which one is present.
 * Created by adib on 10/8/16.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if ( root == null ) {
            return;
        }
        //level Head for each level Linked list
        TreeLinkNode levelHead = root;
        TreeLinkNode nextLinkPtr;
        while (levelHead != null) {
            // Assign the nextLinkPtr pointer to levelHead as the start of the level Linked List.
            nextLinkPtr = levelHead;
            //Iterate over the level Linked list.
            TreeLinkNode lastNode = null;
            while (nextLinkPtr != null) {
                //If the last node is present. Assign the last node to the left child if present else to the right child.
                if (lastNode != null) {
                    if ( nextLinkPtr.left != null) {
                        lastNode.next = nextLinkPtr.left;
                    } else {
                        lastNode.next = nextLinkPtr.right;
                    }
                } else {
                    //Reassign levelHead as the first left child of the nextLinkPtr if present else would be right child.
                    //If it is not set assign the level head to nexLinkPtr left or right.
                    if (nextLinkPtr.left != null) {
                        levelHead = nextLinkPtr.left;
                    } else {
                        levelHead = nextLinkPtr.right;
                    }
                }
                if (nextLinkPtr.left != null && nextLinkPtr.right != null) {
                    nextLinkPtr.left.next = nextLinkPtr.right;
                }
                // Assign the the last node as the left node if it is present.
                if (nextLinkPtr.right != null) {
                    lastNode = nextLinkPtr.right;
                } else if (nextLinkPtr.left != null) {
                    lastNode = nextLinkPtr.left;
                }
                nextLinkPtr = nextLinkPtr.next;
            }
        }
    }


    public class TreeLinkNode {
        int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
     }
}
