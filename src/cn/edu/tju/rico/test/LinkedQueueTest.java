package cn.edu.tju.rico.test;

import cn.edu.tju.rico.queue.LinkedQueue;

public class LinkedQueueTest {
	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		queue.put(1);
		queue.put(2);
		queue.put(4);
		queue.put(3);
		queue.put(0);
		System.out.println(queue);
		System.out.println("\n ------------------- \n");

		
		queue.pop();
		System.out.println(queue);
		System.out.println("\n ------------------- \n");
		
		
		System.out.println(queue.peek());
		queue.put(121);
		System.out.println(queue);
		
	}
}
