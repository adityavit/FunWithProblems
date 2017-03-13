package trie;

/**
 * Created by adib on 10/10/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("helloworld");
        trie.insert("hell");
        trie.insert("here");

        System.out.println(trie.startsWith("her"));
        System.out.println(trie.search("hello"));
    }
}
