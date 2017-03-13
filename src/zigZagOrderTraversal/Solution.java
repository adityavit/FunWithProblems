package zigZagOrderTraversal;


import isBST.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adib on 7/22/15.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //BFS use a Deque as the queue.
        List<List<Integer>> returnList = new ArrayList();
        if(root == null)
            return returnList;
        Deque<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<Integer> levelList = new ArrayList<Integer>();
        returnList.add(levelList);
        int level = 0;
        int numberOfElementsInLevel = 1;
        int numberOfElementsInNextLevel = 0;
        while(!queue.isEmpty()) {
            TreeNode node;
            if(level % 2 == 0) {
                node = queue.removeFirst();
                if(node.left != null) {
                    queue.addLast(node.left);
                    numberOfElementsInNextLevel++;
                }
                if(node.right != null) {
                    queue.addLast(node.right);
                    numberOfElementsInNextLevel++;
                }
                levelList.add(node.val);
                numberOfElementsInLevel--;
            }
            if(level % 2 == 1) {
                node = queue.removeLast();
                if(node.right != null) {
                    queue.addFirst(node.right);
                    numberOfElementsInNextLevel++;
                }

                if(node.left != null) {
                    queue.addFirst(node.left);
                    numberOfElementsInNextLevel++;
                }
                levelList.add(node.val);
                numberOfElementsInLevel--;
            }
            if(numberOfElementsInLevel == 0) {
                if(numberOfElementsInNextLevel > 0) {
                    levelList = new ArrayList<>();
                    returnList.add(levelList);
                }
                level++;
                numberOfElementsInLevel = numberOfElementsInNextLevel;
                numberOfElementsInNextLevel = 0;
            }
        }
        return returnList;
    }
}
