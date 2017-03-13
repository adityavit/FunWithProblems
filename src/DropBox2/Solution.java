package DropBox2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adib on 9/30/16.
 */
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        IDUtil idUtil = new IDUtil(8);
        Integer firstId = idUtil.getID();
        Integer secondId = idUtil.getID();
        Integer thirdId = idUtil.getID();
        System.out.println(firstId);
        System.out.println(secondId);
        System.out.println(thirdId);
        System.out.println(idUtil.returnID(firstId));
        System.out.println(idUtil.returnID(secondId));
        System.out.println(idUtil.returnID(secondId));
        System.out.println(idUtil.returnID(thirdId));
        System.out.println(idUtil.returnID(10));
    }
}


/*
0 .. MAX
8 == MAX
0..7
  getID() -> 0 1-7
  getID() -> 5 1,2,3,4,6,7
  returnID(0) -> ()  0,1,2,3,4,6,7
  */

// IDUtil(1,000, 000) => 8MB

class IDUtil {
    Set<Integer> ids = new HashSet<>();
    private final Integer max;
    public IDUtil(int max) {
        this.max = max;
        for ( int i = 0; i < max; i++ ) {
            ids.add(i);
        }
    }

    public Integer getID() {
        Integer[] idsList = ids.toArray(new Integer[0]);
        if ( idsList.length == 0) {
            return -1;
        }
        int elem = idsList[0];
        ids.remove(elem);
        return elem;
    }

    public Integer returnID(Integer id) {
        if (id < 0 || id >= max) {
            return -1;
        }
        if (ids.contains(id)) {
            return -1;
        }
        ids.add(id);
        return 0;
    }
}
