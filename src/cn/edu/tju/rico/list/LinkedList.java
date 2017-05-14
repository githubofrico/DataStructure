package cn.edu.tju.rico.list;

/**
 * Title: 链表的Java实现 
 * Description: 链表结构包含两个要素： 头结点head + 链表大小size，操作包括：
 * 				链表的增删
 * 				链表是否为空
 * 				链表的大小
 * 				链表的打印输出
 * 				删除链表重复节点
 *  			链表倒数第K个元素
 *  			链表的反转
 *  			链表的倒序输出
 *  			链表的中间节点
 *  			链表是否有环
 *  			链表节点的删除(不知道头结点的情况下)
 *  			链表是否相交
 *  			链表的交点
 * 
 * @author rico
 */
public class LinkedList<E> {

	private Node<E> head; // 链表表头
	private int size; // 链表大小

	public LinkedList() {
		head = new Node<E>(null);
	}

	public Node<E> getHead() {
		return head;
	}

	/**
	 * @description 向链表中指定位置的元素(0 - size),返回新节点
	 * @author rico
	 * @param data
	 * @param index
	 * @throws Exception
	 */
	public Node<E> add(E data, int index) throws Exception {
		if (index > size) {
			throw new Exception("超出范围...");
		}

		Node<E> cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		Node<E> node = new Node<E>(data); // 将新元素链入链表
		cur.next = node;
		size++;
		return node;
	}

	/**
	 * @description 向链表末尾添加元素,返回新节点
	 * @author rico
	 * @param data
	 * @throws Exception
	 */
	public Node<E> add(E data) throws Exception {
		return add(data, size);
	}
	
	/**     
	 * @description 向链表尾部添加新节点
	 * @author rico       
	 * @param node     
	 */
	public void add(Node<E> node){
		Node<E> cur = head;
		while(cur.next != null){
			cur = cur.next;
		}
		cur.next = node;
		
		while(node != null){
			size ++;
			node = node.next;
		}
	}

	/**
	 * @description 删除链表中指定位置的元素(0 ~ size-1)
	 * @author rico
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public E remove(int index) throws Exception {
		if (index > size - 1 || index < 0) {
			throw new Exception("超出范围...");
		}

		Node<E> cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}

		Node<E> temp = cur.next;
		cur.next = temp.next;
		temp.next = null;

		size--;
		return temp.data;
	}

	/**
	 * @description 向链表末尾删除元素
	 * @author rico
	 * @return
	 * @throws Exception
	 */
	public E remove() throws Exception {
		return remove(size - 1);
	}

	/**
	 * @description 删除链表中的重复元素(外循环 + 内循环)
	 * @author rico 时间复杂度：O(n^2)
	 */
	public void removeDuplicateNodes() {
		Node<E> cur = head.next;
		while (cur != null) { // 外循环
			Node<E> temp = cur;
			while (temp != null && temp.next != null) { // 内循环
				if (cur.data.equals(temp.next.data)) {
					Node<E> duplicateNode = temp.next;
					temp.next = duplicateNode.next;
					duplicateNode.next = null;
					size --;
				}
				temp = temp.next;
			}
			cur = cur.next;
		}
	}

	/**
	 * @description 找出单链表中倒数第K个元素(双指针法,相差K-1步)
	 * @author rico
	 * @param k
	 * @return 时间复杂度：O(n)
	 */
	public Node<E> getEndK(int k) {
		Node<E> pre = head.next;
		Node<E> post = head.next;
		for (int i = 1; i < k; i++) { // pre先走k-1步
			if (pre != null) {
				pre = pre.next;
			}
		}
		if (pre != null) {
			// 当pre走到链表末端时，post正好指向倒数第K个节点
			while (pre != null && pre.next != null) {
				pre = pre.next;
				post = post.next;
			}
			return post;
		}
		return null;
	}

	/**
	 * @description 反转链表
	 * @author rico
	 */
	public void reverseLinkedList() {
		Node<E> cur = head.next; // 原链表
		Node<E> pre = null; // 反转后的链表

		while (cur != null) { // 对原链表中的每个节点进行反转
			Node<E> next = cur.next; // 记录当前节点的下一个节点
			cur.next = pre; // 当前节点指向反转后的链表
			pre = cur; // 更新反转后的链表
			cur = next; // 更新当前节点
		}
		head.next = pre; // 将原链表的头结点指向反转后的链表
	}

	/**
	 * @description 判断单链表是否为空
	 * @author rico
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @description 打印输出单链表
	 * @author rico
	 */
	public void print() {
		Node<E> cur = head.next;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	/**
	 * @description 从尾到头输出单链表(递归法)
	 * @author rico
	 * @param head
	 */
	public void reversePrint(Node<E> head) {
		if (head.next != null) {
			reversePrint(head.next); // 不断"递去"
			System.out.print(head.next.data + " "); // "归来"开始打印
		}
	}

	/**
	 * @description 寻找单链表中的中间节点(双指针法)
	 * @author rico
	 */
	public void printMiddleNodes() {
		Node<E> index1 = head.next; // 慢指针
		Node<E> index2 = head.next; // 快指针
		if (head.next == null) {
			System.out.println(index1.data);
		}
		while (index2 != null && index2.next != null
				&& index2.next.next != null) {
			index1 = index1.next;
			index2 = index2.next.next;
		}
		System.out.print(index1.data); // 第一个中间节点
		if (index2.next != null) { // 当链表长度为偶数时，打印第二个中间节点
			System.out.println(index1.next.data);
		}
	}

	/**
	 * @description 判断单链表是否有环(双指针法)
	 * @author rico
	 * @return
	 */
	public boolean hasLoop() {
		Node<E> index1 = head.next; // 慢指针
		Node<E> index2 = head.next; // 快指针
		while (index2 != null && index2.next != null
				&& index2.next.next != null) {
			index1 = index1.next;
			index2 = index2.next.next;
			if (index1 == index2) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @description 在不知道头结点的前提下，删除指定节点
	 * @author rico
	 * @param node
	 * @return
	 */
	public boolean deleteNodeWithoutHead(Node<E> node) {
		if (node == null || node.next == null) { // 当指定节点为空或者为尾节点时，无法删除
			return false;
		}

		Node<E> next = node.next;

		// 将后继节点的内容复制到当前节点
		node.data = next.data;
		node.next = next.next;

		// 将后继节点清空
		next.next = null;
		next.data = null;
		return true;
	}

	/**     
	 * @description 判断当前链表与目标链表是否相交(相交与否取决于尾节点是否相同)
	 * @author rico       
	 * @param head
	 * @return     
	 */
	public boolean isIntersect(LinkedList<E> list2) {
		Node<E> cur1 = head.next;   // 当前链表
		Node<E> cur2 = list2.getHead().next;  // 目标链表
		
		// 两链表有一个为空，则返回 false
		if(cur1 == null || cur2 == null){
			return false;
		}
		
		// 遍历到第一个链表的尾节点
		while(cur1.next != null){
			cur1 = cur1.next;
		}
		
		// 遍历到第二个链表的尾节点
		while(cur2.next != null){
			cur2 = cur2.next;
		}
			
		return cur1 == cur2;  // 相交与否取决于尾节点是否相同
	}

	/**
	 * @description 返回两链表的交点(若不相交，返回null)
	 * @author rico
	 * @param head
	 * @return
	 */
	public Node<E> getIntersectionPoint(LinkedList<E> list2) {
		Node<E> cur1 = head.next;   // 当前链表
		Node<E> cur2 = list2.getHead().next;  // 目标链表
		
		if(this.isIntersect(list2)){  // 先判断是否相交
			// 让长度较长的链表先移动step步
			int step = Math.abs(list2.size - this.size);
			if(list2.size > this.size){
				while(step > 0){
					cur2 = cur2.next;
					step --;
				}
			}else if(list2.size < this.size){
				while(step > 0){
					cur1 = cur1.next;
					step --;
				}
			}
			
			//两个指针同时移动，一旦指向同一个节点，即为交点
			while(cur1 != cur2){
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}
		return null;
	}
	
	/**     
	 * @description 返回链表的长度
	 * @author rico       
	 * @return     
	 */
	public int size(){
		return size;
	}
}
