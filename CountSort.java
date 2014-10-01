package Sorting;

import java.util.Arrays;

public class CountSort {
	public static void main (String[] args) {
		int[] array = {2,0,1,1,1,2,2,4,4,6,1,0,1};
		countSort_useTempArray(array, 7);
		System.out.println(Arrays.toString(array));
	}
	
	public static void countSort (int[] array, int k) {
		int[] count = new int[k];
		int size = array.length;
		
		for (int i = 0; i < size; i++) {
			count[array[i]]++;
		}
		
		for (int i = k - 1; i >= 0; i--) {
			while (count[i]-- > 0) {
				array[--size] = i;
			}
		}
	}
	
	public static void countSort_useTempArray (int[] array, int k) {
		int[] temp = new int[array.length];
		int[] count = new int[k];
		
		for (int i = 0; i < array.length; i++) {
			count[array[i]]++;
		}
		for (int i = 0; i < k - 1; i++) {
			count[i + 1] += count[i];
		}
		for (int i = array.length - 1; i >= 0; i--) {
			temp[--count[array[i]]] = array[i];
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = temp[i];
		}
	}
}
