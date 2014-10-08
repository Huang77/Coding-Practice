

/*百度面试题：求绝对值最小的数
 *有一个已经排序的数组（升序），数组中可能有正数、负数或0，求数组中元素的绝对值最小的数，要求，不能用顺序比较的方法（复杂度需要小于O（n））
 *例如，数组{-20，-13，-4, 6, 77,200} ，绝对值最小的是-4。
 */


public class MinAbsNum {
	public static void main (String[] args) {
		int[] array = {-40, -20, -13, -4, 0, 3, 6, 77, 200};
		System.out.println(getMinAbsNum(array));
	}
	public static int getMinAbsNum (int[] array) {
		if (array == null) {
			System.out.println("The input array is null.");
			return 0;
		}
		if (array[0] >= 0) {
			return array[0];
		} 
		int size = array.length;
		if (array[size - 1] <= 0) {
			return array[size - 1];
		}
		int start = 0, end = size - 1;
		int mid;
		while (start < end) {
			mid = start + ((end - start) >> 1);
			if (array[mid + 1] < 0) {
				start = mid + 1;
			} else if (array[mid] > 0) {
				end = mid;
			} else if (array[mid] + array[mid + 1] >= 0) {
				return array[mid];
			} else {
				return array[mid + 1];
			}
		}
		return 0;
	}
	
}
