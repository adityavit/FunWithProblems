package interviewbit.trees.maxDepth;

import isBST.TreeNode;

/**
 * https://www.interviewbit.com/problems/max-depth-of-binary-tree/
 * Created by adib on 10/9/16.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftMaxPath = maxDepth(root.left);
        int rightMaxPath = maxDepth(root.right);
        return Math.max(leftMaxPath, rightMaxPath) + 1;
    }
}
