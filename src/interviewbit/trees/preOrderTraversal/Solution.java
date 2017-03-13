package interviewbit.trees.preOrderTraversal;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Pre order traversal is simple. Use a stack.
 * Insert the root. Then pop the root, push the right child of the popped node if present and then push the left child if present.
 * Right is pushed first because preorder is root left right so right should be the last one accessed.
 * Created by adib on 10/9/16.
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(stack.size() > 0) {
            TreeNode topNode = stack.pop();
            result.add(topNode.val);
            //Insert the right first and then the left. As left should be popped out first.
            if (topNode.right != null) {
                stack.push(topNode.right);
            }
            if (topNode.left != null) {
                stack.push(topNode.left);
            }
        }
        return result;
    }
}
