package Sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main (String[] args) {
		int[] array = {110,98,23,1,1111};
		radixSort(array, 10, 4);
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void radixSort (int[] array, int k, int d) {
		int[] temp = new int[array.length]; // 缓存
		int[] buckets = new int[k];
		int divideVal = 1;
		int curDigit;
		
		for (int i = 1; i <= d; i++) {
			// 清空buckets
			for (int j = 0; j < k; j++) {
				buckets[j] = 0;
			}
			// 统计当前位每个数出现的次数
			for (int j = 0; j < array.length; j++) {
				curDigit = (array[j] / divideVal) % 10; 
				buckets[curDigit]++;
			}
			// 累加
			for (int j = 0; j < k - 1; j++) {
				buckets[j + 1] += buckets[j];
			}
			// 按照统计次数进行排序
			for (int j = array.length - 1; j >= 0; j--) {  // 一定是从大到小遍历，因为buckets[curDigit]是每次减一的，所以应该大的先排序，而之前的数组已是按照大小有序的，所以要从后往前遍历
				curDigit = (array[j] / divideVal) % 10;
				temp[--buckets[curDigit]] = array[j];
			}
			// 将临时结果放回原数组中
			for (int j = 0; j < array.length; j++) {
				array[j] = temp[j];
			}
			divideVal *= k;
		}
		
	}
	
}
