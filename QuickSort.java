package Sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main (String[] args) {
		int[] array = {1,2,5,3,6,7,3,0,1,0,0,0,11};
		quickSort_Wrapper(array);
		System.out.println(Arrays.toString(array));
	}
	public static void quickSort_Wrapper (int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pIndex = partition(array, start, end);
			quickSort(array, start, pIndex - 1);
			quickSort(array, pIndex + 1, end);
		}
	}
	public static int partition (int[] array, int start, int end) {
		int pValue = array[start];
		
		while (start < end) {
			while (start < end && array[end] >= pValue) {
				end--;
			}
			array[start] = array[end];
			while (start < end && array[start] <= pValue) {
				start++;
			}
			array[end] = array[start];
		}
		array[start] = pValue;
		return start;
	}
}
