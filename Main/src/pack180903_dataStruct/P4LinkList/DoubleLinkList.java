package pack180903_dataStruct.P4LinkList;


/*
 * ˫������
 */
public class DoubleLinkList {
	//ͷ���
	private ListNode first;
	//β���
	private ListNode last;
	
	public DoubleLinkList() {
		first = null;
		last = null;
	}
	
	/**
	 * ����һ����㣬��ͷ������в���
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
	}
	
	/**
	 * ����һ����㣬��β�����в���
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
	}
	
	/**
	 * ɾ��һ����㣬��ͷ�������ɾ��
	 */
	public ListNode deleteFirst() {
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
	 * ɾ����㣬��β������ɾ��
	 */
	public ListNode deleteLast() {
//		ListNode tmp = last;
		if(first.next == null) {
			first = null;
		} else {
			last.prev.next = null;
		}
		last = last.prev;
		return last;
	}
	
	/**
	 * ��ʾ����
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
	 * ���ҷ���
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
	 * ɾ������������������������ɾ��
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
		} else {
			current.prev.next = current.next;
		}
		return current;
		
	}
	
	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return (first == null);
	}
}
