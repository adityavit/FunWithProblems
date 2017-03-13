package snapchat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by adib on 9/23/16.
 */
public class TestCaseRunner {
    //Given a set of valid words and a stream of characters, find a way to split the stream into set of words
//    {ilikedogs, [, i, like, dogs, dog]} => “I like dogs"
    public static void main(String[] args) {
        String inputString = "hello";
        Set<String> dict = new HashSet<>();
        dict.add("hello");
        dict.add("how");
        dict.add("are");
        List<String> result = splitStream(inputString, dict);
        System.out.println(result);
        // System.out.println(collections.join(," "));
    }

    //ilikedogs
    public static List<String> splitStream(String input, Set<String> dictionary) {
        if (input.equals("")) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int i = 0;
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            sb.append(input.charAt(i));
            if (dictionary.contains(sb.toString())) {
                if (i < len - 1) {
                    String restString = input.substring(i + 1, len);
                    List<String> remainingPartition = splitStream(restString, dictionary);
                    if (remainingPartition != null) {
                        result.add(sb.toString());
                        for (String partition : remainingPartition) {
                            result.add(partition);
                        }
                    }
                }
            }
            i++;
        }
        return result.size() == 0 ? null : result;
    }
}

