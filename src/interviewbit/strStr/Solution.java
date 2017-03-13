package interviewbit.strStr;

/**
 * https://www.interviewbit.com/problems/implement-strstr/
 * O(MN) algorithm naive approach.
 * Rabin karp algorithm is a better approach still a O(MN) algorithm though.
 * KMP is O(M) algorithm.
 * Created by adib on 9/4/16.
 */
public class Solution {
    public int strStr(final String haystack, final String needle) {
        if (haystack == null || needle == null || haystack.length() == 0 || needle.length() == 0)
            return -1;
        int i = 0, j = 0;
        int lenH = haystack.length(), lenN = needle.length();
        while ( i < lenH) {
            int k = i;
            while (j < lenN && k < lenH){
                if (haystack.charAt(k) != needle.charAt(j)){
                    break;
                } else {
                    k++;
                    j++;
                }
                if ( j == lenN) {
                    return i;
                }
            }
            j = 0;
            i++;
        }
        return -1;
    }
}
