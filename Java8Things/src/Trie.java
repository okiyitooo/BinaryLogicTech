//
//public class Trie {
//    private TrieNode root;
//
//    public Trie() {
//        this.root = new TrieNode('\0'); // Create a root node with a special character to represent the start of a word
//    }
//
//    public void insert(String word) {
//        TrieNode current = root;
//        for (char letter : word.toCharArray()) {
//            TrieNode child = current.getChild(letter);
//            if (child == null) {
//                child = new TrieNode(letter);
//                current.addChild(letter);
//            }
//            current = child;
//        }
//        current.setEndOfWord(true); // Mark the last node as the end of a word
//    }
//
//    public boolean search(String word) {
//        TrieNode current = root;
//        for (char letter : word.toCharArray()) {
//            TrieNode child = current.getChild(letter);
//            if (child == null) {
//                return false;
//            }
//            current = child;
//        }
//        return current.isEndOfWord(); // Check if the last node is marked as the end of a word
//    }
//
//    public boolean startsWith(String prefix) {
//        TrieNode current = root;
//        for (char letter : prefix.toCharArray()) {
//            TrieNode child = current.getChild(letter);
//            if (child == null) {
//                return false;
//            }
//            current = child;
//        }
//        return true; // Prefix exists in the trie
//    }
//}
