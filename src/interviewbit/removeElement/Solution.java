package interviewbit.removeElement;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/remove-element-from-array/
 * Test Cases needs to be taken cared of.
 * Like i forgot the case when there is no b in a and in that case return i.
 * Created by adib on 9/12/16.
 * @accepted
 */
public class Solution {
    public int removeElement(ArrayList<Integer> a, int b) {
        if ( a == null || a.size() == 0) {
            return 0;
        }
        int i = -1;
        int j = 0;
        int len = a.size();
        while (j < len) {
            int elem = a.get(j);
            if (elem == b) {
                //This element is same as b, move position.
                if ( i < 0) {
                    //i is not set, put i to j.
                    i = j;
                }
            } else {
                //If the element is not equal to b.
                if (i >= 0) {
                    //If i is set then set the element to position i.
                    a.set(i, elem);
                    i++;
                }
            }
            j++;
        }
        return i == -1 ? len: i;
    }
}
