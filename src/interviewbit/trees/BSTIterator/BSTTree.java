package interviewbit.trees.BSTIterator;

import isBST.TreeNode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/bst-iterator/
 * Solved this question by creating implementing iterable and Iterator interface.
 * Created by adib on 10/5/16.
 */
public class BSTTree implements Iterable<Integer> {

    TreeNode root;

    public BSTTree(TreeNode root) {
        this.root = root;
    }

    private static class BSTIterator implements Iterator<Integer>{
        Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

            /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return stack.size() > 0;
        }

        /** @return the next smallest number */
        public Integer next() {
            TreeNode smallest = stack.pop();
            TreeNode rightNode = smallest.right;
            while (rightNode != null) {
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
            return smallest.val;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new BSTIterator(root);
    }
}
