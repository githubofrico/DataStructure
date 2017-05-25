package cn.edu.tju.rico.test;

import cn.edu.tju.rico.heap.MinHeap;

public class MinHeapTest {
	public static void main(String[] args) {
		
		int[] arr = {53, 17, 78, 9, 45, 65, 87, 23};
		MinHeap heap = new MinHeap(arr,20);
		System.out.println("堆：");
		heap.printMinHeap(0);
		System.out.println("\n---------------------------\n");
		System.out.println("向堆中插入元素7后，堆变为：");
		heap.insert(7);
		heap.printMinHeap(0);
		System.out.println("\n---------------------------\n");
		System.out.println("删除堆中末尾元素，堆变为：");
		heap.remove();
		heap.printMinHeap(0);
		System.out.println("\n---------------------------\n");
		System.out.println("堆排序结果为：");
		heap.sort();
	}
}
