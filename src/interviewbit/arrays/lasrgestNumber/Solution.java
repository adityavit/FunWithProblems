package interviewbit.arrays.lasrgestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/largest-number/
 * This problem was really simple, I made it complicated.
 * 1. By first comparing the digits.
 *    It didn't work with the digits, i was comparing like 10 with 1, and failed for the case like 12, 121
 * 2. Later i realized a better approach would be just to combine both the numbers in both the order and compare them as as integers.
 *    This strategy is good but Integer.parseInt doesn't work for big strings
 * 3. So another strategy, which i later used was to use compare the string itself.
 *    Now you can write your own comparing string, or you can use String compareTo.
 *
 * time: O(nlogn) for sorting.
 *
 * Remember about the comparator Interface which has a method compare, which we are implementing here.
 * If you want to swap the arguments return >0
 * If you want to keep the same order return <0
 * 0 keeps the order same too, which stands for both are same.
 * So this sort is kind of reverse sort. If  s1s2 is greater than s2s1 return -1 else return 1
 *
 * Placed old code here so you don't make the same mistake again.
 * Created by adib on 11/5/16.
 */
public class Solution {
    public String largestNumber(final List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return "0";
        }
        Collections.sort(nums, (Integer c1, Integer c2) -> {
            //List<Integer> c1Digits = getDigits(c1);
            //List<Integer> c2Digits = getDigits(c2);
            //int c1DigitsLen = c1Digits.size();
            //int c2DigitsLen = c2Digits.size();
            //int minLen = Math.min(c1DigitsLen, c2DigitsLen);
            //int i = 0;
            //while (i < minLen) {
            //    if (c1Digits.get(i) == c2Digits.get(i)) {
            //        i++;
            //        continue;
            //    }
            //    return c2Digits.get(i) - c1Digits.get(i);
            //}
            //if ( i == c1DigitsLen && i == c2DigitsLen )
            //     return 0;
            //if ( i == c1DigitsLen) {
            //    if (c2Digits.get(i) != 0)
            //         return 1;
            //         return -1;
            //}
            //   if ( i == c2DigitsLen && c1Digits.get(i) != 0) {
            //         return -1;
            //}
            //return 1;

            StringBuilder sb1 = new StringBuilder();
            sb1.append(c1);
            sb1.append(c2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c2);
            sb2.append(c1);
//            return  compareStringNumber(sb1.toString(), sb2.toString());
            int result = sb1.toString().compareTo(sb2.toString()) > 0? -1 : 1;
            return  result;
        });
        int len = nums.size();
        StringBuilder sb = new StringBuilder();
        boolean notZero = false;
        for (int i = 0; i < len; i++) {
            if (nums.get(i) > 0){
                notZero = true;
            }
            if (notZero) {
                sb.append(nums.get(i));
            }
        }
        if (!notZero) {
            return "0";
        }
        return sb.toString();
    }

    private int compareStringNumber(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        for ( int i = 0; i < len1; i++) {
            if (s1.charAt(i) == s2.charAt(i))
                continue;
            if (s1.charAt(i) > s2.charAt(i)) {
                return -1;
            }
            return 1;
        }
        return 0;
    }
    private List<Integer> getDigits(Integer x) {
        List<Integer> digits = new ArrayList<>();
        if (x == 0) {
            digits.add(0);
            return digits;
        }
        while(x > 0) {
            digits.add(x%10);
            x = x/10;
        }
        Collections.reverse(digits);
        return digits;
    }
}
