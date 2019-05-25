package structure.tree;

/**
 * Created by 44399 on 2019/2/24
 * 前缀树节点
 *
 * @author 44399
 */
public class TrieNode {

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
