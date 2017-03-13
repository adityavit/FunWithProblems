package interviewbit.maxDistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adib on 8/20/16.
 */
public class Solution {
    // DO NOT MODIFY THE LIST
    public class Elem {
        Integer val;
        Integer index;

        public Elem(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int maximumGap(final List<Integer> a) {
        if ( a == null || a.size() == 0)
            return -1;
        List<Elem> elemList = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            elemList.add(new Elem(a.get(i), i));
        }
        Collections.sort(elemList, (Elem aElem, Elem bElem) -> {
            return bElem.val.compareTo(aElem.val);
        });
        int i = 0, j = 1;
        int maxDistance = 0, distance;
        while(j < elemList.size()) {
            distance = elemList.get(j).index - elemList.get(i).index;
            if (distance > maxDistance) {
                maxDistance = distance;
            }
            if(distance < 0) {
                i = j;
            }
            j++;
        }
        return maxDistance;
    }
}
