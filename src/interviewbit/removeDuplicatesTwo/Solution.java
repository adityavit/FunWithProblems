package interviewbit.removeDuplicatesTwo;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
 * Problem is better than the previous remove duplicates.
 * Good thing to understand is you have to ignore the first time you see an element again, so just move it as you will move it when they are different at i.
 * But if you see element twice then just if the move position is not set, then set it. i.e set i.
 * @accepted
 * Created by adib on 9/12/16.
 */
public class Solution {
    public int removeDuplicates(ArrayList<Integer> elems) {
        if (elems == null) {
            return 0;
        }
        if (elems.size() < 3) {
            return elems.size();
        }
        int i = 0;
        int j = 1;
        int len = elems.size();
        boolean previousIsSameOnce = false;
        while (j < len ) {
            if (elems.get(j).equals(elems.get(j-1))) {
                if(previousIsSameOnce) {
                    // Seeing the element twice so, I needs to be set if not set.
                    if (i == 0) {
                        i = j;
                    }
                } else {
                    // First time seing this element again. So move this element if i is set.
                    previousIsSameOnce = true;
                    if (i > 0) {
                        //Move this element to i
                        elems.set(i, elems.get(j));
                        i++;
                    }
                }
            } else {
                //If both the elements are not same. Move this element for sure.
                if ( i > 0) {
                    elems.set(i, elems.get(j));
                    i++;
                }
                //reset previousIsSameOnce
                previousIsSameOnce = false;
            }
            j++;
        }
        return i == 0 ? len : i;
    }
}
