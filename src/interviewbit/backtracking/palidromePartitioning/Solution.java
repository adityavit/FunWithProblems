package interviewbit.backtracking.palidromePartitioning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * https://www.interviewbit.com/problems/palindrome-partitioning/
 * Complexity: 2^n
 * Created by adib on 10/12/16.
 */
public class Solution {
    public List<List<String>> partition(String str) {
        List<List<String>> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        Map<String, List<List<String>>> seenResults = new HashMap<>();
        List<String> currentList = new ArrayList<>();
        partitionRecursive(str, result, currentList, seenResults);
        return result;
    }

    public void partitionRecursive(String str, List<List<String>> result, List<String> currentList,Map<String, List<List<String>>> seenResults ) {
        if (str.length() == 0 && currentList.size() > 0) {
            result.add(new ArrayList(currentList));
        }

        int len = str.length();
        for ( int i = 0; i < len; i++) {
            //Iterate over all the characters.
            String leftStr = str.substring(0, i + 1);
            if (isPalindrome(leftStr)) {
                //If the left string is the palindrome.
                //The add left string to the currentList and pass it further to the DFS
                currentList.add(leftStr);
                if (i < len - 1) {
                    //If the right string is not empty
                    String rightStr = str.substring(i, len);
                    partitionRecursive(rightStr, result, currentList, seenResults);
                } else {
                    //Pass empty string so that currentList can be added to the result.
                    partitionRecursive("", result, currentList, seenResults);
                }
                currentList.remove(currentList.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * This problem again i am using too much of space.
     * So trying to optimize it with another soltuion, where we don't create objects every recursive call.
     * Rather we just use a list to which we pass the data and at the end of the recursive call or at the leaf node of the DAG
     * add it to the result array.
     * @param str
     * @return
     */
    public List<List<String>> partitionMoreMemory(String str) {
        List<List<String>> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        Map<String, ArrayList<ArrayList<String>>> seenResults = new HashMap<>();
        return partitionRecursiveMoreMemory(str, seenResults);
    }

    public List<List<String>> partitionRecursiveMoreMemory(String str, Map<String, ArrayList<ArrayList<String>>> seenMap) {
        List<List<String>> result = new ArrayList<>();
        if (str.length() == 0) {
            return result;
        }
        // if (seenMap.containsKey(str)) {
        //     return seenMap.get(str);
        // }
        int len = str.length();
        for (int i = 0; i < len; i++ ) {
            String leftString = str.substring(0, i + 1);
            if (isPalindrome(leftString)) {
                //If the left String is a palindrome.
                if (i < len - 1) {
                    String rightString = str.substring(i + 1, len);
                    List<List<String>> rightPalindromes = partitionRecursiveMoreMemory(rightString, seenMap);
                    for (List<String> rightPalidromeList: rightPalindromes) {
                        ArrayList<String> temp = new ArrayList<>();
                        temp.add(leftString);
                        temp.addAll(rightPalidromeList);
                        result.add(temp);
                    }
                } else {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(leftString);
                    result.add(temp);
                }
            }
        }
        // seenMap.put(str, result);
        return result;
    }
}

