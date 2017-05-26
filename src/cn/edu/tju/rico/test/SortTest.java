package cn.edu.tju.rico.test;

import java.util.Arrays;

import cn.edu.tju.rico.sort.BinaryInsertSort;
import cn.edu.tju.rico.sort.BubbleSort;
import cn.edu.tju.rico.sort.HeapSort;
import cn.edu.tju.rico.sort.MergeSort;
import cn.edu.tju.rico.sort.QuickSort;
import cn.edu.tju.rico.sort.RadixSort;
import cn.edu.tju.rico.sort.ShellSort;
import cn.edu.tju.rico.sort.StraightInsertionSort;
import cn.edu.tju.rico.sort.StraightSelectSort;

public class SortTest {

	public static void main(String[] args) {

		int[] target1 = { 38, 65, 97, 76, 13, 27, 49 };
		System.out.println("直接选择排序 ： ");
		System.out.println("原数组 ： " + Arrays.toString(target1));
		StraightSelectSort.selectSort(target1);
		System.out.println(Arrays.toString(target1));

		System.out.println("\n----------------------\n");
		System.out.println("直接插入排序 ： ");
		int[] target2 = { 38, 65, 97, 76, 13, 27, 49 };
		System.out.println("原数组 ： " + Arrays.toString(target2));
		StraightInsertionSort.insertSort(target2);
		System.out.println(Arrays.toString(target2));

		System.out.println("\n----------------------\n");
		System.out.println("冒泡排序 ： ");
		int[] target3 = { 1, 2, 3, 4, 5, 8, 7, 6 };
		System.out.println("原数组 ： " + Arrays.toString(target3));
		BubbleSort.bubbleSort(target3);

		System.out.println("\n----------------------\n");
		System.out.println("优化冒泡排序 ： ");
		int[] target4 = { 1, 2, 3, 4, 5, 8, 7, 6 };
		System.out.println("原数组 ： " + Arrays.toString(target4));
		BubbleSort.optimizeBubbleSort(target4);

		System.out.println("\n----------------------\n");
		System.out.println("归并排序 ： ");
		int[] target5 = { 21, 25, 49, 25, 16, 8, 31, 41 };
		System.out.println("原数组 ： " + Arrays.toString(target5));
		MergeSort.mergeSort(target5, 0, target5.length - 1);
		System.out.println(Arrays.toString(target5));

		System.out.println("\n----------------------\n");
		System.out.println("快速排序 ： ");
		int[] target6 = { 21, 25, 49, 25, 16, 8, 31, 41 };
		System.out.println("原数组 ： " + Arrays.toString(target6));
		QuickSort.quickSort(target6, 0, target6.length - 1);
		System.out.println(Arrays.toString(target6));
		
		System.out.println("\n----------------------\n");
		System.out.println("希尔排序 ： ");
		int[] target7 = { 21, 25, 49, 25, 16, 8, 31, 41 };
		System.out.println("原数组 ： " + Arrays.toString(target7));
		ShellSort.shellSort(target7);
		System.out.println(Arrays.toString(target7));
		
		System.out.println("\n----------------------\n");
		System.out.println("基数排序 ： ");
		int[] target8 = { 332, 633, 598, 232, 664, 179, 457, 825, 405, 361};
		System.out.println("原数组 ： " + Arrays.toString(target8));
		RadixSort.radixSort(target8,10,3,target8.length);
		System.out.println(Arrays.toString(target8));
		
		System.out.println("\n----------------------\n");
		System.out.println("基数排序 ： ");
		int[] target9 = { 21, 25, 49, 25, 16, 18, 31, 41 };
		System.out.println("原数组 ： " + Arrays.toString(target9));
		RadixSort.radixSort(target9,10,2,target9.length);
		System.out.println(Arrays.toString(target9));
		
		System.out.println("\n----------------------\n");
		System.out.println("堆排序 ： ");
		int[] target10 = { 21, 25, 49, 25, 16, 18, 31, 41 };
		System.out.println("原数组 ： " + Arrays.toString(target10));
		HeapSort.heapSort(target10);
		System.out.println(Arrays.toString(target10));
		
		System.out.println("\n----------------------\n");
		System.out.println("折半插入排序 ： ");
		int[] target11 = { 21, 25, 49, 25, 16, 18, 31, 41, 21, 9 };
		System.out.println("原数组 ： " + Arrays.toString(target11));
		BinaryInsertSort.binaryInsertSort(target11);
		System.out.println(Arrays.toString(target11));
	}
}
