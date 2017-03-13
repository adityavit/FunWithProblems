package interviewbit.trees.invertBinaryTree;

import isBST.TreeNode;

/**
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 * Easy problem, just swap the left and right recursively.
 * Created by adib on 10/6/16.
 * @accepted
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
