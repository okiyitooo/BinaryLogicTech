//import java.util.HashMap;
//import java.util.Map;
//
//public class TrieNode {
//	char value;
//	Map<TrieNode, Map<TrieNode>> children;
//	boolean EndOfWord;
//	public TrieNode(char value) {
//		this.value = value;
//	}
//	public char getValue() {
//		return value;
//	}
//	public void setValue(char value) {
//		this.value = value;
//	}
//	public Map<Character, TrieNode> getChildren() {
//		return children;
//	}
//	public void addChild(char letter) {
//		this.children.putIfAbsent(letter, new HashMap<>());
//	}
//	public boolean isEndOfWord() {
//		return EndOfWord;
//	}
//	public void setEndOfWord(boolean isEndOfWord) {
//		this.EndOfWord = isEndOfWord;
//	}
//	
//}
