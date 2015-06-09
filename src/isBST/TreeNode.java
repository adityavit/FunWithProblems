package isBST;

import java.util.*;
/**
 * Created by adib on 6/7/15.
 */
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer x) {
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
}
