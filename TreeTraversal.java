import java.util.LinkedList;
import java.util.Stack;



class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode (int val) {
		value = val;
		left = null;
		right = null;
	}
}

public class TreeTraversal {
	// preorder recursive
	public static void preorderRecursive (TreeNode root) {
		if (root != null) {
			System.out.print(root.value + " "); // process the node
			preorderRecursive(root.left);
			preorderRecursive(root.right);
		}
	}
	
	// preorder non-recursive
	public static void preorderNonRecursive (TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode curNode;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			curNode = stack.pop();
			System.out.print(curNode.value + " "); // process the node
			if (curNode.right != null) {
				stack.push(curNode.right);
			}
			if (curNode.left != null) {
				stack.push(curNode.left);
			}
		}
	}
	
	// inorder recursive
	public static void inorderRecursive (TreeNode root) {
		if (root != null) {
			inorderRecursive(root.left);
			System.out.print(root.value + " ");
			inorderRecursive(root.right);
		}
	}
	
	// inorder non-recursive
	public static void inorderNonRecursive (TreeNode root) {
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode curNode = root.left;
		while (curNode != null || !stack.isEmpty()) {
			while(curNode != null) {
				stack.push(curNode);
				curNode = curNode.left;
			}
			curNode = stack.pop();
			System.out.print(curNode.value + " "); // process the node
			curNode = curNode.right;
		}
	}
	
	// postorder recursive
	public static void postorderRecursive (TreeNode root) {
		if (root != null) {
			postorderRecursive(root.left);
			postorderRecursive(root.right);
			System.out.print(root.value + " ");
		}
	}
	
	// postorder non-recursive
	public static void postorderNonRecursive (TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode curNode = stack.peek();  // 指向栈顶节点，如果栈顶节点的左右子树为空，或者它的左节点或右节点已经被访问，则弹出该节点并处理。
		TreeNode lastVisitedNode = null; // 用来记录最上一个处理的node，用来判断当前节点是否需要弹出处理
			
		while (curNode != null || !stack.isEmpty()) {
			if ((curNode.left == null && curNode.right == null)
					|| (lastVisitedNode == curNode.left)
					|| (lastVisitedNode == curNode.right)) {
				curNode = stack.pop();
				System.out.print(curNode.value + " "); // process the node
				lastVisitedNode = curNode;
				if (!stack.isEmpty()) {
					curNode = stack.peek();
				} else {
					break;
				}
				
			} else {
				if (curNode.right != null) {
					stack.push(curNode.right);
				}
				if (curNode.left != null) {
					stack.push(curNode.left);
				}
				curNode = stack.peek();
			}
		}
	}
	
	// level-order non-recursive
	public static void levelOrderNonRecursive (TreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode curNode;
		
		while (!queue.isEmpty()) {
			curNode = queue.removeFirst();
			System.out.print(curNode.value + " "); // process the node
			if (curNode.left != null) {
				queue.addLast(curNode.left);
			}
			if (curNode.right != null) {
				queue.add(curNode.right);
			}
		}
	}
	
	
	
	// test
	public static void main (String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println("Preorder Recursive");
		TreeTraversal.preorderRecursive(root);
		System.out.println("\nPreorder Non-Recursive");
		TreeTraversal.preorderNonRecursive(root);
		
		System.out.println("\nInorder Recursive");
		TreeTraversal.inorderRecursive(root);
		System.out.println("\nInorder Non-Recursive");
		TreeTraversal.inorderNonRecursive(root);
		
		System.out.println("\nPostorder Recursive");
		TreeTraversal.postorderRecursive(root);
		System.out.println("\nPostorder Non-Recursive");
		TreeTraversal.postorderNonRecursive(root);
		
		System.out.println("\nLevel-order Non-Recursive");
		TreeTraversal.levelOrderNonRecursive(root);
	}
}
