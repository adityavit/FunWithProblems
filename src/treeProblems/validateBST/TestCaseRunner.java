package treeProblems.validateBST;

import isBST.TreeNode;
import treeProblems.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 7/31/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode nonBSTTree = nonBSTTree();
        boolean isBST = sol.validateBST(nonBSTTree);
        System.out.println("Is not BST " + isBST);
        TreeUtil.printTreeASCII(nonBSTTree);
        TreeUtil.printTreeASCII(TreeNode.zigZagProblemTree());
        TreeUtil.printTreeASCII(TreeNode.zigZagProblemTree2());
    }


    /**
     * Creates a tree of this format.
     *
     *            10
     *           /
     *          5
     *        /  \
     *       3    7
     *     / \   / \
     *    1  4  4  9
     * @return
     */

    public static TreeNode nonBSTTree(){
        List<Integer> tree = new ArrayList<Integer>();
        tree.add(10);
        tree.add(5);
        tree.add(null);
        tree.add(3);
        tree.add(7);
        tree.add(null);
        tree.add(null);
        tree.add(1);
        tree.add(4);
        tree.add(4);
        tree.add(9);
        return TreeNode.createTree(tree);
    }
}
