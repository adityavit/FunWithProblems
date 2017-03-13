package interviewbit.nByThreeRepeatedNumber;

import java.util.List;

/**
 * Created by adib on 8/21/16.
 */
public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        if (a == null || a.size() == 0) {
            return -1;
        }
        int firstThird = -1, firstFrequency = 0;
        int secondThird = -1, secondFrequency = 0;
        int totalNumber = a.size();
        Integer[] elems = a.toArray(new Integer[0]);
        for (int i = 0; i < elems.length; i++) {
            if (firstFrequency == 0 || elems[i] == firstThird) {
                // Check if first number is not set then set it with current number
                firstThird = elems[i];
                firstFrequency++;
            } else if (secondFrequency == 0 || elems[i] == secondThird) {
                //Check if second is not set and then set it with current number.
                secondThird = elems[i];
                secondFrequency++;
            } else {
                //The number doesn't match any of the first or second it means all three can be thrown away
                firstFrequency--;
                if (firstFrequency == 0){
                    firstThird = -1;

                }
                secondFrequency--;
                if (secondFrequency == 0){
                    secondThird = -1;
                }
                if (firstFrequency == 0 && secondFrequency != 0) {
                    firstFrequency = secondFrequency;
                    firstThird = secondThird;
                    secondFrequency = 0;
                    secondThird = -1;
                }
            }
        }
        firstFrequency = 0;
        secondFrequency = 0;
        for ( int i = 0; i <elems.length; i++) {
            if (elems[i] == firstThird) {
                firstFrequency++;
            }
            if (elems[i] == secondThird) {
                secondFrequency++;
            }
        }
        if (firstFrequency > totalNumber / 3) {
            return firstThird;
        }
        if (secondFrequency > totalNumber /3) {
            return secondThird;
        }
        return -1;
    }
}
