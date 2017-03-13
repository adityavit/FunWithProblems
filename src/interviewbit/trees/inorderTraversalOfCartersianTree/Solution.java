package interviewbit.trees.inorderTraversalOfCartersianTree;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
 * Created by adib on 10/2/16.
 * @accepted
 */
public class Solution {

    /**
     * O(n^2) algorithm, couldn't find a better algorithm to solve this.
     * Find the highest value between start to end indexes and that becomes the root.
     * The left side becomes the left tree, and the right side becomes the right tree.
     * @param elems
     * @return
     */
    public TreeNode buildTree(ArrayList<Integer> elems) {
        if (elems == null || elems.size() == 0)
            return null;
        return buildTreeRecursive(elems, 0, elems.size() -1);
    }

    public TreeNode buildTreeRecursive(List<Integer> elems, int startI, int endI) {
        if (startI > endI)
            return null;
        if (startI == endI)
            return new TreeNode(elems.get(startI));
        int maxElem = elems.get(startI);
        int maxI = startI;
        int i = startI + 1;
        while(i <= endI){
            if (elems.get(i) > maxElem){
                maxI = i;
                maxElem = elems.get(maxI);
            }
            i++;
        }
        TreeNode currentNode = new TreeNode(maxElem);
        currentNode.left = buildTreeRecursive(elems, startI, maxI - 1);
        currentNode.right = buildTreeRecursive(elems, maxI + 1, endI);
        return currentNode;
    }
}
