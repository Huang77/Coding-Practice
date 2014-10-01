package Sorting;

import java.util.Arrays;

public class ShellSort {
	public static void main (String[] args) {
		int[] array = {1,2,5,3,6,7,3,0,1,0,11};
		shellSort(array);
		System.out.println(Arrays.toString(array));
	}
	public static void shellSort (int[] array) {
		if (array == null || array.length <= 1) {
			return ;
		}
		int size = array.length;
		int i, j, gap;
		int insertNum;
		// use the increment sequence n/2, n/4, n/8...
		for (gap = size / 2; gap >= 1; gap /= 2) {
			for (i = gap; i < size; i++) {
				insertNum = array[i];
				for (j = i - gap; j >= 0 && array[j] > insertNum; j -= gap) {
					array[j + gap] = array[j];
				}
				array[j + gap] = insertNum;
			}
		}
	}
}
