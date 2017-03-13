package treeProblems.minimalTree;

import isBST.TreeNode;

/**
 * Created by adib on 7/26/16.
 */
public class TestCaseRunner {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] elems = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = sol.minimalTree(elems);
        System.out.println(root);
        System.out.println(TreeNode.getTreeHeight(root));
    }
}
