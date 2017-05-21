package cn.edu.tju.rico.sort;

/**        
 * Title: 选择排序中的直接选择排序   
 * Description: 每次找到数组中当前排序范围中的最小值并与该范围中的第一个数字交换，同时缩小待排序数组的排序范围
 * 				时间复杂度：最好情形O(n^2)，平均情形O(n^2)，最差情形O(n^2)
 * 				空间复杂度：O(1)
 * 				稳    定   性：不稳定
 * 				内部排序(在排序过程中数据元素完全在内存)
 * @author rico       
 * @created 2017年5月20日 上午10:40:00    
 */      
public class StraightSelectSort {
	
	public static int[] selectSort(int[] target){
		
		if(target != null && target.length != 1){
			for (int i = 0; i < target.length; i++) {
				int min_index = i;
				for (int j = i + 1; j < target.length; j++) {
					if(target[min_index] > target[j]){
						min_index = j;
					}
				}
				if(target[min_index] != target[i]){  // 导致不稳定的因素：交换
					int min = target[min_index];
					target[min_index] = target[i];
					target[i] = min;
				}
			}
		}
		return target;
	}
}
