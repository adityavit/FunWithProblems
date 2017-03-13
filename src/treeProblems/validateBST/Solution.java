package treeProblems.validateBST;

import isBST.TreeNode;

/**
 * Created by adib on 7/30/16.
 */
public class Solution {

    private class TreeNodeBox {
        public TreeNode node;
        public TreeNodeBox(TreeNode node) {
            this.node = node;
        }
    }

    public boolean validateBST(TreeNode root) {
        return validateBSTRecursive(root, new TreeNodeBox(null));
    }

    private boolean validateBSTRecursive(TreeNode root, TreeNodeBox prev) {
        if (root == null) {
            return true;
        }
        boolean leftSubTreeBST = validateBSTRecursive(root.left, prev);
        if(leftSubTreeBST) {
            if(prev.node != null) {
                if(prev.node.val > root.val) {
                    return false;
                }
            }
            return validateBSTRecursive(root.right, new TreeNodeBox(root));
        }
        return false;
    }
}
