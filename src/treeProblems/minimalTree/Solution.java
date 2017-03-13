package treeProblems.minimalTree;

import isBST.TreeNode;

/**
 * Created by adib on 7/25/16.
 */
public class Solution {
    public TreeNode minimalTree(int[] elems) {
        if (elems == null || elems.length == 0)
            return null;
        return minimalTreeRecursive(elems, 0, elems.length - 1);
    }

    public TreeNode minimalTreeRecursive(int[] elems, int startIndex, int endIndex) {
        if ( endIndex - startIndex < 0) {
            return null;
        }
        if ( endIndex - startIndex == 0) {
            return new TreeNode(elems[startIndex]);
        }
        int midIndex = startIndex + (endIndex - startIndex)/2;
        TreeNode root = new TreeNode(elems[midIndex]);
        root.left = minimalTreeRecursive(elems, startIndex, midIndex - 1);
        root.right = minimalTreeRecursive(elems, midIndex + 1, endIndex);
        return root;
    }
}
