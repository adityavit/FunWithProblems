package isBST;

import java.util.*;
/**
 * Created by adib on 6/7/15.
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(Integer x) {
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

//    @Override
//    public String toString() {
//        List<Integer> elements = new ArrayList<Integer>();
//        convertToList(this, elements, 0);
//        return elements.toString();
//    }
//
//    private void convertToList(TreeNode root, List<Integer> elems, int index) {
//        if(root == null) {
//            elems.add(index, null);
//            return;
//        }
//        elems.add(index, root.val);
//        convertToList(root.left, elems, 2*index + 1);
//        convertToList(root.right, elems, 2*index + 2);
//    }
}
