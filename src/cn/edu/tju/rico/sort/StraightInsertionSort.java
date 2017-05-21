package cn.edu.tju.rico.sort;
  
/**        
 * Title: 插入排序中的直接插入排序  
 * Description: 在有序序列中不断插入新的记录以达到扩大有序区到整个数组的目的
 * 				时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 * 				空间复杂度：O(1)
 * 				稳    定   性：稳定
 * 				内部排序(在排序过程中数据元素完全在内存)
 * @author rico       
 * @created 2017年5月20日 上午10:40:00    
 */      
public class StraightInsertionSort {
	
	public static int[] insertSort(int[] target){
		
		if(target != null && target.length != 1){
			for (int i = 1; i < target.length; i++) {
				for (int j = i; j > 0; j--) {
					if(target[j]  < target[j-1]){
						int temp = target[j];
						target[j] = target[j-1];
						target[j-1] = temp;
					}
				}
			}
		}
		return target;
	}
}
