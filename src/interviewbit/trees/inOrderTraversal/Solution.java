package interviewbit.trees.inOrderTraversal;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/inorder-traversal/
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Implemented using a Stack.
 * Created by adib on 10/8/16.
 */
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        //If not using recursion use stack.
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode leftNode = root;
        while (leftNode != null) {
            stack.push(leftNode);
            leftNode = leftNode.left;
        }
        while (stack.size() != 0) {
            TreeNode elem = stack.pop();
            result.add(elem.val);
            elem = elem.right;
            while (elem != null) {
                stack.push(elem);
                elem = elem.left;
            }
        }
        return result;
    }
}
