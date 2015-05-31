package Permutation;
import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(nums, 0, nums.length - 1);
    }

    public List<List<Integer>> permuteHelper(int[] permuteList, int start, int end) {
        if(start == end) {
            List<Integer> permutation = new ArrayList();
            permutation.add(permuteList[start]);
            List<List<Integer>> permutationList = new ArrayList();
            permutationList.add(permutation);
            return permutationList;
        } else {
            int currentElement = permuteList[start];
            List<List<Integer>> subsetPermuteList = permuteHelper(permuteList, start+1, end);
            List<List<Integer>> permutationsWithCurrentElement = new ArrayList();
            for(List<Integer> permutation : subsetPermuteList) {
                for(int j=0; j<permutation.size() + 1; j++){
                    List<Integer> permutatedListForIteration = new ArrayList();
                    for(int i=0; i< permutation.size();) {
                        if(permutatedListForIteration.size() == j){
                            permutatedListForIteration.add(currentElement);
                        } else {
                            permutatedListForIteration.add(permutation.get(i));
                            i++;
                        }
                    }
                    if(j == permutatedListForIteration.size()) {
                        permutatedListForIteration.add(currentElement);
                    }
                    permutationsWithCurrentElement.add(permutatedListForIteration);
                }
            }
            return permutationsWithCurrentElement;
        }
    }
}