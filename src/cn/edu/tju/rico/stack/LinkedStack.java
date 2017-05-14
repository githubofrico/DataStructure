package cn.edu.tju.rico.stack;

/**
 * Title: 自定义链式栈 
 * Description: 链式栈的实现
 * 
 * @author rico
 * @created 2017年4月6日 下午7:52:34
 */
public class LinkedStack<E> {

	private Node<E> top; // 栈顶元素
	private int size; // 链式栈的大小

	// 构造函数
	public LinkedStack(){
		
	}
	
	// 栈是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 压栈
	public void push(E data) {
		Node<E> node = new Node<E>(data, top); // 新加入的元素指向栈顶元素
		top = node;
		size++;
	}

	//弹栈(弹出并删除栈顶元素)
	public Node<E> pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("栈为空...");
		}

		Node<E> node = top;
		top = top.next;
		node.next = null;
		size--;
		return node;
	}

	// 打印栈
	public void print() {
		Node<E> index = top;
		while (index != null) {
			System.out.print(index.data + " ");
			index = index.next;
		}
	}

	
	// 私有内部类
	private class Node<T> {
		private Node<T> next;
		private T data;

		public Node(T data, Node<T> node) {
			this.data = data;
			next = node;
		}
	}

	//测试
	public static void main(String[] args) throws Exception {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("Rico");
		stack.push("TJU");
		stack.push("Livia");
		stack.push("NEU");

		stack.print();

		System.out.println();

		stack.pop();
		stack.print();
	}
}
