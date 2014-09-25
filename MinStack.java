import java.util.Stack;

/**
 * Implement a stack with operations min(), push() and pop() in O(1)
 * �������ǿ�����һ���������Сֵstack�����浱ǰ����Сֵ��
 * ÿ��Ԫ�ر�pop��ͬʱstack�е�ǰ��СֵҲ��pop����
 * ÿ����push��Ԫ��ʱ���뵱ǰջ������Сֵ���Ƚϣ�����ֵ��С����push����Сֵstack�У����򽫵�ǰ��Сֵѹ����Сֵstack��
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
