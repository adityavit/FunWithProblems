package rotateArray;

/**
 * Created by adib on 7/20/15.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] rotateArr = new int[n];
        if(k>n)
            k = k % n;
        int rotatedArrayIndex = k - 1;
        for(int i = n - 1; i >= n - k; i--) {
            rotateArr[rotatedArrayIndex] = nums[i];
            rotatedArrayIndex--;
        }
        rotatedArrayIndex = k;
        for(int i = 0; i<= n - k -1; i++) {
            rotateArr[rotatedArrayIndex] = nums[i];
            rotatedArrayIndex++;
        }
        for(int i = 0; i < n; i++)
            nums[i] = rotateArr[i];
    }
}
