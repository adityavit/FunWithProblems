package interviewbit.trees.balancedBinaryTree;

import isBST.TreeNode;

/**
 * https://www.interviewbit.com/problems/balanced-binary-tree/
 * Easy Problem.
 * Check for the left and check for the right sub tree height.
 * Check if the leftSubtreeHeight - rightSubTreeHeight > 1
 * Created by adib on 10/2/16.
 * @accepted
 */
public class Solution {
    public int isBalanced(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int result = isBalancedRecursive(root);
        return result >= 0? 1:0;
    }

    private int isBalancedRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubTreeHeight = isBalancedRecursive(root.left);
        if (leftSubTreeHeight < 0)
            return -1;
        int rightSubTreeHeight = isBalancedRecursive(root.right);
        if (rightSubTreeHeight < 0)
            return -1;
        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1)
            return -1;
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}
