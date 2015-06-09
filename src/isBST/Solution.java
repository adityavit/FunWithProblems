package isBST;

/**
 * Created by adib on 6/7/15.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNodeBox prev = new TreeNodeBox(null);
        return inorderTraverse(root, prev);
    }
    private class TreeNodeBox {
        public TreeNode prev;
        public TreeNodeBox(TreeNode prev) {
            this.prev = prev;
        }
        public void setPrev(TreeNode prev){
            this.prev = prev;
        }
        public TreeNode getPrev() {
            return prev;
        }
    }
    public boolean inorderTraverse(TreeNode root, TreeNodeBox prevBox) {
        if (root == null)
            return true;
        if (!inorderTraverse(root.left, prevBox))
            return false;
        TreeNode prev = prevBox.getPrev();
        if (prev != null) {
            if (root.val <=  prev.val)
                return false;
        }
        prevBox.setPrev(root);
        if (!inorderTraverse(root.right, prevBox))
            return false;
        return true;
    }
}
