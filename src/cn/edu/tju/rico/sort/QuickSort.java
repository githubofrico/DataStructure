package cn.edu.tju.rico.sort;

import java.util.Arrays;

/**
 * Title: 交换排序中的快速排序，目前应用最为广泛的排序算法，是一个递归算法
 * Description:快速排序包括两个过程：划分 和 快排
 * "划分"是指将原序列按基准元素划分两个子序列
 * "快排"是指分别对子序列进行快排
 * 
 * 就平均计算时间而言，快速排序是所有内部排序方法中最好的一个
 * 
 * 对大规模数据排序时，快排是快的；对小规模数据排序时，快排是慢的，甚至慢于简单选择排序等简单排序方法
 * 
 * 快速排序依赖于原始序列，因此其时间复杂度从O(nlgn)到O(n^2)不等
 * 时间复杂度：最好情形O(nlgn)，平均情形O(nlgn)，最差情形O(n^2)
 * 
 * 递归所消耗的栈空间
 * 空间复杂度：O(lgn)
 * 
 * 可选任一元素作为基准元素
 * 稳 定 性：不稳定
 * 
 * 
 * 内部排序(在排序过程中数据元素完全在内存)
 * 
 * @author rico
 * @created 2017年5月20日 上午10:40:00
 */
public class QuickSort {
	  
	/**     
	 * @description 快排算法(递归算法)：在递去过程中就把问题解决了
	 * @author rico       
	 * @created 2017年5月20日 下午5:12:06     
	 * @param target
	 * @param left
	 * @param right
	 * @return     
	 */
	public static int[] quickSort(int[] target, int left, int right) {
		if(right > left){     // 递归终止条件
			int base_index = partition(target,left, right);  // 原序列划分后基准元素的位置
			quickSort(target, left, base_index-1);    // 对第一个子序列快速排序，不包含基准元素！
			quickSort(target, base_index+1, right);   // 对第二个子序列快速排序，不包含基准元素！
		}
		return target;
	}
	
	  
	/**     
	 * @description 序列划分，以第一个元素为基准元素
	 * @author rico       
	 * @created 2017年5月20日 下午5:10:54     
	 * @param target  序列
	 * @param left 序列左端
	 * @param right  序列右端
	 * @return     
	 */
	public static int partition(int[] target, int left, int right){
		
		int base = target[left];   // 基准元素的值
		int base_index = left;    // 基准元素最终应该在的位置
		
		for (int i = left+1; i <= right; i++) {  // 从基准元素的下一个元素开始
			if(target[i] < base){       //  若其小于基准元素
				base_index++;           // 若其小于基准元素,则基准元素最终位置后移；否则不用移动
				if(base_index != i){	// 相等情况意味着i之前的元素都小于base,只需要换一次即可，不需要次次都换
					int temp = target[base_index];
					target[base_index] = target[i];
					target[i] = temp;
				}
			}
		}
		
		// 将基准元素就位
		target[left] = target[base_index];   
		target[base_index] = base;
		
		System.out.println(Arrays.toString(target));
		
		return base_index;  //返回划分后基准元素的位置
	}
}
