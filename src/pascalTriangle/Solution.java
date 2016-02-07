package pascalTriangle;

import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<Integer>();
        List<Integer> secondRow = new ArrayList<Integer>();
        if(numRows > 0) {
            firstRow.add(1);
            result.add(firstRow);
            if(numRows > 1) {
                secondRow.add(1);
                secondRow.add(1);
                result.add(secondRow);
            }
        }
        List<Integer> lastRow = secondRow;
        for(int i = 3 ; i <= numRows ; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int j = 0; j < lastRow.size()-1; j++) {
                row.add(lastRow.get(j) + lastRow.get(j+1));
            }
            row.add(1);
            lastRow = row;
            result.add(row);
        }
        return result;
    }
}