package interviewbit.trees.RecoverBinarySearchTree;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/recover-binary-search-tree/
 * This is like the BST check algorithm. Uses O(height of tree) stack space. O(n) time complexity.
 *
 * if the node has the left sub tree take the return value which would be the rightmost node of the left sub tree, or the smallest than the node.
 * Compare it with node if it is greater than the node, then add the returned node and the current node to the result list.
 * Current node is added because it might be the one swapped with the returned node.
 * If there is no left sub tree, compare from the previous value which is passed to the node. This previous node will be passed to all the nodes,
 * and the comparison to this node will happen when the left sub tree of the node is not present.
 * If the current node is smaller than the previous node, then check again in the list and if result is empty add the current and previous node
 * to the list else just add the current node to the last element of the result list.
 *
 * Created by adib on 10/6/16.
 * @accepted
 */
public class Solution {
    public ArrayList<Integer> recoverTree(TreeNode tree) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (tree == null){
            return result;
        }
        recoverTreeRecursive(tree, null, result);
        Collections.sort(result);
        return result;
    }

    public TreeNode recoverTreeRecursive(TreeNode root, TreeNode prev, ArrayList<Integer> result) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = recoverTreeRecursive(root.left, prev, result);
        if (leftNode != null) {
            // Check for the left node is not null
            if (leftNode.val > root.val ) {
                //leftNode is greater then current node. Left node is first node.
                if (result.size() == 0) {
                    // left node is not at it's right position.
                    result.add(leftNode.val);
                    //root can be the one swaped with left node.
                    result.add(root.val);
                } else {
                    // This is the second time error is found.
                    result.set(1, root.val);
                }
            }
        } else if (prev != null ) {
            // If left node is null then check with the previous node.
            // I.e the passed one is the previous node.
            if (prev.val > root.val ) {
                //prev is greater then current node. Left node is first node.
                if (result.size() == 0) {
                    // prev is not at it's right position.
                    result.add(prev.val);
                    //root can be the one swaped with left node.
                    result.add(root.val);
                } else {
                    // This is the second time error is found.
                    result.set(1, root.val);
                }
            }
        }
        TreeNode rightNode = recoverTreeRecursive(root.right, root, result);
        return rightNode != null? rightNode: root;
    }
}
