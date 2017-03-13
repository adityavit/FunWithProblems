package interviewbit.kthSmallest;

import java.util.List;

/**
 * Created by adib on 9/17/16.
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY

    /**
     * Use partition function to find the kth smallest.
     * The same partition function can be used to do quick sort.
     * Partition function start with i and m, where i start from l + 1 to u,
     * and m keeps track of all the numbers smaller then a[l].
     *
     * @param a
     * @param k
     * @return
     */
    public int kthsmallest(final List<Integer> a, int k) {
        Integer[] elems = a.toArray(new Integer[0]);
        return findKthSmallest(elems, 0, elems.length - 1, k - 1);
    }

    public int findKthSmallest(Integer[] a, int l, int u, int k) {
        if ( k == u && k == l) {
            return a[l];
        }
        int i = l + 1;
        int m = l;
        while (i <= u) {
            if (a[i] <= a[l]) {
                int temp = a[m+1];
                a[m+1] = a[i];
                a[i] = temp;
                m++;
            }
            i++;
        }
        int temp = a[l];
        a[l] = a[m];
        a[m] = temp;
        if ( m == k){
            return a[m];
        }
        if (k < m) {
            return findKthSmallest(a, l, m - 1, k);
        }
        return findKthSmallest(a, m + 1, u, k);
    }
}
