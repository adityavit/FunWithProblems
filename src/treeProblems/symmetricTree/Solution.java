package treeProblems.symmetricTree;

import isBST.TreeNode;

/**
 * Created by adib on 8/7/16.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmtricHelper(root.left, root.right);
    }

    public boolean isSymmtricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return isSymmtricHelper(left.left, right.right) && isSymmtricHelper(left.right, right.left);
    }
}

