package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adib on 5/31/15.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        for(int i = 0; i<nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    List<Integer> matchedElems = new ArrayList();
                    matchedElems.add(nums[i]);
                    matchedElems.add(nums[start]);
                    matchedElems.add(nums[end]);
                    returnList.add(matchedElems);
                    while(start<end && nums[start+1] == nums[start])
                        start++;
                    start++;
                    while(start< end && nums[end-1] == nums[end])
                        end--;
                    end--;
                } else if(sum > 0){
                    end--;
                } else { //sum smaller than 0
                    start++;
                }
            }
        }
        return returnList;
    }
}
