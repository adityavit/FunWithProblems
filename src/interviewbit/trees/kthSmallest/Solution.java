package interviewbit.trees.kthSmallest;

import isBST.TreeNode;

/**
 * Easy Problem with O(n) solution.Pass a count of the node to the sub trees, If the count is equal to k, then we got the solution.
 * The problem is passing around the reference for the count, I have used a trick to create and array of 1 element which stores the count.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 *
 * Follow up question.
 *
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * If we are allowed to modify the TreeNode structure, it would better if we can store the size of the sub tree in the node.
 * This will make the solution O(height of the tree), as we can then check the left node size to see if we have to go to the left or not.
 *
 * Created by adib on 10/3/16.
 */
public class Solution {
    public int kthsmallest(TreeNode root, int k) {
        if ( root == null ) {
            return -1;
        }
        Integer[] count = {0};
        return kthsmallestRecursive(root, k, count);
    }

    public Integer kthsmallestRecursive(TreeNode root, int k, Integer[] count) {
        if (root == null)
            return null;
        Integer leftSmallest = null;
        if (root.left != null) {
            leftSmallest = kthsmallestRecursive(root.left, k , count);
        }
        if (leftSmallest != null)
            return leftSmallest;
        count[0] = count[0] + 1;
        if (count[0] == k) {
            return root.val;
        }
        return kthsmallestRecursive(root.right, k , count);
    }
}
