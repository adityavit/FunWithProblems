package interviewbit.trees.flattenBinaryTreeToLinkedList;

import isBST.TreeNode;

/**
 * https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Iterate over the tree.
 * Return the last node of the linked list from the left and right sub tree.
 * The last node will be used to attach the right linked list to the tree.
 * If the leftEndlist is present, then make left sub tree as the right child of the root
 * Attach right subtree to the last node of the left linked list.
 * return end of the right sub list if present else return the left sut list.
 *
 * time: O(n), As we visit each node only once.
 * space: O(n), Worst case balanced binary tree will have stack of O(log n)
 * Created by adib on 10/10/16.
 * @accepted
 */
public class Solution {
    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        flattenRecursive(root);
        return root;
    }

    private TreeNode flattenRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftListEndNode = flattenRecursive(root.left);
        TreeNode rightListEndNode = flattenRecursive(root.right);
        if (leftListEndNode != null) {
            leftListEndNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightListEndNode != null? rightListEndNode:leftListEndNode;
    }
}
