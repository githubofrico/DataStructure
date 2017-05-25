package cn.edu.tju.rico.heap;

/**        
 * Title: 最小堆 ：完全二叉树，能方便地从中取出最小/大元素   
 * Description: 
 * 堆的构建
 * 堆的打印(前序遍历的应用)
 * 堆的插入(插入到堆尾，再自下向上调整为最小堆)
 * 堆的删除(删除堆顶元素并用堆尾元素添补，再自上向下调整为最小堆)
 * 堆排序(时间复杂度：O(nlgn),空间复杂度O(1),不稳定)：升序排序一般用最大堆
 * @author rico       
 * @created 2017年5月24日 下午9:23:22    
 */      
public class MinHeap {
	
	private int[] heap;  // 将所有元素以完全二叉树的形式存入数组
	private int size;  // 堆中元素的个数

	/**
	 * 构造函数
	 * 
	 * @description 构建一个大小为size的最小堆
	 * @author rico
	 * @created 2017年5月24日 下午8:19:46
	 * @param size
	 */
	public MinHeap(int maxSize) {
		heap = new int[maxSize];
	}

	/**
	 * 构造函数
	 * 
	 * @description 基于数组构造最小堆
	 * @author rico
	 * @created 2017年5月24日 下午8:18:56
	 * @param arr
	 */
	public MinHeap(int[] arr, int maxSize) {
		heap = new int[maxSize > arr.length ? maxSize : arr.length];
		System.arraycopy(arr, 0, heap, 0, arr.length);
		size = arr.length;

		int pos = (size - 2) / 2; // 最初调整位置：最后的分支节点(最后叶节点的父亲)
		while (pos >= 0) {    //依次调整每个分支节点
			shiftDown(pos, size - 1);
			pos--;
		}
	}

	/**
	 * @description 自上向下调整为最小堆(从不是最小堆调整为最小堆)，调整的前提是其左子树与右子树均为最小堆
	 * @author rico
	 * @created 2017年5月24日 下午7:52:39
	 * @param start
	 * @param end
	 */
	private void shiftDown(int start, int end) {
		int i = start;       // 起始调整位置，分支节点
		int j = 2 * start + 1;  // 该分支节点的子节点
		int temp = heap[i];   
		while (j <= end) {  // 迭代条件：子节点不能超出end(范围)
			if (j < end) { 
				j = heap[j] > heap[j + 1] ? j + 1 : j; // 选择两孩子中较小的那个
			}
			if (temp < heap[j]) {   // 较小的孩子大于父亲，不做任何处理
				break;
			} else {    // 否则，替换父节点的值
				heap[i] = heap[j];  
				i = j;
				j = 2 * j + 1;
			}
		}
		heap[i] = temp;  // 一步到位
	}
	
	/**     
	 * @description 自下向上调整为最小堆(原来已是最小堆，添加元素后，确保其还是最小堆)
	 * @author rico       
	 * @created 2017年5月24日 下午9:09:37     
	 * @param start     
	 */
	private void shiftUp(int start) {
		int j = start;
		int i = (j - 1) / 2;   // 起始调整位置，分支节点
		int temp = heap[j];
		while (j > 0) {      // 迭代条件：子节点必须不为根
			if (temp >= heap[i]) {  //原已是最小堆，所以只需比较这个子女与父亲的关系即可
				break;
			} else {
				heap[j] = heap[i];
				j = i;
				i = (j - 1) / 2;
			}
		}
		heap[j] = temp;   // 一步到位
	}

	/**
	 * @description 向最小堆插入元素(总是插入到最小堆的最后)
	 * @author rico
	 * @created 2017年5月24日 下午8:22:58
	 * @param data
	 */
	public void insert(int data){
		if (size < heap.length) {
			heap[size++] = data;   // 插入堆尾
			shiftUp(size-1);   // 自下而上调整
		}
	}

	  
	/**     
	 * @description 删除堆顶元素，以堆的最后一个元素填充
	 * @author rico       
	 * @created 2017年5月24日 下午9:11:46          
	 */
	public void remove() {
		if (size > 0) {
			heap[0] = heap[size-1];   // 删除堆顶元素，并将堆尾元素回填到堆顶
			size --;   // 堆大小减一
			shiftDown(0, size-1);   // 自上向下调整为最小堆
		}
	}
	
	  
	/**     
	 * @description 堆排序:每次将最小元素交换到最后
	 * @author rico       
	 * @created 2017年5月24日 下午9:42:31          
	 */
	public void sort(){
		for (int i = size - 1; i >= 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			
			shiftDown(0, i-1);
		}
		
		for (int i = size-1; i >= 0; i--) {
			System.out.print(heap[i] + " ");
		}
	}

	/**
	 * @description 打印根为 i 的最小堆
	 * @author rico
	 * @created 2017年5月24日 下午8:17:16
	 * @param i
	 */
	public void printMinHeap(int i) {
		if (size > i) {
			System.out.print(heap[i]);
			if (2 * i + 1 < size || 2 * i + 2 < size) {
				System.out.print("(");
				printMinHeap(2 * i + 1);
				System.out.print(",");
				printMinHeap(2 * i + 2);
				System.out.print(")");
			}
		}
	}
}
