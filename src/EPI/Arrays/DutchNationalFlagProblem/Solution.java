package EPI.Arrays.DutchNationalFlagProblem;

/**
 * Created by adib on 4/30/17.
 */
public class Solution {

    public static void partition(int elems[], int pivotI) {
        if (elems == null || elems.length == 0 || elems.length == 1) {
            return;
        }

        if (pivotI < 0 || pivotI >= elems.length)
            throw new IndexOutOfBoundsException("Pivot index is out of bounds");

        int pivotElem = elems[pivotI];
        swap(elems, pivotI, 0);
        int lowI = 0;
        int upperI = 1;
        while (upperI < elems.length) {
            if (elems[upperI] < pivotElem) {
                swap(elems, ++lowI, upperI);
            }
            upperI++;
        }
        swap(elems, 0, lowI);
        upperI = lowI + 1;
        while ( upperI < elems.length) {
            if (elems[upperI] == pivotElem) {
                swap(elems, ++lowI, upperI);
            }
            upperI++;
        }
    }

    public static void partitionSinglePass(int[] elems, int pivotI) {
        if (elems == null || elems.length == 0 || elems.length == 1) {
            return;
        }
        if (pivotI < 0 || pivotI >= elems.length) {
            throw new IndexOutOfBoundsException("Pivot index out of bounds");
        }
        int pivotElem = elems[pivotI];
        int equalI = -1;
        int lowI = 0;
        int upperI = 1;
        while (upperI < elems.length) {
            if (elems[upperI] < pivotElem) {
                if (equalI == -1) {
                    swap(elems, ++lowI, upperI);
                } else {
                    swap(elems, ++lowI, upperI);
                    swap(elems, ++equalI, upperI);
                }
            } else if (elems[upperI] == pivotElem) {
                if (equalI == -1) {
                    equalI = lowI;
                }
                swap(elems, ++equalI, upperI);
            }
            upperI++;
        }
    }

    public static void swap(int[] elems, int index1, int index2) {
        if (index1 < 0 || index1 >= elems.length)
            throw new IndexOutOfBoundsException("index1 is out of bounds");
        if (index2 < 0 || index2 >= elems.length)
            throw new IndexOutOfBoundsException("index2 is out of bounds");

        int temp = elems[index1];
        elems[index1] = elems[index2];
        elems[index2] = temp;
    }
}
