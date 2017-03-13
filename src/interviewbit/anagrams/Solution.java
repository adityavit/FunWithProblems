package interviewbit.anagrams;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/anagrams/
 * This returning the group of anagrams from the list of words.
 * The anagrams are compared with each other with the use of the map storing the sorted word as the key.
 * Created by adib on 9/25/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> words) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<String, ArrayList<Integer>> wordsMap = new LinkedHashMap<>();

        int len = words.size();
        for (Integer i=0; i < len; i++) {
            String word = words.get(i);
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sortedWord = String.valueOf(wordChars);
            if (wordsMap.containsKey(sortedWord)) {
                List<Integer> indexes = wordsMap.get(sortedWord);
                indexes.add(i + 1);
            } else {
                ArrayList<Integer> indexes = new ArrayList<>();
                indexes.add(i + 1);
                wordsMap.put(sortedWord, indexes);
            }
        }

        for (ArrayList<Integer> indexes : wordsMap.values()){
            result.add(indexes);
        }
        return result;
    }

}
