package cn.edu.tju.rico.stack;

import java.util.LinkedList;

  
/**        
 * Title: 借助于LinkedList实现栈   
 * Description: 
 * @author rico       
 * @created 2017年4月6日 下午8:25:21    
 */      
public class LinkedListStack<E> {
	
	// 支撑List
	private LinkedList<E> stack;
	
	// 构造函数
	public LinkedListStack(){
		stack = new LinkedList<E>();
	}
	
	// 是否为空
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	// 压栈
	public void push(E data){
		stack.addFirst(data);
	}
	
	//弹栈
	public E pop() throws Exception{
		if(stack.isEmpty()){
			throw new Exception("栈已满...");
		}
		
		return stack.pop();
	}
	
	@Override
	public String toString() {
		return stack.toString();
	}

	public static void main(String[] args) throws Exception {
		LinkedListStack<String> stack = new LinkedListStack<String>();
		stack.push("Rico");
		stack.push("TJU");
		stack.push("Livia");
		stack.push("NEU");

		System.out.println(stack);

		stack.pop();
		System.out.println(stack);
	}
}
