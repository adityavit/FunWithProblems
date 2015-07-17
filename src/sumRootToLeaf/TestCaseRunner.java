package sumRootToLeaf;

import isBST.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 7/16/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        TreeNode tree = TreeNode.createTree(elements);
        System.out.println("Tree created");
        Solution sol = new Solution();
        System.out.println("Sum is= " + sol.sumNumbers(tree));
    }
}
