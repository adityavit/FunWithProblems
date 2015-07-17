package sumRootToLeaf;

import isBST.TreeNode;

/**
 * Created by adib on 7/16/15.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }

    private int findSum(TreeNode root, int sum) {
        if(root == null)
            return sum;
        //Value for the current Node will right shifting the sum from above and adding root.val
        int currentSum = sum*10 + root.val;
        //For leaf nodes this would be currentSum calculated till this node.
        if(root.left == null && root.right == null)
            return currentSum;
        int leftSum = 0 ,rightSum = 0;
        //If left child is null then don't consider that.
        //Pass currentSum recursively so that it can be used to calculate the sum of the left and right node.
        if (root.left != null)
            leftSum = findSum(root.left, currentSum);
        //If right child is null sum from that node will be zero.
        if (root.right != null)
            rightSum = findSum(root.right, currentSum);

        return leftSum + rightSum;
    }
}
