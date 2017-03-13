package treeProblems.bsIterator;

import isBST.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by adib on 8/8/16.
 */
public class BSTIterator {
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    public boolean hasNext() {
        if (stack.size() == 0) {
            return false;
        }
        return true;
    }

    public int next() {
        TreeNode topStackNode = stack.pop();
        TreeNode temp = topStackNode.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return topStackNode.val;
    }
}
