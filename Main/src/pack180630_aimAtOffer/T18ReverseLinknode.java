package pack180630_aimAtOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
	输入一个链表，反转链表后，输出新链表的表头。
 * */
public class T18ReverseLinknode {

	public static void main(String[] args) {
		ListNode l = new ListNode(2);
		l.next = new ListNode(3);
		l.next.next = new ListNode(4);
		l.next.next.next = new ListNode(5);
		new Solution181().ReverseList(l);
	}

}

class Solution181 {
    public ListNode ReverseList(ListNode head) {
    	if(head == null)
            return null;
    	if(head.next==null)
    		return head;
    	ListNode prev = null;
    	ListNode curr = head;
    	ListNode next = null;
    	while(curr.next!=null){
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	curr.next = prev;
		return curr;
    }
}
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
class Solution18 {
    public ListNode ReverseList(ListNode head) {
    	if(head==null)
    		return head;
    	List<Integer> list = new ArrayList<>();
    	while(head != null){
    		list.add(0,head.val);
    		head = head.next;
    	}
    	
    	ListNode res = new ListNode(list.get(0));
    	ListNode point = res;
    	for(int i=1;i<list.size();i++){
    		ListNode temp = new ListNode(list.get(i));
    		point.next = temp;
    		point = point.next;
    	}
		return res;
    }
}