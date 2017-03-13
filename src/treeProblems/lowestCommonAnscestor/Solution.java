package treeProblems.lowestCommonAnscestor;

import isBST.TreeNode;

/**
 * CTCI : 4.8
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Created by adib on 8/6/16.
 * Accepted.
 */
public class Solution {

    private static class MetaBox {
        boolean foundFirstNode;
        boolean foundSecondNode;
        TreeNode ancestor;

        public MetaBox(boolean foundFirstNode, boolean foundSecondNode, TreeNode ancestor) {
            this.foundFirstNode = foundFirstNode;
            this.foundSecondNode = foundSecondNode;
            this.ancestor = ancestor;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return lowestCommonAncestorRecursive(root, p, q, new MetaBox(false, false, null));
    }

    public TreeNode lowestCommonAncestorRecursive (TreeNode root, TreeNode p, TreeNode q, MetaBox meta) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            if (!meta.foundFirstNode) {
                 meta.foundFirstNode = true;
                 meta.ancestor = root;
            } else {
                // Already found first node earlier
                meta.foundSecondNode = true;
                return meta.ancestor;
            }
        }

        TreeNode leftAncestor = lowestCommonAncestorRecursive(root.left, p , q , meta);
        if(leftAncestor != null) {
            return leftAncestor;
        }
        if(meta.foundFirstNode && meta.ancestor == null) {
            // Ancestor got unset by the left sub tree so set it here.
            meta.ancestor = root;
        }
        TreeNode rightAncestor = lowestCommonAncestorRecursive(root.right, p, q, meta);
        if(rightAncestor != null) {
            return rightAncestor;
        }
        if (meta.foundFirstNode && meta.ancestor == root) {
            //Unset the ancestor as it might be above in the tree.
            meta.ancestor = null;
        }
        //return null for the node if doesn't have anything.
        return null;
    }
}
