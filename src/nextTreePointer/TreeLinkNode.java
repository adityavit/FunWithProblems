package nextTreePointer;

import isBST.TreeNode;
import java.util.*;
/**
 * Created by adib on 6/7/15.
 */
public class TreeLinkNode extends TreeNode {
    public TreeLinkNode next;
//    public TreeLinkNode left;
//    public TreeLinkNode right;
    public TreeLinkNode(Integer x) {
        super(x);
    }

    public static TreeLinkNode createTree(List<Integer> elements){
        return createTreeRecursive(elements, 0);
    }

    private static TreeLinkNode createTreeRecursive(List<Integer> elements, int currentIndex) {
        if(currentIndex >= elements.size())
            return null;
        if(elements.get(currentIndex) == null)
            return null;
        TreeLinkNode node = new TreeLinkNode(elements.get(currentIndex));
        node.left = createTreeRecursive(elements, 2*currentIndex + 1);
        node.right = createTreeRecursive(elements, 2*currentIndex + 2);
        return node;
    }

    public static TreeLinkNode createACompleteBinaryTree() {
        List<Integer> elems = new ArrayList<Integer>();
        elems.add(1);
        elems.add(2);
        elems.add(3);
        elems.add(4);
        elems.add(5);
        elems.add(6);
        elems.add(7);
        return createTree(elems);
    }

    // public String toString() {
    //     // System.out.println("*************");
    //     StringBuilder treeString = new StringBuilder();
    //     treeString.append(this.val);
    //     treeString.append("\n");
    // }

    // private static Integer getTreeHeight(TreeNodeLink ) {

    // }

}
