package zigZagOrderTraversal;

import isBST.TreeNode;

import java.util.List;

/**
 * Created by adib on 7/23/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.zigZagProblemTree();
        TreeNode tree2 = TreeNode.zigZagProblemTree2();
        Solution sol = new Solution();
        List<List<Integer>> returnList = sol.zigzagLevelOrder(tree1);
        System.out.println("returnList = " + returnList);
        returnList = sol.zigzagLevelOrder(tree2);
        System.out.println("returnList = " + returnList);
    }
}
