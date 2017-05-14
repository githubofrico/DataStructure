package cn.edu.tju.rico.stack;

import java.util.Comparator;

/**
 * Title: 增强自定义链式栈 [通过维护一个栈来保证用O(1)的时间复杂度求栈中的最小元素 (空间换取时间)]
 * Description: 使用额外的栈结构存储栈中的最小元素
 * 				如果当前入栈的元素比原来栈中的最小值还小，则将其保存到最小值栈中；否则，不做任何操作。
 *              如果当前出栈的元素正好是当前栈中的最小值，那么将最小值栈中的该最小值也一并弹出；否则，不做任何操作。
 * @author rico
 * @created 2017年4月6日 下午7:52:34
 */
public class LinkedStack<E> {
	
	private Node<E> top; // 栈顶元素
	private int size; // 链式栈的大小
	
	/**  最小值栈   (@author: rico) */    
	private LinkedStack<E> min;
	
	// 构造函数
	public LinkedStack(){
	}
	  
	/**     
	 * @description 判断栈是否为空
	 * @author rico       
	 * @created 2017年5月14日 上午10:54:44     
	 * @return     
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**     
	 * @description 压栈
	 * @author rico       
	 * @param data     
	 */
	public void push(E data) {
		Node<E> node = new Node<E>(data); 
		// 新加入的元素指向栈顶元素
		node.next = top;
		top = node;
		size++;
	}
	
	/**     
	 * @description 压栈操作,使用最小值栈
	 * @author rico       
	 * @param data     
	 */
	public void push(E data, Comparator<? super E> c) {
		push(data);
		if(min == null){
			min = new LinkedStack<E>();
		}
		if(min.peek() == null){
			min.push(data);
		}else if(c.compare(this.peek().data, min.peek().data) < 0){
			min.push(data);
		}
	}

	/**     
	 * @description 弹出并删除栈顶元素
	 * @author rico       
	 * @return
	 * @throws Exception     
	 */
	public Node<E> pop(){
		if (isEmpty()) {
			return null;
		}

		Node<E> node = top;
		top = top.next;
		node.next = null;
		size--;
		return node;
	}
	
	/**     
	 * @description 弹出并删除栈顶元素,使用最小值栈
	 * @author rico       
	 * @return
	 * @throws Exception     
	 */
	public Node<E> pop(Comparator<? super E> c){
		Node<E> temp = this.pop();
		if(temp != null && min.peek() != null){
			if(c.compare(temp.data, min.peek().data) == 0){
				min.pop();
			}
		}
		return temp;
	}
	
	/**     
	 * @description 弹出栈顶元素(不执行删除操作)
	 * @author rico       
	 * @return     
	 */
	public Node<E> peek(){
		if (isEmpty()) {
			return null;
		}
		return top;
	}

	/**     
	 * @description 获取当前栈中的最小值 
	 * @author rico       
	 * @return     
	 */
	public Node<E> min() {
		if(min.peek() == null){
			return null;
		}else{
			return min.peek();
		}
	}
	
	/**     
	 * @description 打印栈
	 * @author rico       
	 */
	public void print() {
		Node<E> index = top;
		while (index != null) {
			System.out.print(index.data + " ");
			index = index.next;
		}
		System.out.println();
	}
	  
	/**     
	 * @description 返回栈的大小
	 * @author rico       
	 * @return     
	 */
	public int size(){
		return size;
	}

	public LinkedStack<E> getMin() {
		return min;
	}

	public void setMin(LinkedStack<E> min) {
		this.min = min;
	}
}
