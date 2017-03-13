package leetcode.BinaryTreeUpsideDown;

import isBST.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 * Created by adib on 10/25/16.
 * @accepted
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        if (newRoot == null) {
            return root;
        }
        root.left.left = upsideDownBinaryTree(root.right);
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
