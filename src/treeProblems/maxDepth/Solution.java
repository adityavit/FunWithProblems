package treeProblems.maxDepth;

import isBST.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Accepted
 * Created by adib on 8/1/16.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepthRecursive(root, 0);
    }

    private int maxDepthRecursive(TreeNode root, int depth) {
        if (root == null)
            return depth;
        int leftDepth = maxDepthRecursive(root.left, depth + 1);
        int rightDepth = maxDepthRecursive(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }
}
