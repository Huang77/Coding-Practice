package Sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main (String[] args) {
		int[] array = {1,2,5,3,6,7,3,0,1,0,0,0,11};
		mergeSort_Wrapper(array);
		System.out.println(Arrays.toString(array));
	}
	public static void mergeSort_Wrapper (int[] array) {
		int[] temp = new int[array.length];
		mergeSort(array, temp, 0, array.length -  1);
	}
	
	public static void mergeSort (int[] array, int[] temp, int start, int end) {
		if (start < end) {
			int mid = ((end - start) >> 1) + start;
			mergeSort(array, temp, start, mid);
			mergeSort(array, temp, mid + 1, end);
			merge(array, temp, start, mid, end);
		}
	}
	public static void merge (int[] array, int[] temp, int start, int mid, int end) {
		int i = start; //左边数组的起始下标
		int j = mid + 1; //右边数组的起始下标
		int k = start; // 合并数组的起始下标，从start开始
		
		while (i <= mid && j <= end) {
			if (array[i] <= array[j]) {
				temp[k++] = array[i++]; 
			} else {
				temp[k++] = array[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = array[i++];
		}
		while (j <= end) {
			temp[k++] = array[j++];
		}
		// 复制temp到原数组array中
		for (i = start; i <= end; i++) {
			array[i] = temp[i];
		}
	}
}
