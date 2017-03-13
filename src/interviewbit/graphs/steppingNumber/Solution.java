package interviewbit.graphs.steppingNumber;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/stepping-numbers/
 * It was not that hard problem.
 * Although i spent lot of time, in trying to optimize on the start digit. Whereas it was not required.
 * I was initially taking startMostSD as the most significant digit for the start integer, which doesn't work because
 * if start is 20 then it doesn't cover numbers like 121 or 123, so better would be to consider all the start digits 0 - 9.
 * Created by adib on 11/5/16.
 */
public class Solution {
    public ArrayList<Integer> stepnum(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        if (start == 0) {
            result.add(0);
        }
        int startMostSD = 1;
        while( startMostSD <= 9) {
            generateSteppingNumbers(startMostSD, start, end, result);
            startMostSD++;
        }
        Collections.sort(result);
        return result;
    }

    private void generateSteppingNumbers(int number, int lower, int upper, ArrayList<Integer> result) {
        if ( number > upper) {
            return;
        }
        if (number >= lower && number <= upper) {
            result.add(number);
        }
        int lastDigit = number % 10;
        if (lastDigit > 0) {
            generateSteppingNumbers(number * 10 + (lastDigit - 1), lower, upper, result);
        }
        if (lastDigit < 9) {
            generateSteppingNumbers(number * 10 + (lastDigit + 1), lower, upper, result);
        }
    }
}
