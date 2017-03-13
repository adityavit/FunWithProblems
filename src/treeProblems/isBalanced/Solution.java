package treeProblems.isBalanced;

import isBST.TreeNode;

/**
 * Created by adib on 7/26/16.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(checkBalancedRecursive(root) < 0) {
            return false;
        }

        return true;
    }

    private int checkBalancedRecursive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftTreeHeight = checkBalancedRecursive(root.left);
        int rightTreeHeight = checkBalancedRecursive(root.right);

        if (leftTreeHeight < 0 || rightTreeHeight < 0) {
            return -1;
        }
        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
            return -1;
        }
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
