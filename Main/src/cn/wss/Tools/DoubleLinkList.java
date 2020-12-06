package cn.wss.Tools;


/*
 * ˫������
 */
public class DoubleLinkList {

	//ͷ���
	private ListNode first;
	//β���
	private ListNode last;
	
	private int size;
	
	public DoubleLinkList() {
		first = null;
		last = null;
		size = 0;
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
		size++;
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
		size++;
	}
	
	/**
	 * ɾ��һ����㣬��ͷ�������ɾ��
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
	 * ɾ����㣬��β������ɾ��
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
	 * ��ʾ����
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
			size--;
		} else {
			current.prev.next = current.next;
			size--;
		}
		return current;
		
	}
	
	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	
	/**
	 * ��ȡ����
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
