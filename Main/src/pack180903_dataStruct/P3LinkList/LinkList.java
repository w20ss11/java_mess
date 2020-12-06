package pack180903_dataStruct.P3LinkList;
/*
 * 链表，相当于火车
 */
public class LinkList {
	//头结点
	private ListNode first;
	
	public LinkList() {
		first = null;
	}
	
	/**
	 * 插入一个结点，在头结点后进行插入
	 */
	public void insertFirst(int value) {
		ListNode ListNode = new ListNode(value);
		ListNode.next = first;
		first = ListNode;
	}
	
	/**
	 * 删除一个结点，在头结点后进行删除
	 */
	public ListNode deleteFirst() {
		ListNode tmp = first;
		first = tmp.next;
		return tmp;
	}
	
	/**
	 * 显示方法
	 */
	public void display() {
		ListNode current = first;
		while(current != null) {
			System.out.println(current.val);;
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
}
