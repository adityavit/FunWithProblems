package interviewbit.trees.minDepth;

import isBST.TreeNode;

/**
 * https://www.interviewbit.com/problems/min-depth-of-binary-tree/
 * Min depth is slightly more tricky than maxDepth, as you to take care that only the leaf nodes are considered for the depth and not intermediate nodes.
 * Created by adib on 10/9/16.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftMinHeight = minDepth(root.left);
        int rightMinHeight = minDepth(root.right);
        if (leftMinHeight != 0 && rightMinHeight != 0) {
            return Math.min(leftMinHeight, rightMinHeight) + 1;
        }
        return (leftMinHeight == 0? rightMinHeight: leftMinHeight) + 1;
    }
}
