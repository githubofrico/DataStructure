package cn.edu.tju.rico.sort;

import java.util.Arrays;

/**
 * Title: 归并排序 ，概念上最为简单的排序算法，是一个递归算法 Description:归并排序包括两个过程：归 和 并
 * "归"是指将原序列分成半子序列，分别对子序列进行递归排序 "并"是指将排好序的各子序列合并成原序列
 * 
 * 归并排序的主要问题是：需要一个与原待排序数组一样大的辅助数组空间
 * 
 * 归并排序不依赖于原始序列，因此其最好情形、平均情形和最差情形时间复杂度都一样 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 * 空间复杂度：O(n) 稳 定 性：稳定 内部排序(在排序过程中数据元素完全在内存)
 * 
 * @author rico
 * @created 2017年5月20日 上午10:40:00
 */
public class MergeSort {

	/**
	 * @description 归并排序算法(递归算法)：递去分解，归来合并
	 * @author rico
	 * @created 2017年5月20日 下午4:04:52
	 * @param target
	 *            待排序序列
	 * @param left
	 *            待排序序列起始位置
	 * @param right
	 *            待排序序列终止位置
	 * @return
	 */

	public static void mergeSort(int[] target) {
		int[] copy = Arrays.copyOf(target, target.length);    // 空间复杂度O(n)
		mergeSort(target, copy, 0, target.length - 1);
	}

	public static void mergeSort(int[] target, int[] copy, int left, int right) {
		if (right > left) { // 递归终止条件
			int mid = (left + right) / 2;
			mergeSort(target, copy, left, mid); // 归并排序第一个子序列
			mergeSort(target, copy, mid + 1, right); // 归并排序第二个子序列
			merge(target, copy, left, mid, right); // 合并子序列成原序列
		}
	}

	/**
	 * @description 两路归并算法
	 * @author rico
	 * @created 2017年5月20日 下午3:59:16
	 * @param target
	 *            用于存储归并结果
	 * @param left
	 *            第一个有序表的第一个元素所在位置
	 * @param mid
	 *            第一个有序表的最后一个元素所在位置
	 * @param right
	 *            第二个有序表的最后一个元素所在位置
	 * @return
	 */
	public static void merge(int[] target, int[] copy, int left, int mid,
			int right) {

		// s1,s2是检查指针，index 是存放指针
		int s1 = left;
		int s2 = mid + 1;
		int index = left;

		// 两个表都未检查完，两两比较
		while (s1 <= mid && s2 <= right) {
			if (copy[s1] <= copy[s2]) { // 稳定性
				target[index++] = copy[s1++];
			} else {
				target[index++] = copy[s2++];
			}
		}

		// 若第一个表未检查完，复制
		while (s1 <= mid) {
			target[index++] = copy[s1++];
		}

		// 若第二个表未检查完，复制
		while (s2 <= right) {
			target[index++] = copy[s2++];
		}
		
		// 更新辅助数组 copy
		for (int i = left; i <= right; i++) {
			copy[i] = target[i];
		}
	}
	
	public static void main(String[] args) {
		int[] target = { 21, 25, 49, 25, 16, 8, 31, 41 };
		mergeSort(target);
		System.out.println(Arrays.toString(target));
	}
}
