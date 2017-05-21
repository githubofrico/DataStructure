package cn.edu.tju.rico.sort;
  
/**        
 * Title: 插入排序中的希尔排序  
 * Description: 分别对间隔为gap的gap个子序列进行直接插入排序，不断缩小gap,直至为 1 
 * 
 * 				刚开始时，gap较大，每个子序列元素较少，排序速度较快；
 * 				待到排序后期，gap变小，每个子序列元素较多，但大部分元素基本有序，所以排序速度仍较快。				
 * 
 * 				时间复杂度：O(n) ~ O(n^2)
 * 				空间复杂度：O(1)
 * 				稳    定   性：不稳定
 * 				内部排序(在排序过程中数据元素完全在内存)
 * @author rico       
 * @created 2017年5月20日 上午10:40:00    
 */      
public class ShellSort {
	
	  
	/**     
	 * @description 
	 * @author rico       
	 * @created 2017年5月21日 下午7:56:03     
	 * @param target
	 * @return     
	 */
	public static int[] shellSort(int[] target){
		if(target != null && target.length != 1){
			int gap = target.length;       // gap个大小为gap的子序列
			do{
				gap = gap/3 + 1;     // 不断缩小gap直至为1
				for (int i = 0 + gap; i < target.length; i++) {   // 对每个子序列进行直接插入排序
					if(target[i] < target[i-gap]){
						int j = i - gap;
						int temp = target[i];         // 待插入值
						do{
							target[j + gap] = target[j];         // 后移元素
							j = j - gap;          // 再比较前一个元素
						}while(j >= 0 && target[j] > temp);  // 向前比较的终止条件
						target[j + gap] = temp;         // 将待插入值插入合适的位置
					}
				}
			}while(gap > 1);
		}
		return target;
	}
}
