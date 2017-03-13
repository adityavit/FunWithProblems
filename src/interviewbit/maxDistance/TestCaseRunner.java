package interviewbit.maxDistance;

import java.util.*;

/**
 * Created by adib on 8/20/16.
 */
public class TestCaseRunner {

    static class Elem {
        Integer val;
        Integer index;

        public Elem(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.maximumGap(Arrays.asList(1 , 10)));
        List<Elem> elemList = new ArrayList<>();
        int[] elems = {20 , 10 , 1, 4 ,6 ,8 , 9 , 5};
        for ( int i= 0; i < elems.length ; i++) {
            elemList.add(new Elem(elems[i], i));
        }
        System.out.println(new Integer(1).compareTo(2));
        Collections.sort(elemList, (Elem a, Elem b) -> {
            return a.val.compareTo(b.val);
        });
        System.out.println(elemList);
    }
}
