package leetcode.shortestWordDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/shortest-word-distance/
 * Problem was asked in Linkedin
 * Created by adib on 10/24/16.
 */
public class Solution {
    /**
     * This solution is so much better,
     * basically you iterate over the array and see if the element is same and you assign the pointer to the indexes.
     * If both the pointers are set then, you just need to see if the distance is the minimum.
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int pointer1 = -1;
        int pointer2 = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                pointer1 = i;
            }
            if (word.equals(word2)) {
                pointer2 = i;
            }
            if ( pointer1 != -1 && pointer2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(pointer1 - pointer2));
            }
        }
        return minDistance;
    }
    /**
     * Ok i wrote a O(n^2) complexity solution in the interview.
     * But this is a O(n) solution but there is a better solution to this.
     * You don't need to create a hash map for storing the index of all the words.
     * Later the alogrithm is nothing but finding the minimum difference between two sorted arrays.
     * But this is a good algorithm for the.
     * https://leetcode.com/problems/shortest-word-distance-ii/
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistanceSlow(String[] words, String word1, String word2) {
        Map<String, List<Integer>> wordsIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> wordIndex;
            if (wordsIndexMap.containsKey(word)) {
                wordIndex = wordsIndexMap.get(word);
            } else {
                wordIndex = new ArrayList<>();
                wordsIndexMap.put(word, wordIndex);
            }
            wordIndex.add(i);
        }

        List<Integer> wordOneIndex = wordsIndexMap.get(word1);
        List<Integer> wordTwoIndex = wordsIndexMap.get(word2);

        int list1Len = wordOneIndex.size();
        int list2Len = wordTwoIndex.size();
        int pointer1 = 0;
        int pointer2 = 0;
        int minDistance = Math.abs(wordOneIndex.get(pointer1) - wordTwoIndex.get(pointer2));
        while (pointer1 <  list1Len && pointer2 < list2Len) {
            minDistance = Math.min(minDistance, Math.abs(wordOneIndex.get(pointer1) - wordTwoIndex.get(pointer2)));
            if (wordOneIndex.get(pointer1) < wordTwoIndex.get(pointer2)) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
        return minDistance;
    }
}
