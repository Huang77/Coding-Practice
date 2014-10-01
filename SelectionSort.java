package Sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main (String[] args) {
		int[] array = {1,2,5,3,6,7,3,0,1,0,0,0,11};
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void selectionSort (int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int minIndex;
		for (int i = 0; i < array.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			swap(array, minIndex, i);
		}
	}
	
	public static void swap (int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
