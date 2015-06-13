package sorting;

/**
 * Created by adib on 6/12/15.
 */
public class Solution {
    public void qSort(int[] arr) {
        qSortHelper(arr, 0, arr.length - 1);
    }
    private void qSortHelper(int[] arr, int l, int u) {
        if(l>=u)
            return;
        int m = l;
        for(int i =l; i<=u ; i++) {
            if(arr[i] < arr[l]) {
                int temp = arr[i];
                arr[i] = arr[++m];
                arr[m] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[m];
        arr[m] = temp;
        qSortHelper(arr, l, m-1);
        qSortHelper(arr, m+1, u);
    }
}
