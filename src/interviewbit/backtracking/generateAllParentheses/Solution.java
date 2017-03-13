package interviewbit.backtracking.generateAllParentheses;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/generate-all-parentheses-ii/
 * https://leetcode.com/problems/generate-parentheses/
 * Created by adib on 10/15/16.
 */
public class Solution {

    /**
     * This method is the based on the solution from interviewbit
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        int open = 0;
        int closed = 0;
        generateParenthesisRecursiveByCount(n, new StringBuilder() ,result, open, closed);
        return result;
    }

    /**
     * In this method we first append ( if there are still open brackets which can be appended.
     * and then we append ) brackets.
     * With that combination it forms all the combinations of open and close brackets.
     * @param n
     * @param currentResult
     * @param result
     * @param open
     * @param close
     */
    public void generateParenthesisRecursiveByCount(int n, StringBuilder currentResult, ArrayList<String> result, int open, int close) {
        if (open == n && close == n) {
            result.add(currentResult.toString());
        }
        if ( open < n) {
            currentResult.append("(");
            int len = currentResult.length();
            generateParenthesisRecursiveByCount(n, currentResult, result, open + 1, close);
            currentResult.deleteCharAt(len - 1);
        }
        if (close < open) {
            currentResult.append(")");
            int len = currentResult.length();
            generateParenthesisRecursiveByCount(n, currentResult, result, open , close + 1);
            currentResult.deleteCharAt(len - 1);
        }
    }

    /**
     * Wrote this solution myself. Again the problem with this solution is that i used the return results to create a result.
     * This leads to creation of lot of objects.
     * The number of combinations is equal to catlan numbers. So i applied the logic of using catlan numbers to create this.
     * Although doing it in a way where you count the open and closed braces leads this problem to be catlan complexity with less objects created overall.
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesisNotOptimal(int n) {
        return generateParenthesisRecursive(n, new HashMap<>(), new HashSet<>());
    }

    public ArrayList<String> generateParenthesisRecursive(int n, Map<Integer, ArrayList<String>> saveMap, Set<String> alreadySeen) {
        if (saveMap.containsKey(n)) {
            return saveMap.get(n);
        }
        ArrayList<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
            saveMap.put(0, result);
            return result;
        }
        if ( n == 1) {
            result.add("()");
            saveMap.put(1, result);
            return result;
        }
        for ( int i = 0; i < n ; i++) {
            ArrayList<String> rightSide = generateParenthesisRecursive(i, saveMap, alreadySeen);
            ArrayList<String> leftSide = generateParenthesisRecursive(n - i - 1, saveMap, alreadySeen);
            StringBuilder sb = new StringBuilder();
            for (String leftStr : leftSide) {
                sb.append("(");
                sb.append(leftStr);
                sb.append(")");
                if (rightSide.get(0).length() != 0 ) {
                    // Don't iterate for the case when i is zero
                    StringBuilder totalString = new StringBuilder();
                    for (String rightStr  : rightSide) {
                        totalString.append(sb.toString());
                        totalString.append(rightStr);
                        if (!alreadySeen.contains(totalString.toString())) {
                            result.add(totalString.toString());
                            alreadySeen.add(totalString.toString());
                        }
                        totalString.delete(0, totalString.length());
                    }
                } else {
                    if (!alreadySeen.contains(sb.toString())) {
                        result.add(sb.toString());
                        alreadySeen.add(sb.toString());
                    }
                }
                sb.delete(0, sb.length());
            }
        }
        Collections.sort(result);
        saveMap.put(n, result);
        return result;
    }
}

