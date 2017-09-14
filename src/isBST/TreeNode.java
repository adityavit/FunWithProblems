package isBST;

import java.util.*;
/**
 * Created by adib on 6/7/15.
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(Integer x) {
        this.val = x;
    }

    public static TreeNode createTree(List<Integer> elements){
        return createTreeRecursive(elements, 0);
    }
    private static TreeNode createTreeRecursive(List<Integer> elements, int currentIndex) {
        if(currentIndex >= elements.size())
            return null;
        if(elements.get(currentIndex) == null)
            return null;
        TreeNode node = new TreeNode(elements.get(currentIndex));
        node.left = createTreeRecursive(elements, 2*currentIndex + 1);
        node.right = createTreeRecursive(elements, 2*currentIndex + 2);
        return node;
    }

    /**
     * Creates a tree of this format.
     *
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15   7
     * @return
     */
    public static TreeNode zigZagProblemTree() {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(3);
        elements.add(9);
        elements.add(20);
        elements.add(null);
        elements.add(null);
        elements.add(15);
        elements.add(7);
        return createTree(elements);
    }

    /**
     * Creates a tree of this format.
     *
     *        3
     *      /    \
     *     9      20
     *     / \    /  \
     *   10  12 15   7
     * @return
     */
    public static TreeNode zigZagProblemTree2() {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(3);
        elements.add(9);
        elements.add(20);
        elements.add(10);
        elements.add(12);
        elements.add(15);
        elements.add(7);
        return createTree(elements);
    }

   @Override
   public String toString() {
       // List<Integer> elements = new ArrayList<Integer>();
       // convertToList(this, elements, 0);
       // return elements.toString();
       return this.val.toString();
   }

    public static int getTreeHeight(TreeNode tree) {
        if(tree == null)
            return 0;
        return getTreeHeightHelper(tree, 1);
    }

    private static int getTreeHeightHelper(TreeNode tree, int currentHeight) {
        if (tree == null)
            return currentHeight;
        int leftTreeHeight = currentHeight, rightTreeHeight = currentHeight;
        if (tree.left != null) {
            leftTreeHeight = getTreeHeightHelper(tree.left, currentHeight) + 1;
        }
        if (tree.right != null) {
            rightTreeHeight = getTreeHeightHelper(tree.right, currentHeight) + 1;
        }
        return Math.max(leftTreeHeight, rightTreeHeight);
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
//
//    private void convertToList(TreeNode root, List<Integer> elems, int index) {
//        if(root == null) {
//            elems.add(index, null);
//            return;
//        }
//        elems.add(index, root.val);
//        convertToList(root.left, elems, 2*index + 1);
//        convertToList(root.right, elems, 2*index + 2);
//    }
}
