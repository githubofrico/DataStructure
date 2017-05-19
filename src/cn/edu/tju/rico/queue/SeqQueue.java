package cn.edu.tju.rico.queue;

import java.util.Arrays;

  
/**        
 * Title: 基于数组的队列实现     
 * Description: 
 * @author rico       
 * @created 2017年5月19日 下午8:23:55    
 */      
public class SeqQueue<E> {

	
	/**  队列的存储结构   (@author: rico) */      
	private Object[] queue;         
	private int size;
	private int maxSize;    // 最大容量
	
	public SeqQueue(int maxSize){
		this.maxSize = maxSize;
		queue = new Object[maxSize];
	}
	
	  
	/**     
	 * @description 添加元素到队尾
	 * @author rico       
	 * @created 2017年5月19日 下午8:25:32     
	 * @param data     
	 */
	public void put(E data){
		if(!isFull()){
			queue[size] = data;
			size ++;
		}
	}
	
	  
	/**     
	 * @description 删除队头并返回队头元素的值
	 * @author rico       
	 * @created 2017年5月19日 下午8:25:47     
	 * @return     
	 */
	public E pop(){
		if (!isEmpty()) {
			E temp = (E) queue[0];
			for (int i = 0; i < size - 1; i++) {
				queue[i] = queue[i+1];
			}
			queue[size-1] = null;
			size--;
			return temp;
		}
		return null;
	}
	
	  
	/**     
	 * @description 返回队头元素
	 * @author rico       
	 * @created 2017年5月19日 下午8:26:01     
	 * @return     
	 */
	public E peek(){
		if (!isEmpty()) {
			return (E) queue[0];
		}
		return null;
	}
	
	  
	/**     
	 * @description 队列是否已满
	 * @author rico       
	 * @created 2017年5月19日 下午8:26:14     
	 * @return     
	 */
	public boolean isFull(){
		return size == maxSize;
	}
	
	  
	/**     
	 * @description 队列是否为空
	 * @author rico       
	 * @created 2017年5月19日 下午8:26:25     
	 * @return     
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	  
	/**     
	 * @description 队列的大小
	 * @author rico       
	 * @created 2017年5月19日 下午8:26:34     
	 * @return     
	 */
	public int size(){
		return size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(queue);
	}
}
