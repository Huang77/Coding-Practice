import java.util.Stack;

/**
 * Implement a stack with operations min(), push() and pop() in O(1)
 * 这里我们可以用一个额外的最小值stack来保存当前的最小值，
 * 每当元素被pop后，同时stack中当前最小值也被pop出；
 * 每当有push新元素时，与当前栈顶的最小值做比较，若新值较小，则push进最小值stack中，否则将当前最小值压入最小值stack中
 * @author HXX
 *
 */
public class MinStack<T extends Comparable> {
	private Stack<T> stack = new Stack<T>();
	private Stack<T> minStack = new Stack<T>();
	
	public void push (T obj) {
		if (stack.isEmpty()) {
			stack.push(obj);
			minStack.push(obj);
		} else {
			stack.push(obj);
			T temp = minStack.peek();
			if (temp.compareTo(obj) > 0) {
				minStack.push(obj);
			} else {
				minStack.push(temp);
			}
		}
	}
	
	public T pop () {
		if (stack.isEmpty() != true) {
			minStack.pop();
			return stack.pop();
		} else {
			return null;
		}
	}
	
	public T min () {
		return minStack.peek();
	}
	
	public static void main (String[] args) {
		MinStack<Integer> minStack = new MinStack<Integer>();
		minStack.push(2);
		System.out.println(minStack.min());
		minStack.push(3);
		System.out.println(minStack.min());
		minStack.push(1);
		System.out.println(minStack.min());
		minStack.pop();
		minStack.push(4);
		System.out.println(minStack.min());
		minStack.push(5);
		System.out.println(minStack.min());
	}
}
