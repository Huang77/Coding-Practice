package Sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main (String[] args) {
		int[] array = {1,2,5,3,6,7,3,0,1,0,0,0,11};
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void insertionSort (int[] array) {
		if (array == null || array.length <= 1) {
			return ;
		}
		
		int insertNum;
		int i, j;
		for (i = 1; i < array.length; i++) {
			insertNum = array[i];
			for (j = i - 1; j >= 0 && array[j] > insertNum; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = insertNum;
		}
	}
}
