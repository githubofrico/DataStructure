package cn.edu.tju.rico.sort;

import java.util.Arrays;

/**
 * Title: 插入排序中的直接插入排序 ，依赖于初始序列 Description: 在有序序列中不断插入新的记录以达到扩大有序区到整个数组的目的
 * 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2) 空间复杂度：O(1) 稳 定 性：稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 * 
 * @author rico
 * @created 2017年5月20日 上午10:40:00
 */
public class StraightInsertionSort {

	public static int[] insertSort(int[] target) {

		if (target != null && target.length != 1) { // 待排序数组不为空且长度大于1
			for (int i = 1; i < target.length; i++) { // 不断扩大有序序列，直到扩展到整个数组
				for (int j = i; j > 0; j--) { // 向有序序列中插入新的元素
					if (target[j] < target[j - 1]) { // 交换
						int temp = target[j];
						target[j] = target[j - 1];
						target[j - 1] = temp;
					} else {
						break;
					}
				}
			}
		}
		return target;
	}

	public static void main(String[] args) {
		int[] test = {1,9,3,5,2,0,3,5};
		System.out.println(Arrays.toString(StraightInsertionSort.insertSort(test)));
	}
}
