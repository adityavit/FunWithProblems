package interviewbit.trees.pathSum;

import isBST.TreeNode;

/**
 * Some Wrong assumptions i took, in solving this wrongly,be careful next time.
 * 1. sum can be negative.
 * 2. The question says from root to leaf, leaf has both left and right null, so check only on the leaf nodes.
 * Created by adib on 10/9/16.
 */
public class Solution {
    /**
     * accepted
     * @param root
     * @param sum
     * @return
     */
    public int hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int diff = sum - root.val;
        if (root.left == null && root.right == null && diff == 0){
            return 1;
        }
        int leftPath = hasPathSum(root.left, diff);
        int rightPath =  hasPathSum(root.right, diff);
        return (leftPath == 1 || rightPath == 1) ? 1: 0;
    }
}
