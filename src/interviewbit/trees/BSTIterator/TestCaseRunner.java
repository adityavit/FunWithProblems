package interviewbit.trees.BSTIterator;

import isBST.TreeNode;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by adib on 10/5/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(10);
        tree.right = new TreeNode(25);
        BSTTree bstTreeNodes = new BSTTree(tree);
        bstTreeNodes.forEach(System.out::println);

        //Playing with streams here.
        Stream<Integer> stream = StreamSupport.stream(bstTreeNodes.spliterator(), false);
        System.out.println(Arrays.toString(stream
                .filter(node -> node > 10)
                .toArray()));
    }
}
