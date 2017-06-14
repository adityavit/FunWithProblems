package careerCup.linkedin.tournamentTree;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 4/16/17.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        TreeNode testCaseTree1 = testCaseTree1();
        System.out.println(Solution.secondMin(testCaseTree1));
        TreeNode testCaseTree2 = testCaseTree2();
        System.out.println(Solution.secondMin(testCaseTree2));
        TreeNode testCaseTree3 = testCaseTree3();
        System.out.println(Solution.secondMin(testCaseTree3));
        TreeNode testCaseTree4 = testCaseTree4();
        System.out.println(Solution.secondMin(testCaseTree4));
    }

    public static TreeNode testCaseTree1() {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(2);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(2);
        elements.add(5);
        elements.add(3);
        return TreeNode.createTree(elements);
    }

    public static TreeNode testCaseTree2() {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(2);
        elements.add(2);
        elements.add(2);
        elements.add(2);
        elements.add(2);
        elements.add(2);
        elements.add(2);
        return TreeNode.createTree(elements);
    }

    public static TreeNode testCaseTree3() {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(2);
        elements.add(2);
        elements.add(2);
        elements.add(2);
        elements.add(5);
        elements.add(2);
        elements.add(null);
        return TreeNode.createTree(elements);
    }


    public static TreeNode testCaseTree4() {
        List<Integer> elements = new ArrayList<Integer>();
        elements.add(2);
        elements.add(2);
        elements.add(10);
        elements.add(2);
        elements.add(20);
        elements.add(10);
        elements.add(null);
        return TreeNode.createTree(elements);
    }
}
