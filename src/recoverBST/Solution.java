package recoverBST;
import isBST.TreeNode;


/**
 * Created by adib on 6/11/15.
 */
public class Solution {
    public class TreeNodeBox {
        TreeNode previousNode;
        TreeNode firstReverseNode;
        TreeNode secondReverseNode;
        //constructor
        public TreeNodeBox() {
            previousNode = null;
            firstReverseNode = null;
            secondReverseNode = null;
        }
    }
    public void recoverTree(TreeNode root) {
        TreeNodeBox swapElements = new TreeNodeBox();
        recoverTreeHelper(root, swapElements);
        TreeNode temp = new TreeNode(swapElements.firstReverseNode.val);
        swapElements.firstReverseNode.val = swapElements.secondReverseNode.val;
        swapElements.secondReverseNode.val = temp.val;
    }

    public void recoverTreeHelper(TreeNode root, TreeNodeBox elem) {
        //base condition.
        if(root == null)
            return;
        // Check in the left subtree for first swap element.
        recoverTreeHelper(root.left, elem);
        //check whether previousNode is present for verify where BST gets broken.
        if(elem.previousNode != null) {
            //previousNode should be smaller than the current root value
            if(elem.previousNode.val > root.val) {
                //two cases here
                // if first reverseNode is not found then previousNode is first.
                if(elem.firstReverseNode == null) {
                    elem.firstReverseNode = elem.previousNode;
                    //When the nodes are adjacent then previousNode.val > root.val once once and so root will be the value to be swapped.
                    elem.secondReverseNode = root;
                } else {
                    //reverseNode will be the root in the second failing cond.
                    elem.secondReverseNode = root;
                }
            }
        }
        //will get assigned for the first time in the leftmost Node.
        elem.previousNode = root;
        //check in the right sub tree.
        recoverTreeHelper(root.right, elem);
    }

}
