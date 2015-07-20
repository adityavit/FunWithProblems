package sameTree;

import isBST.TreeNode;

/**
 * Created by adib on 7/19/15.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //base cases.
        // Both the tree have the node as null, return true.
        if(p == null && q == null)
            return true;
        //If one of the tree is null then return false.
        if(p == null || q == null)
            return false;
        //If values are equal. Compare the left and right sub tree.
        if(p.val == q.val) {
            //If the left sub trees are not same
            if(!isSameTree(p.left, q.left))
                return false;
            if(!isSameTree(p.right, q.right))
                return false;
            //if both are same return true.
            return true;
        } else {
            //values not equal return false.
            return false;
        }
    }
}
