package interviewbit.trees.zigZaglevelOrderTraversal;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
 * Solved this problem iteratively using a Deque, although iteratively it can be solved using two stacks too.
 * Can be solved recursively too. And that is good exercise to do.
 * Created by adib on 10/8/16.
 * Time: O(n) -- As it visits all the nodes.
 * Space: O(n) -- At certain point the queue will have all the nodes in the level, nodes in a level 2^level == 2 ^ log n == n.
 * @accepted
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        //Add the elements to the front side of the queue and remove from the back side.
        boolean addFrontSide = false;
        int previousLevelCount = 1;
        queue.add(root);
        while(queue.size() > 0) {
            int levelCount = 0;
            ArrayList<Integer> levelElems = new ArrayList<>();
            if (addFrontSide) {
                // get the element from the back of the queue and add the element to the front of the queue.
                while (previousLevelCount > 0) {
                    TreeNode elem = queue.pollLast();
                    levelElems.add(elem.val);
                    //If adding from the front add the right first.
                    if (elem.right != null) {
                        queue.addFirst(elem.right);
                        levelCount++;
                    }
                    if (elem.left != null) {
                        queue.addFirst(elem.left);
                        levelCount++;
                    }
                    previousLevelCount--;
                }
            } else {
                // get the element from the front and add the element to the back
                while (previousLevelCount > 0) {
                    TreeNode elem = queue.pollFirst();
                    levelElems.add(elem.val);
                    if (elem.left != null) {
                        queue.addLast(elem.left);
                        levelCount++;
                    }
                    if (elem.right != null) {
                        queue.addLast(elem.right);
                        levelCount++;
                    }
                    previousLevelCount--;
                }
            }
            addFrontSide = !addFrontSide;
            previousLevelCount = levelCount;
            result.add(levelElems);
        }
        return result;
    }
}
