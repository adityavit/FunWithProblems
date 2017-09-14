package EPI.Trees.LowestCommonAncestor;

import isBST.TreeNode;
import treeProblems.common.TreeUtil;

/**
 * Created by adib on 6/25/17.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNodeWithParent root = new TreeNodeWithParent(1, null);
        TreeNodeWithParent rootLeft = new TreeNodeWithParent(2, root);
        root.left = rootLeft;
        TreeNodeWithParent node3 =  new TreeNodeWithParent(3, rootLeft);
        rootLeft.left = node3;
        rootLeft.right = new TreeNodeWithParent(4, rootLeft);
        TreeNodeWithParent node5 = new TreeNodeWithParent(5, rootLeft.right);
        rootLeft.right.right = node5;

        TreeNodeWithParent rootRight = new TreeNodeWithParent(6, root);
        root.right = rootRight;
        TreeNodeWithParent node7 = new TreeNodeWithParent(7, rootRight);
        rootRight.left = node7;
        TreeNodeWithParent node8 = new TreeNodeWithParent(8, rootRight);
        rootRight.right = node8;
        TreeUtil.printTreeNode(root);

        System.out.println("LCA between 2 and 5");
        TreeNodeWithParent lca = findLCA(root, rootLeft, node5);
        System.out.println(lca.toString());

        System.out.println("LCA between 3 and 7");
        TreeNodeWithParent lca2 = findLCA(root, node3, node7);
        System.out.println(lca2.toString());

        System.out.println("LCA between 1 and 5");
        TreeNodeWithParent lca3 = findLCA(root, root, node5);
        System.out.println(lca3.toString());

        System.out.println("LCA between 5 and 7");
        TreeNodeWithParent lca4 = findLCA(root, node7, node5);
        System.out.println(lca4.toString());

        System.out.println("LCA between 8 and 7");
        TreeNodeWithParent lca5 = findLCA(root, node8, node7);
        System.out.println(lca5.toString());

        System.out.println("LCA between not present");
        TreeNodeWithParent lca6 = findLCA(root, node5, new TreeNodeWithParent(10, null));
        System.out.println(lca6);
    }

    /**
     * This gives a O(n) solution as it searches both the nodes in the tree, by checking all the nodes of the tree.
     * Whereas you already have the nodes of the tree as an argument, so better use that.
     * Get the height of both the nodes of the tree. If the nodes are of the same height then go up the level for both
     * the nodes till we find the common nodes.
     * If one of the node is deeper than the other then go up that node for the diff in height and then once they are at
     * the same level go till we find the common node.
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public static TreeNodeWithParent findLCA(TreeNodeWithParent root, TreeNodeWithParent node1, TreeNodeWithParent node2) {
        // In this code done an post-order traversal using parent pointer, so using two pointers the current pointer for the node
        // and the previous pointer. The previous pointer denotes the direction to go in, if the previous is parent pointer
        // and left is present then go to the left child, if the previous is not right and right is present then go the right child,
        // else the previous is left or right or current itself depending up the tree then just go up.
        if ( root == null ) {
            return null;
        }
        if ( node1 == node2) {
            return node1;
        }
        TreeNodeWithParent current = root;
        TreeNodeWithParent previous = null;
        TreeNodeWithParent LCA = null;
        while(current != null) {
            if (current == node1 || current == node2) {
                if (LCA == null) {
                    //Set the LCA
                    LCA = current;
                }
                if (current != LCA){
                    return LCA;
                }
            }
            if ( current.left != null && previous == current.parent) {
                previous = current;
                current = current.left;
                continue;
            }
            if ( current.right != null && previous != current.right) {
                previous = current;
                current = current.right;
                continue;
            }
            previous = current;
            if (LCA == current) {
                LCA = current.parent;
            }
            current = current.parent;
        }
        return null;
    }


    private static class TreeNodeWithParent extends TreeNode {
        TreeNodeWithParent parent;
        TreeNodeWithParent left;
        TreeNodeWithParent right;
        public TreeNodeWithParent(Integer x, TreeNodeWithParent parent) {
            super(x);
            this.parent = parent;
        }

        @Override
        public TreeNodeWithParent getLeft() {
            return left;
        }

        @Override
        public TreeNodeWithParent getRight() {
            return right;
        }
    }
}
