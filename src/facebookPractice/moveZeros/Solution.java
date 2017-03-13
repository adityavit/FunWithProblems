package facebookPractice.moveZeros;

/**
 * https://leetcode.com/problems/move-zeroes/
 * time : O(n)
 * space: O(1) inplace
 * Created by adib on 11/11/16.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int zeroIndex = findNextZero(0, nums);
        int i = zeroIndex + 1;
        while ( i < len) {
            if (nums[i] != 0) {
                swap(i, zeroIndex, nums);
                zeroIndex = findNextZero(zeroIndex, nums);
            }
            i++;
        }
    }

    private int findNextZero(int startIndex, int[] nums) {
        while(startIndex < nums.length && nums[startIndex] != 0)
            startIndex++;
        return startIndex;
    }

    private void swap(int firstIndex, int secondIndex, int[] nums) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}
