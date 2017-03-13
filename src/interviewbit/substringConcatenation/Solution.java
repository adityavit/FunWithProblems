package interviewbit.substringConcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/substring-concatenation/
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * Created by adib on 10/1/16.
 */
public class Solution {

    /**
     * Although it naive approach, but this solution works and was accepted. len(str) = n, size(words) = k , len(words[0]) = l then this algorithm runs in O(nkl). For each i in n, pointer goes k times forward when a match is made.
     * But each substring of l takes l time so n * K * l, after a match is found or not found it starts from the next index where it started from the last time.
     *
     * Uses two maps. The first map is global map which keeps a count of the words in words, second map is created for each i position after getting cleared.
     * The words are checked in the first map to see if there frequency is smaller, if yes then move the pointer to the next word after l length.
     * If the word is not matched or the count is increased for a particular word before substring match, then clear the current map and increase i.
     * How to increment i, i can be either of the values if the word was matched atleast once then the start index of that word is startPtr and i is strPointer + 1
     * If the word is not matched then i is just i++.
     * Why we need startPointer, we need startPointer so we can restore i when we move forward k times to see matches, we need to put a pointer for the i where we started to match this sub string.
     * @param str
     * @param words
     * @return
     * @accepted
     */
    public ArrayList<Integer> findSubstring(String str, final List<String> words) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( str == null || str.length() == 0 || words == null || words.size() == 0) {
            return result;
        }
        int wordLen = words.get(0).length();
        Map<String, Integer> wordCountMap = new HashMap<>();
        for ( String word : words) {
            int wc = 0;
            if(wordCountMap.containsKey(word)){
                wc = wordCountMap.get(word) + 1;
            }
            wordCountMap.put(word, wc);
        }
        Map<String, Integer> wordSeenMap = new HashMap<>();
        int startPtr = -1;
        int i = 0;
        int strLen = str.length();
        int wordCount = words.size();
        int wordCounter = 0;
        while(i < strLen - wordLen + 1) {
            String subWord = str.substring(i, i + wordLen);
            if (wordCountMap.containsKey(subWord)) {
                //This is one of the present word.
                //Check if the word is seen for the first time.
                int totalCount = wordCountMap.get(subWord);
                if (!wordSeenMap.containsKey(subWord) || wordSeenMap.get(subWord) < totalCount) {
                    //Word is not seen before or the word frequency is less than the total times this word can be present in the substring.
                    //If the start pointer is not associated before this becomes the start pointer.

                    if (startPtr == -1) {
                        startPtr = i;
                    }
                    //Add the word to the wordSeenMap
                    int wordSeenCount = 0;
                    if (wordSeenMap.containsKey(subWord)) {
                        wordSeenCount = wordSeenMap.get(subWord) + 1;
                    }
                    wordSeenMap.put(subWord, wordSeenCount);
                    //Increase the word counter by 1;
                    wordCounter++;
                    //Check if the word counter has reached the number of words.
                    //If yes add the start pointer to result.
                    if(wordCounter == wordCount) {
                        result.add(startPtr);
                        //Now after this start again from startPointer + 1 value to look for other index where sub string can be found.
                    } else {
                        i = i + wordLen; // for each i this will go forward k = size(words) times in case all matches are found
                        //Continue for the next word
                        continue;
                    }
                }
            }
            //Reset the state if the word is not present, or word has increased is present but increased the frequency or sub string was found at this i.
            wordCounter = 0;
            if (wordSeenMap.size() > 0) {
                wordSeenMap.clear();
            }
            if (startPtr >= 0) {
                i = startPtr;
                startPtr = -1;
            }
            //Increament i by 1.
            i++;
        }
        return result;
    }

    /**
     * This solution is wrong. And i have placed it here because it highlights the mistake i made.
     * So in this problem i am moving in the string str with wordLen(words[0].length), when the word is found.
     * This becomes a problem in the string lets say "aaaaaaaaaaaaaaa" words = {"aaa", "aaa", "aaa"} or "cabcaaacab" words={"cab","aaa", "abc"}
     * In the first case "aaaaaaaaaaaaaaa" words = {"aaa", "aaa", "aaa"} it will just return 0 , 3, 6 ... because it moves forward by 3 characters when the match is found.
     * Whereas the answer is 0, 1, 2 ...
     * In the second case "cabcaaacab" words={"cab","aaa", "abc"} returns empty list although the answer is 1, this is because once match is not found after the first match.
     * It never checks from the 1st index or the characters in the first index. So don't ignore the characters in the word for other matches.
     *
     * The correct solution is to move one character at a time in the str, if match is found and if not found.
     * @param str
     * @param words
     * @return
     */
    public ArrayList<Integer> findSubstringWrong(String str, final List<String> words) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( str == null || str.length() == 0 || words == null || words.size() == 0) {
            return result;
        }
        int wordLen = words.get(0).length();
        Map<String, Integer> wordCountMap = new HashMap<>();
        for ( String word : words) {
            int wc = 0;
            if(wordCountMap.containsKey(word)){
                wc = wordCountMap.get(word) + 1;
            }
            wordCountMap.put(word, wc);
        }
        Map<String, Integer> wordSeenMap = new HashMap<>();
        int startPtr = -1;
        int i = 0;
        int strLen = str.length();
        int wordCount = words.size();
        int wordCounter = 0;
        while(i < strLen - wordLen + 1) {
            String subWord = str.substring(i, i + wordLen);
            if (wordCountMap.containsKey(subWord)) {
                //This is one of the present word.
                //Check if the word is seen for the first time.
                int totalCount = wordCountMap.get(subWord);
                if (!wordSeenMap.containsKey(subWord) || wordSeenMap.get(subWord) <= totalCount) {
                    //Word is not seen before. Have to count only once
                    //If the start pointer is not associated before this becomes the start pointer.

                    if (startPtr == -1) {
                        startPtr = i;
                    }
                    //Add the word to the wordSeenMap
                    int wordSeenCount = 0;
                    if (wordSeenMap.containsKey(subWord)) {
                        wordSeenCount = wordSeenMap.get(subWord) + 1;
                    }
                    wordSeenMap.put(subWord, wordSeenCount);
                    //Increase the word counter by 1;
                    wordCounter++;
                    //Check if the word counter has reached the number of words.
                    //If yes add the start pointer to result.
                    // if(wordCounter == wordCount) {
                    //     result.add(startPtr);
                    // }
                } else {
                    //The word was found in the seen set already.
                    //Move the startPtr by till we find the word same as the current one.
                    //Remove the words seen in between the move in the wordSeenSet
                    String startStrWord = str.substring(startPtr, startPtr + wordLen);
                    while(!startStrWord.equals(subWord)) {
                        startPtr = startPtr + 1;
                        int wordSeenCount = wordSeenMap.get(startStrWord);
                        wordSeenMap.put(startStrWord, wordSeenCount - 1);
                        startStrWord = str.substring(startPtr, startPtr + wordLen);
                        wordCounter--;
                    }
                    //Now word at the startPtr and i both match.
                    int wordSeenCount = wordSeenMap.get(startStrWord);
                    wordSeenMap.put(startStrWord, wordSeenCount - 1);
                    wordCounter--;
                    startPtr = startPtr + wordLen;
                }
                //Increase i by wordLen to check for the next word.
                if(wordCounter == wordCount) {
                    result.add(startPtr);
                }
                i = i + wordLen;
                //Continue for the next word
                continue;
            } else {
                //If the word is not there in the wordSet.
                //Reset the state as if starts from zero.
                wordCounter = 0;
                if (wordSeenMap.size() > 0) {
                    wordSeenMap.clear();
                }
                startPtr = -1;
                //Increament i by 1.
                i++;
            }
        }
        return result;
    }
}

