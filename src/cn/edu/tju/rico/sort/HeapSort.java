package cn.edu.tju.rico.sort;
  
/**        
 * Title: 堆排序(选择排序)，升序排序(最大堆)   
 * Description: 现将给定序列调整为最大堆，然后每次将堆顶元素与堆尾元素交换并缩小堆的范围，直到将堆缩小至1
 * 时间复杂度：O(nlgn)
 * 空间复杂度：O(1) 
 * 稳 定 性：不稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 * @author rico       
 * @created 2017年5月25日 上午9:48:06    
 */      
public class HeapSort {

	public static int[] heapSort(int[] target) {
		if (target != null && target.length > 1) {
			
			// 调整为最大堆
			int pos = (target.length - 2) / 2;
			while (pos >= 0) {
				shiftDown(target, pos, target.length - 1);
				pos--;
			}

			// 堆排序
			for (int i = target.length-1; i > 0; i--) {
				int temp = target[i];
				target[i] = target[0];
				target[0] = temp;
				shiftDown(target, 0, i-1);
			}
			return target;
		}
		return target;
	}

	  
	/**     
	 * @description 自上而下调整为最大堆
	 * @author rico       
	 * @created 2017年5月25日 上午9:45:40     
	 * @param target
	 * @param start
	 * @param end     
	 */
	private static void shiftDown(int[] target, int start, int end) {
		int i = start;
		int j = 2 * start + 1;
		int temp = target[i];
		while (j <= end) {   // 迭代条件
			if (j < end && target[j + 1] > target[j]) {  //找出较大子女
				j = j + 1;
			}
			if (target[j] <= temp) {  // 父亲大于子女
				break;
			} else {
				target[i] = target[j];
				i = j;
				j = 2 * j + 1;
			}
		}
		target[i] = temp;
	}
}
