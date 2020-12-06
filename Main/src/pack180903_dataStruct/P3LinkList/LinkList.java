package pack180903_dataStruct.P3LinkList;
/*
 * �����൱�ڻ�
 */
public class LinkList {
	//ͷ���
	private ListNode first;
	
	public LinkList() {
		first = null;
	}
	
	/**
	 * ����һ����㣬��ͷ������в���
	 */
	public void insertFirst(int value) {
		ListNode ListNode = new ListNode(value);
		ListNode.next = first;
		first = ListNode;
	}
	
	/**
	 * ɾ��һ����㣬��ͷ�������ɾ��
	 */
	public ListNode deleteFirst() {
		ListNode tmp = first;
		first = tmp.next;
		return tmp;
	}
	
	/**
	 * ��ʾ����
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
