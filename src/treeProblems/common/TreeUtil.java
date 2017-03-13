package treeProblems.common;

import isBST.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by adib on 7/31/16.
 */
public class TreeUtil {

    private static final int NODE_PADDING = 3;

    private static class TreeNodeBox {
        int level;
        TreeNode node;
        String directionChar;
        public TreeNodeBox(TreeNode node, int level, String directionChar) {
            this.level = level;
            this.node = node;
            this.directionChar = directionChar;
        }
    }


    /**
     * Prints the value of the tree in the tree format.
     * Not the best way, as calculates the size based on a complete binary tree and messes up the spacing where the nodes are null.
     * @param root
     */
    public static void printTreeASCII(TreeNode root) {
        if (root == null)
            return;
        int treeLevel = TreeNode.getTreeHeight(root);
        double maxNodesLastLevel = Math.pow(2, treeLevel - 1);
        double lastLevelLength = Math.abs(maxNodesLastLevel * NODE_PADDING);
        StringBuilder out = new StringBuilder();
        StringBuilder levelDirection = new StringBuilder();
        StringBuilder levelOut = new StringBuilder();
        Deque<TreeNodeBox> bfsQueue = new LinkedList<TreeNodeBox>();
        bfsQueue.add(new TreeNodeBox(root, 1, ""));
        int lastLevel = 1;
        //DO BFS here to print the tree
        while(!bfsQueue.isEmpty()) {
            TreeNodeBox nodeBox = bfsQueue.remove();
            TreeNode node = nodeBox.node;
            int level = nodeBox.level;
            String directionChar = nodeBox.directionChar;
            if (level > lastLevel) {
                out.append(levelDirection);
                out.append("\n");
                out.append(levelOut);
                out.append("\n");
                levelDirection = new StringBuilder();
                levelOut = new StringBuilder();
                lastLevel = level;
            }
            if (level > treeLevel) {
                break;
            }
            double spacing = Math.floor(lastLevelLength / Math.pow(2, level));
            if (node == null) {
                levelOut.append(String.format("%" + spacing * NODE_PADDING+ "s", " "));
                levelDirection.append(String.format("%" + spacing  * NODE_PADDING + "s", " "));
                bfsQueue.add(new TreeNodeBox(null, level + 1, ""));
                bfsQueue.add(new TreeNodeBox(null, level+1 , ""));
            } else {
                String formatString = "%" + spacing + "s%s%" + spacing + "s";
                String levelOutStr = String.format(formatString, " ", node.val, " ");
                String directionString = "%" + (spacing) + "s%s%" + (spacing+1) + "s";
                levelOut.append(String.format(levelOutStr, " ", node.val, " "));
                levelDirection.append(String.format(directionString, " ", directionChar , " "));
                bfsQueue.add(new TreeNodeBox(node.left, level+1, "/"));
                bfsQueue.add(new TreeNodeBox(node.right, level+1, "\\"));
            }
        }
        System.out.print(out.toString());
    }
}
