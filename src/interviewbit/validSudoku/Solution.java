package interviewbit.validSudoku;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/valid-sudoku/
 * Created by adib on 9/25/16.
 * @accepted
 */
public class Solution {
    public int isValidSudoku(final List<String> a) {
        if (a == null || a.size() == 0)
            return 0;

        Set<Character> validSet = new HashSet<>();
        // Check if the all the rows have a different number.
        for (String row : a) {
            for ( int i = 0; i < row.length(); i++) {
                if (row.charAt(i) != '.') {
                    if (validSet.contains(row.charAt(i))){
                        return 0;
                    }
                    validSet.add(row.charAt(i));
                }
            }
            validSet.clear();
        }

        // Check for all the columns.
        for ( int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                String row = a.get(j);
                if (row.charAt(i) != '.'){
                    if (validSet.contains(row.charAt(i))) {
                        return 0;
                    }
                    validSet.add(row.charAt(i));
                }
            }
            validSet.clear();
        }

        //Check all the 9 squares.
        //It is actually O(n^2) here.
        for (int rowI = 0; rowI < 3; rowI++) {
            for (int col = 0; col < 3; col++) {
                for (int i = rowI * 3 + 0; i < rowI * 3 + 3; i++) {
                    for (int j = col * 3 + 0; j < col * 3 + 3; j++) {
                        String row = a.get(i);
                        if (row.charAt(j) != '.'){
                            if(validSet.contains(row.charAt(j))) {
                                return 0;
                            }
                            validSet.add(row.charAt(j));
                        }
                    }
                }
                validSet.clear();
            }
        }

        return 1;
    }
}
