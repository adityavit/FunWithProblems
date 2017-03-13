package interviewbit.minWindowString;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/window-string/
 * https://leetcode.com/problems/minimum-window-substring/
 * Created by adib on 9/27/16.
 * @accepted
 */
public class Solution {

    /**
     * Not an easy problem to solve. Although i solved it myself, first i tried with a deque, It was not easy to write code with that, although i think it can be done now with that too.
     * Later i tried it with two pointer approach and was able to solve it.
     * Alorithm is not that hard, although code is slightly hard to write.
     * So lets say you have a test case as str = "ADOBECODEBANC" and window="ABC"
     * In that case first create a map of the window characters and their frequency.
     * Now use the end pointer to move over the string, all the action is done when the character is part of the window.
     * If it is part of the window, two cases can occur.
     * first:
     * All the characters of window have already been found.
     * In that case if the start pointer character is same as the end character, move the start pointer till the time you reach a character which is in the window map, and it's
     * count is same as in the window i.e. in the map count has become zero now. For other characters either skip them if they are not in window, or increase their count in the map if there count has gone less than zero.
     * second:
     * all the characters of the window are noot seen yet.
     * decrease the window length if the count of this character in map is greater than or equal to zero.
     * if the window length becomes zero while doing it, then increment the start till the time you remove extra window characters from the window.
     * @param str
     * @param wind
     * @return
     */
    public String minWindow(String str, String wind) {
        if (str == null || str.length() == 0 || wind == null || wind.length() == 0)
            return "";

        int strLen = str.length();
        int windLen = wind.length();
        Map<Character, Integer> counts = new HashMap<>();
        int i = 0;
        int minWinSize = strLen + 1;
        int minStartI = -1;
        int minEndI = -1;
        int start = -1;
        int end = 0;
        while ( i < windLen ) {
            int count = 1;
            if (counts.containsKey(wind.charAt(i))) {
                count = counts.get(wind.charAt(i));
                count++;
            }
            counts.put(wind.charAt(i), count);
            i++;
        }
        while ( end < strLen ) {
            char ch = str.charAt(end);
            if (counts.containsKey(ch)) {
                //assign the start pointer if not assigned
                if (start == -1) {
                    if (windLen == 1) {
                        //If it was a single character window
                        //which is found here return it.
                        return str.substring(end, end + 1);
                    }
                    start = end;
                }
                //decrease the count in the map
                int charCount = counts.get(ch);
                //decrease the charCount and put it in the map.
                counts.put(ch, --charCount);
                //If the windowLen becomes zero i.e all the elements are found in the window
                if (windLen == 0) {
                    // Already the first window was found.
                    //Move start Pointer to the left if the end char matches the start char.
                    if (ch == str.charAt(start)) {
                        //Move start till the time, character is not in window or
                        //character in the window is less than zero frequency
                        while(!counts.containsKey(str.charAt(start)) || counts.get(str.charAt(start)) < 0) {
                            if ( counts.containsKey(str.charAt(start)) ) {
                                //Increase the count of the window characters which are less than 0,
                                // Once there are out of window.
                                int count = counts.get(str.charAt(start));
                                counts.put(str.charAt(start), count + 1);
                            }
                            start++;
                        }
                    }
                }
                //Check if the charCount is above zero
                if (charCount >= 0 && windLen > 0) {
                    //This character counts towards windowSize
                    windLen--;
                    if (windLen == 0) {
                        // Needs to take care of the case when str == "bbba" wind = "ab" result is "ba"
                        while(!counts.containsKey(str.charAt(start)) || counts.get(str.charAt(start)) < 0) {
                            if ( counts.containsKey(str.charAt(start)) ) {
                                //Increase the count of the window characters which are less than 0,
                                // Once there are out of window.
                                int count = counts.get(str.charAt(start));
                                counts.put(str.charAt(start), count + 1);
                            }
                            start++;
                        }
                    }
                }
            }
            if (windLen == 0 && (end - start + 1) < minWinSize) {
                minWinSize = end - start + 1;
                minStartI = start;
                minEndI = end;
            }
            end++;
        }
        if ( minStartI != -1) {
            return str.substring(minStartI, minEndI + 1);
        }
        return "";
    }
}
