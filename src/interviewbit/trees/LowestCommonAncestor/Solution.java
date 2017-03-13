package interviewbit.trees.LowestCommonAncestor;

import isBST.TreeNode;

/**
 * There are two ways to solve this problem.
 * 1. Use two arrays and search for both the numbers and save the path to them in the array.
 *    Once both the numbers are found. Then compare the values from the starting of the array.
 *    The farthest common value in the arrays would be lowest common ancestor.
 * 2. Using recursion,
 *    Here we search for either of the number, once either of the number is found. Then we have two possibilities.
 *    a. The other number is below this number.
 *    If this is the case, then we know this number is the ancestor, so we can return it.
 *    b. The number is not below this number but in the other sub tree of it's ancestor.
 *    then when both the left and right subtree doesn't return -1 then the root is the ancestor.
 *    Else look above.
 *
 * time: O(n) , Will have to visit each node at least once in the worst case.
 * space: O(n), Stack size in worst case will be O(n)
 *
 * Created by adib on 10/11/16.
 */
public class Solution {

    /**
     * @accepted
     * @param root
     * @param val1
     * @param val2
     * @return
     */
    public int lca(TreeNode root, int val1, int val2) {
        if (root == null)
            return -1;
        //Check for the values initially so that we don't land into the edge case when only one value is found.
        boolean val1Present = findValue(root, val1);
        boolean val2Present = findValue(root, val2);
        if (val1Present && val2Present) {
            return lcaRecursiveWithValuePresent(root, val1, val2);
        }
        return -1;
    }

    public int lcaRecursiveWithValuePresent(TreeNode root, int val1, int val2) {
        if (root == null)
            return -1;
        boolean valueFound = false;
        if (root.val == val1 || root.val == val2) {
            //This node is the ancestor.
            //As both the nodes are present in the tree.
            //We can assume if the other number is below this node then this is the ancestor.
            //If it is not we just return it's value to let the ancestor know that we found one node.
            return root.val;
        }
        int leftTreeValue = lcaRecursiveWithValuePresent(root.left, val1, val2);
        int rightTreeValue = lcaRecursiveWithValuePresent(root.right, val1, val2);
        //If one of the values is found in each of the sub tree below.
        //This is the ancestor where both left and right sub tree contains so this is the lowest ancestor.
        if (leftTreeValue != -1 && rightTreeValue != -1) {
            //This is the current node.
            return root.val;
        }
        return leftTreeValue != -1 ? leftTreeValue : rightTreeValue;
    }

    /**
     * This is the first solution i wrote.
     * And it does the same logic, but does extra checks which are not required.
     * @param root
     * @param val1
     * @param val2
     * @return
     * @accepted
     */
    public int lcaFirst(TreeNode root, int val1, int val2) {
        if (root == null)
            return -1;
        boolean val1Present = findValue(root, val1);
        boolean val2Present = findValue(root, val2);
        if (val1Present && val2Present) {
            return lcaRecursiveWithValuePresentFirst(root, val1, val2);
        }
        return -1;
    }
    public int lcaRecursiveWithValuePresentFirst(TreeNode root, int val1, int val2) {
        if (root == null)
            return -1;
        boolean valueFound = false;
        if (root.val == val1 || root.val == val2) {
            valueFound = true;
        }
        int leftTreeValue = lcaRecursiveWithValuePresentFirst(root.left, val1, val2);
        int rightTreeValue = lcaRecursiveWithValuePresentFirst(root.right, val1, val2);
        if (leftTreeValue == -1 && rightTreeValue == -1) {
            //Value is not below this node.
            if (valueFound) {
                return root.val;
            }
            return -1;
        }
        //If one of the values is found in each of the sub tree below.
        if (leftTreeValue != -1 && rightTreeValue != -1) {
            //This is the current node.
            return root.val;
        }
        // value is found below this tree
        if (leftTreeValue != -1 || rightTreeValue != -1) {
            if (valueFound) {
                return root.val;
            }
        }
        return leftTreeValue != -1? leftTreeValue: rightTreeValue;
    }

    private boolean findValue(TreeNode root, int val) {
        if (root == null)
            return false;

        if (root.val == val)
            return true;

        if (findValue(root.left, val)) {
            return true;
        }
        return findValue(root.right, val);
    }
}

