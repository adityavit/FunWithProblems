package recoverBST;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 6/11/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(0);
        elements.add(1);
        TreeNode tree = TreeNode.createTree(elements);
        Solution sol = new Solution();
        sol.recoverTree(tree);
    }
}
