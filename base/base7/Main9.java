package cn.cqupt.wss;

import java.util.Scanner;

public class Main9 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		int k = scanner.nextInt();
		System.out.println(fun(l1, k).m_nKey);
	}
	
	public static ListNode fun(ListNode head,int k) {
        ListNode one = head;
        ListNode two = head;
        if(head == null || k <= 0){
            return null;
        }
        two = inFun(k, one, two);
        return two;
    }

	private static ListNode inFun(int k, ListNode one, ListNode two) {
		for(int i = 0 ; i < k-1 ; i ++){
            if(one.next != null){
                one = one.next;
            }else{
                return null;
            }
        }
        while(one.next != null){
            one = one.next;
            two = two.next;
        }
		return two;
	}
	public static class ListNode {  
        public int m_nKey;  
        ListNode next = null;  
  
        public ListNode(int val) {  
            this.m_nKey = val;  
        }  
  
    }
}
