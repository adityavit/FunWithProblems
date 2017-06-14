package uber2;

import java.util.HashMap;
import java.util.List;

/**
 * Created by adib on 10/11/16.
 */

//Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
//
//        Input: words[] = {"GEEKS", "FOR", "QUIZ", "GO"};
//        boggle[][]   = {{'G','I','Z'},
//        {'U','E','K'},
//        {'Q','S','E'}};
//
//        Output:  Following words are present
//        GEEKS
//        QUIZ
//public class Solution {
//    public static void main(String[] args) {
//
//    }

//    #include <iostream>
//    using namespace std;
//    int main() {
/* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        String words[] = {"GEEKS", "FOR", "QUIZ", "GO"};
//        Trie trie = new Trie();
//
//        for (String word : words) {
//            trie.insert(word);
//        }
//
//        Character[][] board   = {{'G','I','Z'},
//                {'U','E','K'},
//                {'Q','S','E'}};
//
//        Map<List<Integer,Integer>,Boolean> visitedMap = new HashMap<>();
//        List<String> result = runDFS(board, row, col, trie, 0, 0, visitedMap, "");
//        return result;
//    }

//    public List<String> runDFS(Character[][] board, int rowSize, int colSize, Trie trie, int indexI, int indexJ, Map<List<Integer,Integer>, Boolean> visited, String stateStirng) {
//        if (board == null) {
//            return new ArrayList<>();
//        }
//        if (rowSize == 0) {
//            return new ArrayList<>();
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.insert(stateStirng);
//        for ( int i = indexI; i < rowSize; i++) {
//            for ( int j = indexJ; i < colSize; j++) {
//                sb.insert(board[i][j]);
//                if (trie.checkPrefix(sb.toString())) {
//                    // for the diagonal below.
//                    List<Integer,Integer> indexes =
//                            visited.put()
//                    runDFS(board, rowSize, colSize, trie, i+1, j+1, visited, sb.toString());
//                    runDFS(board, rowSize, colSize, trie, i-1, j-1, visited, sb.toString());
//
//                }
//            }
//        }
//    }


//    public class TrieNode {
//        int counts;
//        int prefixes;
//        HashMap<Character, TrieNode> nodes;
//
//        public TrieNode() {
//            counts = 0;
//            nodes = new HashMap<>();
//        }
//    }
//    public class Trie {
//
//        TrieNode root;
//
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        public insert(String word) {
//            if ( word.length() == 0) {
//                return;
//            }
//            int len = word.length();
//            TrieNode levelNode = root;
//            for( int i = 0; i < len; i++) {
//                Character ch = word.charAt(i);
//                if (!levelNode.nodes.containsKey(ch)) {
//                    levelNode.put(ch, new TrieNode());
//                }
//                levelNode.prefixes++;
//                levelNode = levelNode.nodes;
//            }
//            levelNode.prefixes++;
//            levelNode.counts++;
//        }
//
//        public boolean checkWord(String word) {
//            if (word.length() == 0) {
//                return true;
//            }
//            int len = word.length();
//            TrieNode levelNode = root;
//            for( int i = 0; i < len; i++) {
//                Character ch = word.charAt(i);
//                if (!levelNode.nodes.containsKey(ch)) {
//                    return false;
//                }
//                levelNode = levelNode.nodes;
//            }
//            if (levelNode.counts > 0) {
//                return true;
//            }
//            return false;
//        }
//
//        public boolean checkPrefix(String word) {
//            if (word.length() == 0) {
//                return true;
//            }
//            int len = word.length();
//            TrieNode levelNode = root;
//            for( int i = 0; i < len; i++) {
//                Character ch = word.charAt(i);
//                if (!levelNode.nodes.containsKey(ch)) {
//                    return false;
//                }
//                levelNode = levelNode.nodes;
//            }
//            if (levelNode.prefixes > 0) {
//                return true;
//            }
//            return false;
//        }
//    }
//}
