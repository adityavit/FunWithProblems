package constructBinaryTree;

import isBST.TreeNode;
/**
 * Created by adib on 6/14/15.
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
    }

    //Returns a tree for the preorder and inorder.
    public TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        //base condition
        if(preorderStart>preorderEnd)
            return null;
        if(preorderStart == preorderEnd)
            return new TreeNode(preorder[preorderStart]);
        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);
        //Search the index for the root value in the inorder array. will be between inorderStart and inOrderEnd
        int inorderRootIndex = searchInorder( inorder, inorderStart, inorderEnd, rootValue);
        int numOfLeftChildren = inorderRootIndex - inorderStart;
        int numOfRightChildren = inorderEnd - inorderRootIndex;
        // Create left sub tree from the left part of inorder and left children part of preorder.
        if(numOfLeftChildren > 0)
            root.left = buildTreeHelper(preorder, preorderStart+1, preorderStart + numOfLeftChildren, inorder, inorderStart, inorderRootIndex -1);
        else
            root.left = null;
//Create right sub tree from the right part of the inorder and right children part of the preorder.
        if(numOfRightChildren > 0)
            root.right = buildTreeHelper(preorder, preorderStart+numOfLeftChildren+1, preorderEnd, inorder, inorderRootIndex + 1, inorderEnd);

        return root;

    }


    //return index of the elem in the array inorder between start and end indexes.
    public int searchInorder(int[] inorder, int start, int end, int elem) {
        int i = 0;
        for(i = start ; i <= end; i++) {
            if(inorder[i] == elem)
                return i;
        }
        return i;
    }

}
