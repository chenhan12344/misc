package structure.tree;

/**
 * Created by 44399 on 2019/2/24
 * a~z前缀树的实现
 *
 * @author 44399
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = cur.getChild(c - 97);
            if (cur.getChild(c - 97) == null) {
                child = new TrieNode(c);
                cur.setChild(c - 97, child);
            }
            cur = child;
        }
        cur.exist = true;
    }

    public boolean search(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.getChild(c - 97) != null) {
                cur = cur.getChild(c - 97);
            } else {
                return false;
            }
        }
        return cur.isExist();
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.getChild(c - 97) == null) {
                return false;
            } else {
                cur = cur.getChild(c - 97);
            }
        }
        return cur != null;
    }
}
