package interviewbit.graphs.levelOrder;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/level-order/
 * A simple BFS using queue.
 * Another way to do this is using DFS recursion and passing the level as an argument which can be used to index the list in the result.
 * Created by adib on 11/5/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        int levelSize = 1;
        queue.addLast(root);
        while(queue.size() != 0) {
            int nextLevelSize = 0;
            ArrayList<Integer> level = new ArrayList<>();
            for ( int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                level.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                    nextLevelSize++;
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                    nextLevelSize++;
                }
            }
            result.add(level);
            levelSize = nextLevelSize;
        }
        return result;
    }
}
