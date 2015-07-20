package sameTree;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 7/19/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        List<Integer> elements2 = new ArrayList<Integer>();
        elements2.add(1);
        elements2.add(2);
//        elements2.add(3);
        TreeNode p = TreeNode.createTree(elements);
        TreeNode q = TreeNode.createTree(elements2);
        Solution sol = new Solution();
        boolean isSame = sol.isSameTree(p, q);
        System.out.println("isSame = " + isSame);
    }
}
