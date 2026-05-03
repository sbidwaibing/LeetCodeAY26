class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(node.child[index] == null){
                node.child[index] = new TrieNode();
            }

            node = node.child[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(node.child[index] == null){
                return false;
            }

            node = node.child[index];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';

            if(node.child[index] == null){
                return false;
            }

            node = node.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */