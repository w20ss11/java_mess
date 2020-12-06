package pack180630_aimAtOffer;

import java.util.ArrayList;
import java.util.List;

public class T17ReverseKNode {
/**题目描述
	输入一个链表，输出该链表中倒数k个结点。
	=========================================
	解析：最佳代码：Java代码，通过校验。
	代码思路如下：两个指针，先让第一个指针和第二个指针都指向头结点，
	然后再让第一个指正走(k-1)步，到达第k个节点。
	然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了
*/
	

	public static void main(String[] args) {
		
	}

}
class Solution171 {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head==null || k==0)
    		return null;
    	ListNode p1 = head,p2=head;
    	for(int i=1;i<k;i++)
    		if(p1.next!=null)
    			p1 = p1.next;
    		else
    			return null;
    	while(p1.next!=null){
    		p1 = p1.next;
    		p2 = p2.next;
    	}
		return p2;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution17 {
    public ListNode FindKthToTail(ListNode head,int k) {
    	try {
    		List<Integer> list = new ArrayList<Integer>();
        	while(head!=null){
        		list.add(0, head.val);
        		head = head.next;
        	}
        	ListNode res = new ListNode(list.get(k-1));
        	ListNode point = res;
        	for(int i=k-2;i>=0;i--){
        		ListNode newNode = new ListNode(list.get(i));
        		point.next = newNode;
        		point = point.next;
        		
        	}
    		return res;
		} catch (Exception e) {
			return null;
		}
    }
}