package cn.edu.tju.rico.sort;

/**        
 * Title: 分配排序中的基数排序  
 * Description: 不是在对元素进行比较的基础上进行排序，而是采用 "分配 + 收集" 的办法 
 * 
 * 				首先，将目标序列各元素分配到各个桶中；
 * 				其次，将各个桶中的元素按先进先出的顺序再放回去
 * 				如此往复...				
 * 
 * 				时间复杂度：O(d*(r+n))或者 O(dn),d 的大小一般会受到 n的影响
 * 				空间复杂度：O(rd + n)或者 O(n)
 * 				稳    定   性：稳定
 * 				内部排序(在排序过程中数据元素完全在内存)
 * @author rico       
 * @created 2017年5月20日 上午10:40:00    
 */   
public class RadixSort {

	/**     
	 * @description 分配 + 收集
	 * @author rico       
	 * @created 2017年5月21日 下午9:25:52     
	 * @param target 待排序数组
	 * @param r 基数
	 * @param d 元素的位数
	 * @param n 待排序元素个数
	 * @return     
	 */
	public static int[] radixSort(int[] target, int r, int d, int n){
		if (target != null && target.length != 1 ) {
			
			int[][] bucket = new int[r][n];  // 一共有基数r个桶，每个桶最多放n个元素
			int digit;  // 获取元素对应位上的数字，即装入那个桶
			int divisor = 1;   // 定义每一轮的除数，1, 10, 100, ...
			int[] count = new int[r];   // 统计每个桶中实际存放元素的个数
			
			for (int i = 0; i < d; i++) {  // d 位的元素，需要经过分配、收集d次即可完成排序
				
				// 分配
				for (int ele : target) {   
					digit = (ele/divisor) % 10;  // 获取元素对应位上的数字(巧妙！！！)
					bucket[digit][count[digit]++] = ele; // 将元素放入对应桶，桶中元素数目加1
				}
				
				// 收集
				int index = 0;  // 目标数组的下标
				for (int j = 0; j < r; j++) {
					int k = 0;    // 用于按照先进先出顺序获取桶中元素
					while(k < count[j]){
						target[index++] = bucket[j][k++];  // 按照先进先出依次取出桶中的元素
					}
					count[j] = 0;  // 计数器归零
				}
				divisor *= 10;  	//用于获取元素对应位数字
			}
		}
		return target;
	}
}
