package interviewbit.justifiedText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 9/8/16.
 */
public class Solution {
    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> scentences = new ArrayList<String>();
        if ( a == null || a.size() == 0) {
            return scentences;
        }
        int i = 0;
        int wordsCount = a.size();
        int scentenceLen = 0;
        int wordAddCount = 0;
        List<String> scentenceWords = new ArrayList<>();
        while ( i < wordsCount) {
            wordAddCount = 0;
            if ( scentenceLen == 0) {
                //Is the first word don't add the space
                wordAddCount = a.get(i).length();
            } else {
                //Not the first word needs to add space
                wordAddCount = 1 + a.get(i).length();
            }
            if ( scentenceLen + wordAddCount <= b ) {
                //If the word count is less than scentence
                //Add the word to the scentence words.
                scentenceWords.add(a.get(i));
                scentenceLen += wordAddCount;
                i++;
            } else {
                //If the word cannot fit in the scentence.
                scentences.add(createScentence(scentenceWords, scentenceLen, b, false));
                //Start the new scentence
                scentenceLen = 0;
                scentenceWords = new ArrayList<>();
            }
        }
        if ( scentenceLen > 0 ) {
            //There is something remaining at the end.
            scentences.add(createScentence(scentenceWords, scentenceLen, b, true));
        }
        return scentences;
    }

    private String createScentence(List<String> scentenceWords, int scentenceLen, int limit, boolean lastScentence) {
        int i = 0;
        int noOfWords = scentenceWords.size();
        int withoutSpaceLength = scentenceLen - (noOfWords - 1);
        // noOfWords - 1 ignoring the irst word should be even divided.
        int spaceBetweenWords;
        if (lastScentence) {
            spaceBetweenWords = 1;
        } else {
            spaceBetweenWords = noOfWords > 1? (limit - withoutSpaceLength)/(noOfWords - 1): (limit - withoutSpaceLength);
        }
        StringBuilder spaces = new StringBuilder();
        int j = 0;
        while (j < spaceBetweenWords) {
            spaces.append(" ");
            j++;
        }
        int remainingSpaces;
        if (lastScentence) {
            remainingSpaces = 0;
        } else {
            remainingSpaces = noOfWords > 1? limit - (withoutSpaceLength + spaceBetweenWords * (noOfWords - 1)): 0;
        }
        StringBuilder sb = new StringBuilder();
        while ( i < noOfWords ) {
            if ( i == 0) {
                //If this is the first word add the word
                sb.append(scentenceWords.get(i));
                if ( i == noOfWords - 1) {
                    sb.append(spaces);
                }
            } else {
                // Add the spaces then check if remaining space is present add that
                sb.append(spaces);
                if (remainingSpaces > 0) {
                    sb.append(" ");
                    //Should decrease one space.
                    remainingSpaces--;
                }
                sb.append(scentenceWords.get(i));
            }
            i++;
        }
        while (lastScentence && sb.length() < limit) {
            sb.append(" ");
        }
        return sb.toString();
    }
}

