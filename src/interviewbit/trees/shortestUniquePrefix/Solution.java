package interviewbit.trees.shortestUniquePrefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/shortest-unique-prefix/
 * http://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
 * This problem is solved using a trie and then checking where the prefix count turns to 1 for a string.
 * The trie implementation is based on https://www.topcoder.com/community/data-science/data-science-tutorials/using-tries/
 *
 * Although i have used a map rather than an array, this way it saves the space.
 * Trie keeps track at every node if the word ended at this position by the words field.
 * And prefixes keeps track of how many words have the same path in the trie.
 *
 * Once the trie data structure is known it is fairly simple problem.
 * For the array based implementation of trie checkout the trie package in this code base.
 * Created by adib on 10/10/16.
 */
public class Solution {
    private static class TrieNode {
        int prefixes;
        int words;
        Map<Character, TrieNode> nodes;
        TrieNode() {
            prefixes = 0;
            words = 0;
            nodes = new HashMap<>();
        }
    }

    private static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            int len = word.length();
            TrieNode node = root;
            for (int i = 0; i < len; i++) {
                Character ch = word.charAt(i);
                if (!node.nodes.containsKey(ch)) {
                    node.nodes.put(ch, new TrieNode());
                }
                node.prefixes++;
                node = node.nodes.get(ch);
            }
            node.prefixes++;
            node.words++;
        }

        public String getUniquePrefix(String word) {
            int len = word.length();
            TrieNode node = root;

            for (int i = 0; i < len; i++) {
                Character ch = word.charAt(i);
                node = node.nodes.get(ch);
                if (node.prefixes == 1) {
                    return word.substring(0, i + 1);
                }
            }
            return null;
        }

    }
    public ArrayList<String> prefix(ArrayList<String> strs) {
        if (strs == null) {
            return strs;
        }
        Trie trie = new Trie();
        ArrayList<String> result = new ArrayList<>();
        for(String str : strs) {
            trie.insert(str);
        }
        for(String str : strs) {
            result.add(trie.getUniquePrefix(str));
        }
        return result;
    }
}

