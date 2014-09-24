
public class StringMatching {
	// Brute Force 暴力匹配法
	public static int BruteForce (String str, String pattern) {
		if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
			return -1;
		}
		int i = 0, j =0;
		int sizeS = str.length(), sizeP = pattern.length();
		
		while (i < sizeS && j < sizeP) {
			if (str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;   // 匹配不成功，i重新回到下一个字符串中开始匹配
				j = 0;
			}
		}
		if (j == sizeP) {
			return (i - j);  // 如果匹配，则返回pattern串在str串中的起始位置
		} else {
			return -1;
		}
	}
	
	// KMP算法
	public static int KMP (String str, String pattern) {
		if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
			return -1;
		}
		int sizeS = str.length(), sizeP = pattern.length();
		
		// initialize the next array for string pattern
		int[] next = new int[sizeP];
		next[0] = 0;
		int i = 0, j = next[0];
		for (i = 1; i < sizeP; i++) {
			while (j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)) {
				j = next[j];
			}
			if (pattern.charAt(i) == pattern.charAt(j + 1)) {
				next[i] = next[j] + 1;
			} else {
				next[i] = 0;
			}
		}
		
		// match the two string
		j = 0;
		for (i = 0; i < sizeS; i++) {
			while (j >= 0 && str.charAt(i) != pattern.charAt(j + 1)) {
				j = next[j];
			}
			if (pattern.charAt(j + 1) == str.charAt(i)) {
				j++;
			}
			if (j == sizeP) {
				return i - j;
			}
		}
		return -1;
	}
	
	
	
	// test
	public static void main (String[] args) {
		String str = "abcdef";
		String pattern = "def";
		System.out.println(BruteForce(str, pattern));
		System.out.println(KMP(str, pattern));
	}
}
