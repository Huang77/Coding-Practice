package Sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main (String[] args) {
		int[] array = {1,2,5,3,6,7,3,0,1,0,0,0,11};
		bubbleSort_flag(array);
		System.out.println(Arrays.toString(array));
	}
	public static void bubbleSort (int[] array) {
		if (array == null || array.length <= 1) {
			return ;
		}
		for (int i = 0; i < array.length ; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * �Ľ���ð�����������ȫ��ѭ��û���֮ǰ������Ѿ�������ϣ���ôʣ�µıȽ�ʽ����Ҫ�ģ��������һ��flag������ڵ�ǰð�����Ƿ���Ԫ�ؽ��������û��Ԫ�ؽ������ʾ�����Ѿ���ɣ���������ѭ����
	 * @param array
	 */
	public static void bubbleSort_flag (int[] array) {
		if (array == null || array.length <= 1) {
			return ;
		}
		boolean change = false;
		
		for (int i = 0; i < array.length; i++) {
			change = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					change = true;
				}
			}
			if (change != true) {
				break;
			}
		}
	}
	
	public static void swap (int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
