package nextTreePointer;

/**
 * Created by adib on 5/31/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeLinkNode tree = TreeLinkNode.createACompleteBinaryTree();
        sol.connect(tree);
        System.out.println(TreeLinkNode.getTreeHeight(tree));
    }
}
