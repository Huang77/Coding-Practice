
public class TrieTree {
	static final int Max = 26; // The number of characters, also can be adjust to other encoding scheme
	TrieTree[] child;  // for space-saving, ArrayList or other dynamic array can be used here
	char c;
	boolean isWord;
	// int count;  // record the number of this word
	
	public TrieTree () {  // build the root
		this(' ');
	}
	
	public TrieTree (char c) {
		this.c = c;
		child = new TrieTree[Max];
		isWord = false;
	}
	
	public void addWord (String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		TrieTree curNode = this;
		int pos;
		char c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			pos = c - 'a';
			if (curNode.child[pos] == null) {
				curNode.child[pos] = new TrieTree(c);				
			}
			if (i == word.length() - 1) {
				curNode.child[pos].isWord = true;
				break;
			}
			curNode = curNode.child[pos];
		}
	}
	
	public boolean findWord (String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		TrieTree curNode = this;
		int pos;
		char c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			pos = c - 'a';
			if (curNode.child[pos] == null) {
				return false;
			} else {
				curNode = curNode.child[pos];
			}
		}
		return curNode.isWord;
	}
	
	public static void main (String[] args) {
		TrieTree root = new TrieTree();
		root.addWord("apple");
		root.addWord("appl");
		root.addWord("banana");
		root.addWord("baaaa");
		
		System.out.println(root.findWord("b"));
		System.out.println(root.findWord("baaa"));
	}
	
	
}
