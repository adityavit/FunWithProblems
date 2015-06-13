package invertBinaryTree;
import isBST.TreeNode;

/**
 * Created by adib on 6/13/15.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        //Creates a new root element.
        TreeNode invertedTree = new TreeNode(root.val);
        //Assigns the left child to the inverted right child.
        invertedTree.left = invertTree(root.right);
        //Assigns the right child to the inverted left child.
        invertedTree.right = invertTree(root.left);
        return invertedTree;
    }
}
