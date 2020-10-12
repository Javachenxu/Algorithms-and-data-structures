package com.cx;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


import com.cx.printer.BinaryTreeInfo;

/*
 * 接口设计：
 * int size() // 元素的数量
 * boolean isEmpty() // 是否为空
 * void clear() // 清空所有元素
 * void add(E element) // 添加元素
 * void remove(E element) // 删除元素
 * boolean contains(E element) // 是否包含某元素
 */
@SuppressWarnings("unchecked")
public class BinarySearchtree<E> implements BinaryTreeInfo {//调用打印器
	
	private int size;
	private Node<E> root;
	
	private Comparator<E> comparetor;
	public BinarySearchtree() {
		this(null);
	}
	public BinarySearchtree(Comparator comparetor) {
		this.comparetor = comparetor;
	}
	//元素的数量
	public int size() {
		return size();
	}
	//判断是否为空
	public boolean isEmpty() {
		return size() == 0;
	}
	//清空
	public void clear() {
		
	}
	//二叉树前序遍历(递归实现)
	public void preorderTraversal() {
		preorderTraversal(root);
	}
	private void preorderTraversal(Node<E> node) {
		if (node == null) return;
		
		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
		
	}
	
	//前序遍历非递归实现(栈)
	/*思路一：
	 * 根节点存入栈中打印根节点，然后访问这个根节点的左子树，左子树也是将左子树的根存入栈中打印根节点，
	 * 依次往下直到左子树为空，再取出栈顶元素，栈顶元素(访问完左子树的根节点)作为新的根节点去访问右子树。
	 */
	
	public void preorderTraversal1() {
		Node<E> node = root;//这样设置，而非将root入栈，可以代表每个完整树的开始
		if (node == null) return;//边界判断
		
		Stack<E> stack = new Stack<>();
		System.out.println("前序遍历为");
		while (!stack.isEmpty() || node != null) {
			 //沿着p的左指针非空进栈走到最左，最左边可能有两种情况，最左子树无左右子树和最左子树只有右子树
			while (node != null) {
				
				stack.push((E) node);//前序遍历，先访问节点，
				System.out.print(node.element+ "_");//打印根节点
				node = node.left;//访问左子树
			}
				node = (Node<E>) stack.pop();//栈顶元素出栈
				node = node.right;//栈顶元素作为新的根节点访问右子树
		}
	}
	
	/*
	 * 思路二：我们知道前序遍历遵从根左右的顺序，所以我们打印根节点，并将它的右子树，左子树按照顺序压入栈中，
	 * 每次只取出栈顶的一个节点，这样就可以保证所有的左子树都会在右子树之前取出并打印。
	 */
	public void preorderTraversal2() {
		Stack<E> stack = new Stack<>();
		
		if (root == null) return;
		
		stack.push((E) root);
		System.out.println("前序遍历为：");
		while (!stack.isEmpty()) {
			Node<E> node  = (Node<E>) stack.pop();
			System.out.print(node.element +"_");
			//栈先进后出，所以先让右子树入栈
			if (node.right != null) {
				stack.push((E) node.right);
			}
			if (node.left != null) {
				stack.push((E) node.left);
			}
		}
	}
	
	//二叉树中序遍历(递归实现)
	
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<E> node) {
		if (node == null) return;
		
		inorderTraversal(node.left);
		System.out.println(node.element);
		inorderTraversal(node.right);
	}
	
	//二叉树中序遍历(非递归实现)
	
		/*思路：
		 * 先访问根节点的左子树，依次往下直到左子树为空，再取出栈顶元素，并且打印栈顶元素，
		 * 最后，栈顶元素(访问完左子树的根节点)作为新的根节点去访问右子树。
		 */
		
		public void inorderTraversal1() {
			Node<E> node = root;
			if (node == null) return;
			System.out.println("中序遍历为");
			Stack<E> stack = new Stack<>();
			while (!stack.isEmpty() || node != null) {
				while (node != null) {
					stack.push((E) node);//强制转换为泛型
					node = node.left;
				}		
					node = (Node<E>) stack.pop();
					System.out.println(node.element + "_");
					
					node = node.right;
			}
		}
	
	//二叉树后序遍历(递归实现)
	
	public void postorderTraversal() {
		System.out.println("后序遍历为：");
		postorderTraversal(root);
		System.out.print("\n");
		
	}
	
	private void postorderTraversal(Node<E> node) {
		if(node == null) return;
		
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.element + " ");
		
	}
	
	//二叉树后序遍历(非递归实现思路一)
	
	/*
	 * 思路：当左孩子完成打印并从栈中弹出父结点的时候，此时需要判断右孩子需不需要打印，有两种情况：
	 * 1.如果右孩子为空，或者右孩子已经完成了打印，则打印当前的结点
	 * 2.右孩子未打印过，则需要将右孩子入栈
	 * 这里设置一个指针last来标记上一次打印的结点，这样只要判断last是不是右孩子就知道右孩子打印过没有了
	 * 具体步骤为：
	 * 1.不断往左子树深入并不断入栈直到左叶子的空左孩子
	 * 2.弹出栈顶，如果右孩子为null或者last是右孩子，则打印当前值；如果不是，则将指针指向右孩子
	 * 3.循环1,2步骤直至栈为空且指针也为空
	 */
	
	public void postorderTraversal1() {
		Node<E> node = root;//保证root为完整二叉树
		Node<E> last = null;//设计一个last指针，标记上一次打印的结点
		if (node == null) return;//边界判断
		System.out.println("后序遍历为：");
		Stack<E> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push((E) node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				Node<E> t = (Node<E>) stack.pop();
				if (t.right == null || last == t.right) {
					System.out.print(t.element + " ");
					last = t;
				} else {
					stack.push((E) t);
					node = t.right;
				}
			}
		}
	}
	//二叉树后序遍历(非递归实现思路二)
	
	/*
	 * 思路：用一个线性表存放后序遍历的结果。我们知道后序遍历是左右根，
	 * 但是我们可以反过来，一样先访问根，只是将根放在后边然后访问右子树放在根的前边左子树的后边，
	 * 我们可以用线性表头插来实现这个操作，先访问根再左子树再右子树，
	 * 只是每次都对线性表进行头插，这样最后的结果就还是左右根。
	 */
	
	public List<E>  postorderTraversal2() {
		Stack<E> stack = new Stack<>();
		List<E> list = new LinkedList<>();
		Node<E> node = root;
		if (node == null) return list;
		stack.push((E) node);
		stack.add((E) root);
		
        while (!stack.isEmpty()) {
            node = (Node<E>) stack.pop();
            list.add(0,node.element);//每次在链表的头部插入元素
            if (node.left != null) {  //注意与前序对比着看 
                stack.push((E) node.left);
            }
            if (node.right != null) {
                stack.push((E) node.right);
            }
            
        }
        System.out.print(list);
  
        return list;
	}
	
	//二叉树层序遍历(使用队列实现)
	
	/*
	 * 1.将根节点入队
	 * 2.循环执行以下操作，直到队列为空
	 * 2.1将队头节点A出队，进行访问
	 * 2.2将A的左子节点入队
	 * 2.3将A的右子节点入队
	 */
	
	public void levelOrderTraversal() {
		if (root == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			System.out.println(node.element);
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			

			if (node.right != null) {
				queue.offer(node.right);
			}
			
		}
	}
	
	//求二叉树的高度
	/*
	 * 1.递归法
	 * 树的高度即是根节点的高度
	 */
	public int height() {
		return height(root);
	}
	
	private int height(Node<E> node) {
		if (node == null) return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	/*
	 * 2.非递归法
	 *     层序遍历法
	 */
	
	public int height1() {
		if (root == null) return 0;
		
		int height = 0;
		int levelSize = 1;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (levelSize ==0) {
				levelSize = queue.size();
				height++;
			}
			
		}
		return height;
	}
	//添加
	public void add(E element) {
		elementNotNullCheck(element);
		//添加第一个节点
		if (root == null) {
			root = new Node<>(element,null);
			size++;
			return;
		}
		//添加后续节点
		//找到父节点
		//创建新节点node
		//parent.left = node 或者 parent.right = node
		
		Node<E> parent = null;
		
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;//父节点
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else {//相等
				node.element = element;
				return;
			} 
		}
		//看看插入到父节点的那个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
	}
	//删除
	public void remove(E element) {
		
	}
	//是否包含某元素
	public boolean contains(E element) {
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(root,sb,"");
		return sb.toString();
	}
	
	private void toString(Node<E> node,StringBuilder sb,String prefix) {
		if (node == null) return;
		sb.append(prefix).append(node.element).append("\n");
		toString(node.left,sb,prefix + "L---");
		
		toString(node.right,sb,prefix + "R---");
		
		
	}
	
	//比较函数
	/*
	 * @return 返回值等于0，代表e1与e2相等，返回值大于0，代表e1大于e2,
	 * 返回值小于0，代表e1小于e2.
	 */
	
	private int compare(E e1,E e2) {
		if (comparetor != null) {
			return comparetor.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {//非法参数异常
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;//父节点
		
		public  Node(E element,Node<E> parent) {
			this.parent = parent;
			this.element = element;
		}
	}

	@Override
	public Object root() {
		
		return root;
	}
	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}
	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}
	@Override
	//打印出parent节点
	public Object string(Object node) {
		Node<E> myNode = (Node<E>)node;
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}
}

