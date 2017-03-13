package interviewbit.removeDuplicates;

import java.util.ArrayList;

/**
 * Created by adib on 9/11/16.
 */
public class Solution {
    public int removeDuplicates(ArrayList<Integer> elems) {
        if (elems == null || elems.size() == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        int len = elems.size();
        while (j < len ) {
            if ( elems.get(j) != elems.get(j-1) ) {
                if ( i > 0) {
                    elems.set(i, elems.get(j));
                    i++;
                }
            } else {
                if ( i == 0) {
                    i = j;
                }
            }
            j++;
        }
        return i == 0 ? len : i;
    }
}
