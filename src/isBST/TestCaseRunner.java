package isBST;

import java.util.*;

/**
 * Created by adib on 6/7/15.
 */
public class TestCaseRunner {
    public static void main(String[] args){
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(1);
        elements.add(1);
        TreeNode tree = TreeNode.createTree(elements);
        System.out.println("Tree created");
        Solution sol = new Solution();
        System.out.println("Is Valid BST = " + sol.isValidBST(tree));
    }
}
