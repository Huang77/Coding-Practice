
public class StringMatching {
	// Brute Force
	public static int BruteForce (String str, int start, String pattern) {
		if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
			return -1;
		}
		int i = start, j =0;
		int sizeS = str.length(), sizeP = pattern.length();
		
		while (i < sizeS && j < sizeP) {
			if (str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;   
				j = 0;
			}
		}
		if (j == sizeP) {
			return (i - j);  
		} else {
			return -1;
		}
	}
	
	// KMP
	public static int KMP (String str, int start, String pattern) {
		if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
			return -1;
		}
		if (start >= str.length()) {
			System.out.println("Index out of range.");
			return -1;
		}
		int sizeS = str.length(), sizeP = pattern.length();
		int[] next = getNextArray(pattern);  // get next array 
		int i = start, j = 0;
		while (i < sizeS && j < sizeP) {
			// if j == -1, means str[i] != pattern[0], than i++ and start over from j = 0;
			// if str[i] == pattern[j], than i++ and j++, go on matching
			if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else { // if it is not matched, j go back to next[j]
				j = next[j];
			}
		}
		if (j < sizeP) { // not match
			return -1;
		} else {  // match and return the index of the pattern in str
			return i - j;
		}
	
	}
	
	private static int[] getNextArray (String pattern) {
		int size = pattern.length();
		int[] next = new int[size];
		
		next[0] = -1;  // initialize nxet[0] = -1
		if (size == 1) {
			return next;
		} 
		next[1] = 0; // if the length of pattern > 1, initialize next[1] = 0;
		int j = 1;
		int k = next[1];
		while (j < size - 1) {
			if (pattern.charAt(j) == pattern.charAt(k)) {
				next[j + 1] = k + 1;
				j++;
			} else if (k == 0) {  // not match
				next[j + 1] = 0;
				j++;
			} else {
				k = next[k];  // k go back
			}
		}
		return next;
	}
	
	
	
	// test
	public static void main (String[] args) {
		String str = "abcdef";
		String pattern = "cd";
		System.out.println(BruteForce(str, 0, pattern));
		System.out.println(KMP(str, 0, pattern));
	}
}
