package Sorting;

import java.util.Arrays;

public class HeapSort {
	public static void main (String[] args) {
		int[] array = {2,0,-1};
		heapSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void heapSort (int[] array) {
		int size = array.length;
		
		// ������
		for (int i = (size / 2 - 1); i >= 0; i--) {
			shiftDown(array, i, size - 1);
		}
		
		// ������
		for (int i = size - 1; i > 0; i--) {
			swap(array, 0, i);
			shiftDown(array, 0, i - 1);
		}
	}
	
	public static void shiftDown (int[] array, int start, int end) {
		int shiftDownValue = array[start];
		int curPos = 2 * start + 1; // start��������
		
		while (curPos <= end) {
			if (curPos + 1 <= end && array[curPos + 1] > array[curPos]) { // ѡ�������ӽ���нϴ�Ľ��
				curPos++;          
			}
			if (shiftDownValue >= array[curPos]) { // �ҵ����ʵ�λ��
				break;
			} else {
				array[(curPos - 1) / 2] = array[curPos];
				curPos = 2 * curPos + 1;
			}
		}
		array[(curPos - 1) / 2] = shiftDownValue;
	}
	
	public static void swap (int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
