package leetcode.medium;

/**
 * Created by 44399 on 2019/2/24
 * 前缀树节点
 *
 * @author 44399
 */

public class LC211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search(".a."));
    }
}

class WordDictionary {

    private static class TrieNode {
        private TrieNode[] children;
        private char character;
        boolean exist;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.exist = false;
        }

        public TrieNode(char c) {
            this.children = new TrieNode[26];
            this.character = c;
            this.exist = false;
        }

        public void setChild(int index, TrieNode child) {
            this.children[index] = child;
        }

        public TrieNode getChild(int n) {
            return children[n];
        }

        public boolean isExist() {
            return exist;
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = cur.getChild(c - 97);
            if (child == null) {
                child = new TrieNode(c);
                cur.setChild(c - 97, child);
            }
            cur = child;
        }
        cur.exist = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, this.root);
    }

    private boolean search(String word, TrieNode trieNode) {
        TrieNode cur = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child == null) {
                        continue;
                    }
                    if (search(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.getChild(c - 97) == null) {
                    return false;
                } else {
                    cur = cur.getChild(c - 97);
                }
            }
        }
        return cur != null && cur.isExist();
    }
}