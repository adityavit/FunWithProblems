package facebookPractice.binaryTreeVerticalOrderTraversal;

import isBST.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * Created by adib on 11/14/16.
 */
public class Solution {

    private static class VerticalNode {
        TreeNode node;
        Integer colNum;
        public VerticalNode(TreeNode root, Integer val){
            node = root;
            colNum = val;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null )
            return result;
        Map<Integer, List<Integer>> resultMap = new TreeMap<>();
        Deque<VerticalNode> queue = new LinkedList<>();
        queue.addLast(new VerticalNode(root, 0));
        while (!queue.isEmpty()) {
            VerticalNode node = queue.pollFirst();
            List<Integer> colList;
            if (resultMap.containsKey(node.colNum)) {
                colList = resultMap.get(node.colNum);
            } else {
                colList = new ArrayList<>();
                resultMap.put(node.colNum, colList);
            }
            colList.add(node.node.val);
            if (node.node.left != null) {
                queue.addLast(new VerticalNode(node.node.left, node.colNum - 1));
            }
            if (node.node.right != null) {
                queue.addLast(new VerticalNode(node.node.right, node.colNum + 1));
            }
        }
        for (Integer columnVal: resultMap.keySet()) {
            result.add(resultMap.get(columnVal));
        }
        return result;
    }
    /**
     * Doesn't work with DFS traversal
     * [3,9,8,4,0,1,7,null,null,null,2,5]
     * Output :[[4],[9,5],[3,0,1],[2,8],[7]]
     * expected: [[4],[9,5],[3,0,1],[8,2],[7]]
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrderNotWork(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null )
            return result;
        Map<Integer, List<Integer>> resultMap = new TreeMap<>();
        verticalOrderTraversal(root, resultMap, 0);
        for (Integer columnVal: resultMap.keySet()) {
            result.add(resultMap.get(columnVal));
        }
        return result;
    }
    private void verticalOrderTraversal(TreeNode root, Map<Integer, List<Integer>> resultMap, int columnNumber) {
        if (root == null)
            return;
        List<Integer> colList;
        if (resultMap.containsKey(columnNumber)) {
            colList = resultMap.get(columnNumber);
        } else {
            colList = new ArrayList<>();
            resultMap.put(columnNumber, colList);
        }
        colList.add(root.val);
        verticalOrderTraversal(root.left, resultMap, columnNumber - 1);
        verticalOrderTraversal(root.right, resultMap, columnNumber + 1);
    }
}
