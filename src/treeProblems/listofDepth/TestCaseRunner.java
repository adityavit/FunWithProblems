package treeProblems.listofDepth;

import isBST.TreeNode;

import java.util.List;

/**
 * Created by adib on 7/26/16.
 */
public class TestCaseRunner {

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.zigZagProblemTree();
        List<List<TreeNode>> depthLists = sol.listDepths(root);
        for(List depthList : depthLists ) {
            System.out.println(depthList);
        }
    }
}
