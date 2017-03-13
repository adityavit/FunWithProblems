package interviewbit.trees.InorderPreOrderToBinaryTree;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * O(n^2) algorithm in the worst case solution like left skewed tree.
 * How to optimize it: extra n is coming because we are trying to find the index in the inorder array.
 * We can reduce that by using an extra space of O(n) a map which has value to index mapping. That will give O(n) complexity.
 * Created by adib on 10/2/16.
 */
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if (preorder == null || inorder == null || preorder.size() == 0 || inorder.size() == 0)
            return null;
        return buildTreeRecursiver(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1 );
    }

    public TreeNode buildTreeRecursiver(List<Integer> preorder, int preStartI, int preEndI, List<Integer> inorder, int inStartI, int inEndI) {
        if (inStartI > inEndI)
            return null;
        if (inStartI == inEndI)
            return new TreeNode(inorder.get(inStartI));

        int rootValue = preorder.get(preStartI);
        //find the index of rootValue in inorder array.
        int index = inStartI;
        while(inorder.get(index) != rootValue) {
            index++;
        }
        int leftSubTreeSize = index - inStartI;
        TreeNode currentNode = new TreeNode(rootValue);
        if (leftSubTreeSize > 0) {
            currentNode.left = buildTreeRecursiver(preorder, preStartI + 1, preStartI + leftSubTreeSize, inorder, inStartI, index - 1);
        }
        currentNode.right = buildTreeRecursiver(preorder,  preStartI + leftSubTreeSize + 1 , preEndI, inorder, index + 1, inEndI);
        return currentNode;
    }
}
