package cn.edu.tju.rico.test;

import cn.edu.tju.rico.queue.StackQueue;

public class StackQueueTest {
	public static void main(String[] args) {
		StackQueue<Integer> queue = new StackQueue<Integer>();
		queue.put(1);
		queue.put(3);
		queue.put(5);
		queue.put(2);
		queue.put(8);
		queue.put(6);
		System.out.println(queue);
		System.out.println("\n------------------\n");
		
		queue.pop();
		System.out.println(queue);
		System.out.println("\n------------------\n");
		
		queue.put(4);
		System.out.println(queue);
		System.out.println("\n------------------\n");
	}
}
