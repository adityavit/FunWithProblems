package interviewbit.trees.rootToLeafPathWithSum;

import isBST.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
 * Created by adib on 10/9/16.
 */
public class Solution {


    /**
     * Although accepted if you look at this solution takes a lot of memory.
     * In the pathSumRecursive function at every node an arrayList is created. This means at every node in the tree
     * arrayList gets created. And every node will return this empty list.
     * Can this be optimized.
     * Yes rather than creating a list at every node pass a result list from the pathSum function and also pass a list which acts as a stack stores the current Node
     * In that case when the match is found just just make a copy of that list and store it in the result list.
     * @param root
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result = pathSumRecursive(root, sum);
        for(ArrayList<Integer> resultList: result) {
            Collections.reverse(resultList);
        }
        return result;
    }
    public ArrayList<ArrayList<Integer>> pathSumRecursive(TreeNode root, int sum) {
        if (root == null) {
            return null;
        }
        int diff = sum - root.val;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root.left == null && root.right == null && diff == 0) {
            ArrayList<Integer> resultList = new ArrayList<>();
            resultList.add(root.val);
            result.add(resultList);
            return result;
        }
        ArrayList<ArrayList<Integer>> leftList = pathSumRecursive(root.left, diff);
        if (leftList != null) {
            for (ArrayList<Integer> resultList: leftList) {
                resultList.add(root.val);
                result.add(resultList);
            }
        }
        ArrayList<ArrayList<Integer>> rightList = pathSumRecursive(root.right, diff);
        if (rightList != null) {
            for (ArrayList<Integer> resultList: rightList) {
                resultList.add(root.val);
                result.add(resultList);
            }
        }
        return result;
    }
}
