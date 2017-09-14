package EPI.Trees.HeightBalanced;

import isBST.TreeNode;
import treeProblems.common.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adib on 6/25/17.
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] treeValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 14, 15};
        List<Integer> treeList = Arrays.asList(treeValues);
        TreeNode root = TreeNode.createTree(treeList);
        TreeUtil.printTreeNode(root);
        boolean isBal = isHeightBalancedTree(root);
        System.out.println("isBal = " + isBal);
        int maxHeight = isHeightBalancedTreeRec(root);
        System.out.println("maxHeight = " + maxHeight);
    }

    public static boolean isHeightBalancedTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int height = isHeightBalancedTreeRec(root);
        if (height < 0)
            return false;
        return true;
    }

    private static int isHeightBalancedTreeRec(TreeNode root) {
        if (root == null)
            return 0;
        int leftTreeHeight = isHeightBalancedTreeRec(root.left);
        int rightTreeHeight = isHeightBalancedTreeRec(root.right);
        if (leftTreeHeight < 0 || rightTreeHeight < 0)
            return -1;
        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1)
            return -1;
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

}
