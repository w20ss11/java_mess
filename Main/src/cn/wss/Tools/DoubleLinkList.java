package cn.wss.Tools;


/*
 * 双向链表
 */
public class DoubleLinkList {

	//头结点
	private ListNode first;
	//尾结点
	private ListNode last;
	
	private int size;
	
	public DoubleLinkList() {
		first = null;
		last = null;
		size = 0;
	}
	
	/**
	 * 插入一个结点，在头结点后进行插入
	 */
	public void insertFirst(int value) {
		ListNode ListNode = new ListNode(value);
		if(isEmpty()) {
			last = ListNode;
		} else {
			first.prev = ListNode;
		}
		ListNode.next = first;
		first = ListNode;
		size++;
	}
	
	/**
	 * 插入一个结点，从尾结点进行插入
	 */
	public void insertLast(int value) {
		ListNode ListNode = new ListNode(value);
		if(isEmpty()) {
			first = ListNode;
		} else {
			last.next = ListNode;
			ListNode.prev = last;
		}
		last = ListNode;
		size++;
	}
	
	/**
	 * 删除一个结点，在头结点后进行删除
	 */
	public ListNode deleteFirst() {
		if(!isEmpty())
			size--;
		ListNode tmp = first;
		if(first.next == null) {
			last = null;
		} else {
			first.next.prev = null;
		}
		first = tmp.next;
		return tmp;
	}
	
	/**
	 * 删除结点，从尾部进行删除
	 */
	public ListNode deleteLast() {
		ListNode tmp = last;
		if(!isEmpty())
			size--;
		if(first.next == null) {
			first = null;
		} else {
			last.prev.next = null;
		}
		last = last.prev;
		return tmp;
	}
	
	/**
	 * 显示方法
	 */
	public void display() {
		ListNode current = first;
		while(current != null) {
			System.out.print(current.val+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 * 查找方法
	 */
	public ListNode find(int value) {
		ListNode current = first;
		while(current.val != value) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	/**
	 * 删除方法，根据数据域来进行删除
	 */
	public ListNode delete(int value) {
		ListNode current = first;
		while(current.val != value) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		
		if(current == first) {
			first = first.next;
			size--;
		} else {
			current.prev.next = current.next;
			size--;
		}
		return current;
		
	}
	
	/**
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	
	/**
	 * 获取个数
	 */
	public int getSize() {
		return size;
	}
	public int getFirst(){
		return first.val;
	}
	public int getLast(){
		return last.val;
	}
	public void setFirst(int val){
		first.val = val;
	}
	public void setLast(int val){
		last.val = val;
	}
}
