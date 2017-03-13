package treeProblems.listofDepth;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by adib on 7/26/16.
 */
public class Solution {

    private class ListTreeNode {
        private int level;
        private TreeNode node;

        public ListTreeNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    List<List<TreeNode>> listDepths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<TreeNode>> depthList = new ArrayList();
        Queue<ListTreeNode> queue = new LinkedList<ListTreeNode>();
        queue.add(new ListTreeNode(0, root));
        while(!queue.isEmpty()) {
            ListTreeNode listNode = queue.remove();
            if(depthList.size() == listNode.level) {
                depthList.add(listNode.level, new LinkedList<TreeNode>());
            }
            depthList.get(listNode.level).add(listNode.node);
            if(listNode.node.left != null) {
                queue.add(new ListTreeNode(listNode.level + 1, listNode.node.left));
            }
            if(listNode.node.right != null) {
                queue.add(new ListTreeNode(listNode.level + 1, listNode.node.right));
            }
        }
        return depthList;
    }
}
