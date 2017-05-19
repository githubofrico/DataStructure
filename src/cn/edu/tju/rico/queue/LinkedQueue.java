package cn.edu.tju.rico.queue;

  
/**        
 * Title: 基于链表的队列实现  
 * Description: 含头结点(头结点不存储值,添加操作O(1))，尾指针(删除操作O(1))
 * @author rico       
 * @created 2017年5月19日 下午8:49:34    
 */      
    
public class LinkedQueue<E> {

	private Node<E> head;  // 头结点
	private Node<E> rear;   // 尾指针
	private int size;   // 队列大小
	
	public LinkedQueue(){
		head = rear = new Node<E>(null);
	}
	  
	/**     
	 * @description 添加元素到队尾
	 * @author rico       
	 * @created 2017年5月19日 下午8:52:20     
	 * @param data     
	 */
	public void put(E data){
		Node<E> node = new Node<E>(data);
		rear.next = node;
		rear = node;
		size ++;
	}
	  
	/**     
	 * @description 删除队头并返回队头元素的值
	 * @author rico       
	 * @created 2017年5月19日 下午8:52:24     
	 * @return     
	 */
	public E pop(){
		if(!isEmpty()){
			E e = null;
			Node<E> temp = head.next;
			head.next = temp.next;
			e = temp.data;
			
			temp.data = null;
			temp.next = null;
			size--;
			return e;		
		}
		return null;
	}
	  
	/**     
	 * @description 返回队头元素的值
	 * @author rico       
	 * @created 2017年5月19日 下午8:52:28     
	 * @return     
	 */
	public E peek() {
		if (!isEmpty()) {
			return head.next.data;
		}
		return null;
	}
	
	  
	/**     
	 * @description 队列是否为空
	 * @author rico       
	 * @created 2017年5月19日 下午8:52:33     
	 * @return     
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	  
	/**     
	 * @description 队列大小
	 * @author rico       
	 * @created 2017年5月19日 下午8:52:35     
	 * @return     
	 */
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Node<E> cur = head.next;
		StringBuilder sb = new StringBuilder();
		while(cur != null){
			sb.append(cur.data).append(" ");
			cur = cur.next;
		}
		return sb.toString();
	}
}
