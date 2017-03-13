package trie;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Based on the implementation described here https://www.topcoder.com/community/data-science/data-science-tutorials/using-tries/
 * Tries are used as dictionaries to search the word in the dictionary also to see if the prefix of the word is present in the dictionary or how many words with prefix are present.
 * This is not a bad implementation, although the array being used can be reduced to use hashmap, as this has a restriction of lowercase characters only.
 * A Trie implementation using a 26 character array.
 * Time:
 * Insertion : O(L) Length of the string.
 * search: O(L) Length of the string.
 *
 * Memory:
 * Memory here depends upon the number of prefixes in common.
 * But a word with no common prefix will take L*26
 * Created by adib on 10/10/16.
 * @accepted
 */
class TrieNode {
    int words;
    int prefixes;
    TrieNode[] nodes;
    // Initialize your data structure here.
    public TrieNode() {
        words = 0;
        prefixes = 0;
        nodes = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            int charIndex = word.charAt(i) - 'a';
            if (node.nodes[charIndex] == null) {
                //If the node is not present at this character.
                node.nodes[charIndex] = new TrieNode();
            }
            node.nodes[charIndex].prefixes++;
            node = node.nodes[charIndex];
        }
        node.words++;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            int charIndex = word.charAt(i) - 'a';
            if (node.nodes[charIndex] == null) {
                return false;
            }
            node = node.nodes[charIndex];
        }
        return node.words > 0? true: false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            int charIndex = prefix.charAt(i) - 'a';
            if (node.nodes[charIndex] == null) {
                return false;
            }
            node = node.nodes[charIndex];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");