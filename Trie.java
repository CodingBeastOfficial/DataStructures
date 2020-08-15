import java.util.HashMap;
import java.util.Map;

public class Trie {

	private class TrieNode {
		
		Map<Character, TrieNode> next;
		boolean isEnd;
		
		TrieNode() {
			next = new HashMap<>();
			isEnd = false;
		}
	}

	private TrieNode root;
	
	Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		
		TrieNode curr = root;
		
		for (char c: word.toCharArray()) {
			
			if (curr.next.get(c) == null) {
				curr.next.put(c, new TrieNode());
			}
			
			curr = curr.next.get(c);
		}
		
		curr.isEnd = true;
	}
	
	public boolean search(String word) {
		
		TrieNode curr = root;
		
		for (char c: word.toCharArray()) {
			
			if (!curr.next.containsKey(c)) return false;
			
			curr = curr.next.get(c);
		}
		
		return curr.isEnd;
	}
	
	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.insert("car");
		trie.insert("card");
		trie.insert("dog");
		
		System.out.println("card exists: " + trie.search("card"));
		System.out.println("cardamom exists: " + trie.search("cardamom"));
		System.out.println("bull exists: " + trie.search("bull"));
		System.out.println("dog exists: " + trie.search("dog"));
	}
}
