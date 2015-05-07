import java.util.Map;
import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> tempStore = new HashMap();
        for(int i = 0; i< nums.length; i++){
            tempStore.put(nums[i], i);
        }
        for(int i = 0; i < nums.length ; i++) {
            int diff = target - nums[i];
            Integer diffIndex = tempStore.get(diff);
            if(diffIndex != null && diffIndex > i) {
                 ret[0] = i+1;
                 ret[1] = diffIndex+1;

            }
        }
        return ret;
    }
}