/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean leftBST = true,rightBST = true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if(root == null)
            return true;
        if(root.left != null){
            if(root.left.val < root.val){
                leftBST = isValidBSTHelper(root.left, min, root.val);
            } else {
                leftBST = false;
            }
        }
        if(root.right != null) {
            if(root.right.val > root.val) {
                rightBST = isValidBSTHelper(root.right, root.val, max);
            } else{
                rightBST = false;
            }
        }
        return leftBST && rightBST;
    }

    public boolean isValidBSTHelper(TreeNode node, int min, int max) {
        boolean leftBST = true, rightBST = true;
        if(node == null) {
            return true;
        }
        if(node.left != null) {
            if(node.left.val < node.val && node.left.val > min) {
                leftBST = isValidBSTHelper(node.left, min, node.val);
            } else {
                leftBST = false;
            }
        }
        if(node.right != null) {
            if(node.right.val > node.val && node.right.val < max) {
                rightBST = isValidBSTHelper(node.right, node.val, max);
            } else {
                rightBST = false;
            }
        }
        return leftBST && rightBST;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] treeElements = {3,1,5,0,2,4,6};
        TreeNode tree = TreeBuilder.treeDeSerializer(treeElements);
        System.out.println(sol.isValidBST(tree));
    }
}