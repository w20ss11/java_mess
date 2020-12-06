package pack180903_dataStruct.P4LinkList;

/*
 * 双端链表
 */
public class FirstLastLinkList {
	//头结点
	private ListNode first;
	//尾结点
	private ListNode last;
	
	public FirstLastLinkList() {
		first = null;
		last = null;
	}
	
	/**
	 * 插入一个结点，在头结点后进行插入
	 */
	public void insertFirst(int value) {
		ListNode ListNode = new ListNode(value);
		if(isEmpty()) {
			last = ListNode;
		}
		ListNode.next = first;
		first = ListNode;
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
		}
		last = ListNode;
	}
	
	/**
	 * 删除一个结点，在头结点后进行删除
	 */
	public ListNode deleteFirst() {
		ListNode tmp = first;
		if(first.next == null) {
			last = null;
		}
		first = tmp.next;
		return tmp;
	}
	
	/**
	 * 显示方法
	 */
	public void display() {
		ListNode current = first;
		while(current != null) {
			System.out.println(current.val);
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
		ListNode previous = first;
		while(current.val != value) {
			if(current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		
		if(current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
		
	}
	
	/**
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return (first == null);
	}
}
