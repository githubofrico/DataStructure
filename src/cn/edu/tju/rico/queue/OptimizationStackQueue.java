package cn.edu.tju.rico.queue;

import cn.edu.tju.rico.stack.LinkedStack;
import cn.edu.tju.rico.stack.Node;

/**
 * Title: 使用两个栈模拟一个队列 
 * Description: 其中一个栈专门用作入队(始终不执行出队操作)，另一个栈专门用作出队(始终不执行入队操作)
 * 				此种解法相对于StackQueue性能要高不少，避免了反复“倒”栈，仅在需要时才“倒”一次！！！
 * @author rico
 * @created 2017年5月19日 下午10:45:11
 */
public class OptimizationStackQueue<E> {

	private LinkedStack<E> stack1; // 入队栈
	private LinkedStack<E> stack2; // 出队栈

	public OptimizationStackQueue() {
		stack1 = new LinkedStack<E>();
		stack2 = new LinkedStack<E>();
	}

	/**
	 * @description 添加元素到队尾,直接对stack1执行压栈操作。
	 * @author rico
	 * @created 2017年5月19日 下午10:47:59
	 * @param e
	 */
	public void put(E e) {
		stack1.push(e);
	}

	/**
	 * @description 删除队头并返回队头元素的值。先检查stack2是否为空：
	 *              若为空，先将stack1中的元素倒回stack2(stack1元素不弹出！)，再对stack2执行弹栈操作
	 *              否则，则直接对stack2执行弹栈操作
	 * @author rico
	 * @created 2017年5月19日 下午10:48:32
	 * @return
	 */
	public E pop() {
		if (stack2.isEmpty()) {
			Node<E> temp = stack1.peek();  // Stack1始终不执行弹栈操作，peek：获取元素但不删除
			while (temp != null) {
				stack2.push(temp.getData());
				temp = temp.getNext();
			}
		}
		return stack2.pop().getData();
	}

	@Override
	public String toString() {
		String str = new StringBuilder(stack1.toString()).reverse().toString();
		if(stack2.isEmpty()){
			return str;
		}
		return str.substring(str.indexOf(stack2.peek().getData().toString()));
	}
}
