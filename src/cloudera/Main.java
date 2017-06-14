/**
 * Created by adib on 5/11/17.
 */
package cloudera;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

// Class name must be "Main"
// write a function that accepts two lists of integers, list1 and list2
// return true if there exists any two numbers x and y such that x is in list1 and y is in list2 and x+y == 0
// return false otherwise
// x , -x [1, 2, 3] [-1, -2 , -3] == O(mn)

// for N elements in lists, O(N^2)
// Sort list2(size = m) for each element x (size = n) => a, will do a binary search for -a ==> O(nlogm) + O(mlogm)
// Store all the numbers of list2 in a set. Then look for each element in x as -a in the set. O(m + n)
class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        List<Integer> list3 = new ArrayList();
        list3.add(10);
        list3.add(-6);
        list3.add(30);
        System.out.println(isSumZeroThreeList(list1, list2, list3));
    }

    private static boolean isSumZero(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) {
            return false;
        }
        if (list1.size() == 0 || list2.size() == 0) {
            return false;
        }
        Set<Integer> list2Set = new HashSet<>();
        for(Integer elem: list2) {
            list2Set.add(elem);
        }
        for (Integer elem: list1) {
            Integer elemNeg = elem * -1;
            if (list2Set.contains(elemNeg)) {
                return true;
            }
        }
        return false;
    }

    // determine if exists x, y, z such that x in list1 y in list2 z in list3 and x+y+z == 0
    // Brute Force Way of doing this Iterate over each elem in the list x,y,z and check if the sum is 0. O(nmp) Cubic
    // Calculate x + y, For each elem of x,y take sum and store it in a set. O(nm) quadratic. Iterate over each elem in z and check if -elemZ is present in Set O(z) ==> Quadratic
    private static boolean isSumZeroThreeList(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        if (list1 == null || list2 == null || list3 == null) {
            return false;
        }
        if (list1.size() == 0 || list2.size() == 0 || list3.size() == 0) {
            return false;
        }

        Set<Integer> sumSet = new HashSet<>();
        for(Integer elem1: list1) {
            for(Integer elem2: list2) {
                sumSet.add(elem1 + elem2);
            }
        }

        for(Integer elem: list3) {
            Integer elemNeg = elem * -1;
            if (sumSet.contains(elemNeg)) {
                return true;
            }
        }
        return false;
    }

    // O(N^4)
    // O(N^3) ^^
    // O(N^2) => create two quadratic lists/sets, see if opposite is in the other set
    private static boolean isSumZeroFourList(List<Integer> list1, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
        return false;
    }

    // M lists of N integers
    // M=2 => O(n)
    // M=3 => O(n^2)
    // M=4 => O(n^2)
    // M=5 => O(n^3)
    // M=6 => O(n^3)
    // O(n^ceil(m/2))

    // O(n^ceil(m/2))

    // x1, x2 , y1, y2 z1, z2 ==> x1x2 , y1y2 , z1z2 == Quadratic
    // O(n^2m^2)
    private static boolean isSumZero(List<List<Integer>> lists) {
        return false;
    }

}
