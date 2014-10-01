package Sorting;

import java.util.Arrays;

public class CountSort {
	public static void main (String[] args) {
		int[] array = {2,0,1,1,1,2,2,4,4,6,1,0,1};
		countSort(array, 6);
		System.out.println(Arrays.toString(array));
	}
	
	public static void countSort (int[] array, int k) {
		int[] count = new int[k + 1];
		int size = array.length;
		
		for (int i = 0; i < size; i++) {
			count[array[i]]++;
		}
		
		for (int i = k; i >= 0; i--) {
			while (count[i]-- > 0) {
				array[--size] = i;
			}
		}
		
	}
}
