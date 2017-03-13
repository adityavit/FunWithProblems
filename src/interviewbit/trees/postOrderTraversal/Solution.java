package interviewbit.trees.postOrderTraversal;

import isBST.TreeNode;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/postorder-traversal/
 * The solution i wrote initially uses a stack and a set.
 * Is there a way to just use stack. I had to look in the solution section on interviewbit, and it can be done, but there is a trick to that.
 * The trick is that you do preorder iteration, but instead of pushing the right child to the stack and then the left child, push the left child and then the right child.
 * If you do that you will get the reverse of the post order traversal.
 * Created by adib on 10/8/16.
 */
public class Solution {

    /**
     * Think of it in this way.
     * Post order is left right root, which is just opposite of preorder if right nodes are listed before the left nodes.
     * So preorder is root left right opposite of that is right left root, so if the in the preorder algorithm we can just put left after the right nodes
     * and reverse the result we get post order.
     * time: O(n)
     * space: O(n)
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(stack.size() > 0) {
            TreeNode currentNode = stack.pop();
            result.add(currentNode.val);
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

   /**
    * In this problem i used a stack and a set. A set was need along with stack so that it can keep track that when a root node is visited and has a right child
    * then push the left sub tree of the right child to the stack, and later root node will show up again. So a set will track whether the root node has been visited
    * or not for the second time. The second time the root node needs to be popped out.
    * time : O(n)
    * space: O(N) actual it is 2N, N for the set and N for the stack.
    */
    public ArrayList<Integer> postorderTraversalWithSet(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visitedSet = new HashSet<>();
        TreeNode leftMost = root;
        while (leftMost != null) {
            stack.push(leftMost);
            leftMost = leftMost.left;
        }
        while(stack.size() > 0) {
            TreeNode currentNode = stack.peek();
            if (currentNode.right != null && !visitedSet.contains(currentNode)) {
                //This node has a right element and it's right node is not already accessed.
                visitedSet.add(currentNode);
                leftMost = currentNode.right;
                while (leftMost != null) {
                    stack.push(leftMost);
                    leftMost = leftMost.left;
                }
            } else {
                //If the right node is null or currentNode is already visited.
                currentNode = stack.pop();
                result.add(currentNode.val);
                if (visitedSet.contains(currentNode)) {
                    visitedSet.remove(currentNode);
                }
            }
        }
        return result;
    }
}
