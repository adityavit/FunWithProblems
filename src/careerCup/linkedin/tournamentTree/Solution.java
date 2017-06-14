package careerCup.linkedin.tournamentTree;

import isBST.TreeNode;

/**
 * Created by adib on 4/12/17.
 * https://www.careercup.com/question?id=5196022759292928
 * A tournament tree is a binary tree
 * where the parent is the minimum of the two children.
 * Given a tournament tree find the second minimum value in the tree.
 * A node in the tree will always have 2 or 0 children.
 * Also all leaves will have distinct and unique values.
 * 2
 * / \
 * 2 3
 * / \ | \
 * 4 2 5 3
 *
 * In this given tree the answer is 3.
 */

class Solution {
    /**
     * This should return the second minimum
     * int value in the given tournament tree
     */
    public static Integer secondMin(TreeNode root) {
        if ( root == null ) {
            return null;
        }
        Integer secondMin = secondMinRec(root);
        return secondMin == root.val? null: secondMin;
    }

    private static Integer secondMinRec(TreeNode root) {
        if (root.left != null && root.right != null) {
            if (root.left.val < root.right.val) {
                Integer secondMinLeft = secondMinRec(root.left);
                return (secondMinLeft == root.val)? root.right.val: Math.min(secondMinLeft, root.right.val);
            } else if(root.left.val > root.right.val) {
                Integer secondMinRight = secondMinRec(root.right);
                return (secondMinRight == root.val)? root.left.val: Math.min(root.left.val, secondMinRight);
            }
            Integer secondMinRight = secondMinRec(root.right);
            Integer secondMinLeft = secondMinRec(root.left);
            return (secondMinRight == root.right.val)? secondMinLeft: (secondMinLeft == root.left.val)? secondMinRight: Math.min(secondMinLeft, secondMinRight);

        }
        if (root.left != null) {
            return secondMinRec(root.left);
        }

        if ( root.right != null) {
            return secondMinRec(root.right);
        }

        return root.val;
    }
}
