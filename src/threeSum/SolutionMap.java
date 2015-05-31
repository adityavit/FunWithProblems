package threeSum;

import java.util.*;

public class SolutionMap {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        Map<Integer,List<List<Integer>>> comparisonMap = new HashMap();
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j< nums.length; j++){
                int sum = nums[i] + nums[j];
                List<List<Integer>> sumList;
                if(comparisonMap.get(sum) == null) {
                    sumList = new ArrayList();
                    comparisonMap.put(sum, sumList);
                }
                sumList = comparisonMap.get(sum);
                List<Integer> indexList = new ArrayList();
                indexList.add(i);
                indexList.add(j);
                sumList.add(indexList);
            }
        }

        for(int j=0; j<nums.length ; j++){
            List<List<Integer>> sumList = comparisonMap.get(nums[j] * -1);
            if(sumList != null) {
                for(List<Integer> indexList : sumList) {
                    if(indexList.get(0) != j && indexList.get(1) != j) {
                        List<Integer> returnListElem = new ArrayList();
                        returnListElem.add(nums[indexList.get(0)]);
                        returnListElem.add(nums[indexList.get(1)]);
                        returnListElem.add(nums[j]);
//                        resultList.add(returnListElem);
                        Collections.sort(returnListElem);
                        if(!resultSet.contains(returnListElem)){
                            resultList.add(returnListElem);
                            resultSet.add(returnListElem);
                        }
                    }
                }
                comparisonMap.put(nums[j] * -1, null);
            }
        }
        return resultList;
    }
}