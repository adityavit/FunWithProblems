package interviewbit.trees.sortedArrayToBST;

import isBST.TreeNode;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
 * Created by adib on 10/2/16.
 * @accepted
 */
public class Solution {
    public TreeNode sortedArrayToBST(final List<Integer> elems) {
        if (elems == null || elems.size() == 0)
            return null;
        return sortedArrayToBSTRecursive(elems, 0 , elems.size() - 1);
    }
    public TreeNode sortedArrayToBSTRecursive(List<Integer> elems, int startI, int endI) {
        if (startI > endI)
            return null;
        if (startI == endI)
            return new TreeNode(elems.get(startI));
        //This is the same way you have to find mid point in binary search and quick sort.
        int mid = (endI + startI)/2;
        TreeNode currentNode = new TreeNode(elems.get(mid));
        currentNode.left = sortedArrayToBSTRecursive(elems, startI, mid - 1);
        currentNode.right = sortedArrayToBSTRecursive(elems, mid + 1, endI);
        return currentNode;
    }
}
