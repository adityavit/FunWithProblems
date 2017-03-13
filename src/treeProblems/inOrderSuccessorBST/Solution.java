package treeProblems.inOrderSuccessorBST;

import isBST.TreeNode;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * Created by adib on 8/1/16.
 * Accepted
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode givenNode) {
        if (givenNode == null)
            return null;
        return inorderSuccessorRecursive(root, givenNode, null);
    }

    private TreeNode inorderSuccessorRecursive(TreeNode root, TreeNode givenNode, TreeNode parent) {
        if (root == null) {
            return null;
        }
        if (givenNode.val < root.val) {
            return inorderSuccessorRecursive(root.left, givenNode, root);
        }
        if (givenNode.val == root.val) {
            if (root.right != null) {
                return leftMostTreeNode(root.right);
            }
            return parent;
        }
        return inorderSuccessorRecursive(root.right, givenNode, parent);
    }

    private TreeNode leftMostTreeNode(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return leftMostTreeNode(root.left);
    }
}
