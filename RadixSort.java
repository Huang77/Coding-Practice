package Sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main (String[] args) {
		int[] array = {110,98,23,1,1111};
		radixSort(array, 10, 4);
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void radixSort (int[] array, int k, int d) {
		int[] temp = new int[array.length]; // ����
		int[] buckets = new int[k];
		int divideVal = 1;
		int curDigit;
		
		for (int i = 1; i <= d; i++) {
			// ���buckets
			for (int j = 0; j < k; j++) {
				buckets[j] = 0;
			}
			// ͳ�Ƶ�ǰλÿ�������ֵĴ���
			for (int j = 0; j < array.length; j++) {
				curDigit = (array[j] / divideVal) % 10; 
				buckets[curDigit]++;
			}
			// �ۼ�
			for (int j = 0; j < k - 1; j++) {
				buckets[j + 1] += buckets[j];
			}
			// ����ͳ�ƴ�����������
			for (int j = array.length - 1; j >= 0; j--) {  // һ���ǴӴ�С��������Ϊbuckets[curDigit]��ÿ�μ�һ�ģ�����Ӧ�ô�������򣬶�֮ǰ���������ǰ��մ�С����ģ�����Ҫ�Ӻ���ǰ����
				curDigit = (array[j] / divideVal) % 10;
				temp[--buckets[curDigit]] = array[j];
			}
			// ����ʱ����Ż�ԭ������
			for (int j = 0; j < array.length; j++) {
				array[j] = temp[j];
			}
			divideVal *= k;
		}
		
	}
	
}
