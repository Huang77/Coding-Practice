/**
 * ȥ�Ķ����������Ե����⣬��ʱ�е��ż���˼·û�������д�ˣ��������֡�����Ȼ��̫�١�����
 * 
 * ��Ŀ�����������ַ���a��b������a��b�Ĳ�����ַ����Ĳ�����������ģ�����ַ���a�г��ֶ�����b�г��֣������"-"���ַ�������ַ���b�г��ֶ�����a�г��֣������"+"���ַ���������ù����Ӵ����ǵ�����Ĳ�������̡�
 * ���ӣ�
 * input: a = "a", b = "b", output: "-a,+b";
 * input: a = "aba", b = "aabab", output: "+a,+b";
 * 
 * ˼·����ά��table��¼�����ַ�����������Ӵ����ڱ��������ʱ��������ַ����Ѿ���ǰ���������ĳ���ַ����У��򲻿�������ַ������ַ�λ���ϵ�ֵ����0��
 * ����������table��ȫΪ0���б�ʾ���ַ�������Ҫ��ȥ�ģ�ȫΪ0���б�ʾ���ַ�������Ҫ���ϵġ�
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
		StringBuilder result = new StringBuilder();  // ��StringBuilder�������ڲ�������ַ���ʱ���������µ��ַ���
		
		if (b != null && (a == null || a.length() == 0)) { // ���ַ���a�ǿմ����߳���Ϊ0ʱ��ֻ���������b���ַ�
			for (int i = 0; i < b.length() - 1; i++) {
				result.append("+" + b.charAt(i) + ",");
			}
			result.append("+" + b.charAt(b.length() - 1));
		} else if ((b == null || b.length() == 1) && a != null) { // ���ַ���b�ǿմ����߳���Ϊ0ʱ��ֻ���ȥ����b���ַ�
			for (int i = 0; i < a.length() - 1; i++) {
				result.append("-" + a.charAt(i) + ",");
			}
			result.append("-" + a.charAt(a.length() - 1));
		} else {  // ���ַ���a��b�ĳ��ȶ�����1ʱ
			int sizeA = a.length(), sizeB = b.length();
			int[][] table = new int[sizeA][sizeB];  // ���湫���Ӵ�����
			boolean[] recordA = new boolean[sizeA]; // ��¼a�е��ַ��Ƿ��Ѿ���ʹ�ã�����Ѿ���ʹ�ã�������㹫���Ӵ�ʱ���迼��
			boolean[] recordB = new boolean[sizeB]; // ��¼b�е��ַ��Ƿ��Ѿ���ʹ�ã�����Ѿ���ʹ�ã�������㹫���Ӵ�ʱ���迼��
			
			for (int i = 0; i < sizeA; i++) {
				if (a.charAt(i) == b.charAt(0)) {
					table[i][0] = 1;
					recordA[i] = true;  // ���ַ��Ѿ���ʹ�ã����治�ÿ��ǣ�break
					break;
				} else {
					table[i][0] = 0;
				}
			}
			for (int i = 0; i < sizeB; i++) {
				if (a.charAt(0) == b.charAt(i)) {
					table[0][i] = 1;  // ���ַ��Ѿ���ʹ�ã����治�ÿ��ǣ� break
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
