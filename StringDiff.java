/**
 * 去哪儿网开发笔试第三题，当时有点着急，思路没想清楚就写了，回来发现。。果然想太少。。。
 * 
 * 题目：给出两个字符串a和b，计算a和b的差。两个字符串的差是这样定义的：如果字符在a中出现而不在b中出现，则输出"-"该字符；如果字符在b中出现而不在a中出现，则输出"+"该字符。充分利用公用子串，是的输出的差序列最短。
 * 例子：
 * input: a = "a", b = "b", output: "-a,+b";
 * input: a = "aba", b = "aabab", output: "+a,+b";
 * 
 * 思路：二维表table记录两个字符串的最长公共子串，在遍历计算的时候，如果该字符串已经在前面遍历过的某个字符串中，则不考虑这个字符，该字符位置上的值仍是0；
 * 最后遍历整个table，全为0的行表示的字符串是需要减去的，全为0的列表示的字符串是需要加上的。
 * 
 * @author HXX
 *
 */



public class StringDiff {
	public static void main (String[] args) {
		String a = "aba";
		String b = "aabab";
		String result = diff(a, b);
		System.out.println(result);
	}
	
	public static String diff (String a, String b) {
		if (a == null && b == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();  // 用StringBuilder，以免在不断添加字符窜时不断生成新的字符串
		
		if (b != null && (a == null || a.length() == 0)) { // 当字符串a是空串或者长度为0时，只需添加所有b的字符
			for (int i = 0; i < b.length() - 1; i++) {
				result.append("+" + b.charAt(i) + ",");
			}
			result.append("+" + b.charAt(b.length() - 1));
		} else if ((b == null || b.length() == 1) && a != null) { // 当字符串b是空串或者长度为0时，只需减去所有b的字符
			for (int i = 0; i < a.length() - 1; i++) {
				result.append("-" + a.charAt(i) + ",");
			}
			result.append("-" + a.charAt(a.length() - 1));
		} else {  // 当字符串a和b的长度都大于1时
			int sizeA = a.length(), sizeB = b.length();
			int[][] table = new int[sizeA][sizeB];  // 保存公共子串长度
			boolean[] recordA = new boolean[sizeA]; // 记录a中的字符是否已经被使用，如果已经被使用，后面计算公共子串时不予考虑
			boolean[] recordB = new boolean[sizeB]; // 记录b中的字符是否已经被使用，如果已经被使用，后面计算公共子串时不予考虑
			
			for (int i = 0; i < sizeA; i++) {
				if (a.charAt(i) == b.charAt(0)) {
					table[i][0] = 1;
					recordA[i] = true;  // 该字符已经被使用，后面不用考虑，break
					break;
				} else {
					table[i][0] = 0;
				}
			}
			for (int i = 0; i < sizeB; i++) {
				if (a.charAt(0) == b.charAt(i)) {
					table[0][i] = 1;  // 该字符已经被使用，后面不用考虑， break
					recordB[i] = true;
					break;
				} else {
					table[0][i] = 0;
				}
			}
			

			for (int i = 1; i < sizeA; i++) {
				for (int j = 1; j < sizeB; j++) {
					if (a.charAt(i) == b.charAt(j) && recordA[i] == false && recordB[j] == false) {
						table[i][j] = table[i - 1][j - 1] + 1;				
						recordA[i] = true;
						recordB[j] = true;
					} else {
						table[i][j] = 0;
					}
				}
			}

					int i = 0, j = 0;
					boolean printOut = true;
					for (i = 0; i < sizeA; i++) {
						for (j = 0; j < sizeB; j++) {
							if (table[i][j] >= 1) {
								printOut = false;
								break;
							}
						}
						if (printOut == true) {
							if (i != sizeA - 1) {
								result.append("-" + a.charAt(i) + ",");
							} else {
								result.append("-" + a.charAt(i));
							}
						}
						printOut = true;
					}
					for (i = 0; i < sizeB; i++) {
						for (j = 0; j < sizeA; j++) {
							if (table[j][i] >= 1) {
								printOut = false;
								break;
							}
						}
						if (printOut == true) {
							if (i != sizeB - 1) {
								result.append("+" + b.charAt(i) + ",");
							} else {
								result.append("+" + b.charAt(i));
							}
						}
						printOut = true;
					}
				}
		return result.toString();
	}
}
